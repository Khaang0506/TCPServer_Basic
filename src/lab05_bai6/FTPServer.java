/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab05_bai6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Khang's PC
 */
public class FTPServer {
    //khai báo các hằng trong giao thức giao tiếp
    public static final int DANGNHAP=1;
    public static final int KHONGLALENH=0;
    public static final int DANGNHAPKHONGTHANHCONG=0;
    public static final int DANGNHAPTHANHCONG=1;
    public static final int THOAT=2;
    public static final int UPLOAD=3;
    public static final int DOWNLOAD=4;
    //hàm đổi chuỗi giao tiếp thành hàng cho dễ xử lý
    public static int laLenh(String cmd){
        if(cmd.equals("DANGNHAP"))
            return DANGNHAP;
        if(cmd.equals("UPLOAD"))
            return UPLOAD;
        if(cmd.equals("DOWNLOAD"))
            return DOWNLOAD;
        return KHONGLALENH;
    }
    //thiết lập port giao tiếp của ứng dụng, FTP có port là 20 và 21
    //ví dụ chọn port 10000
    public static final int PORT = 10000;
    public static void main(String[] args) {
        //giả sử có user, pass, path
        //sinh viên thay 1 user này bằng cách truy xuất csdl
        //các user đã tạo ra ở bước 1 do chương trình quản lý user
        DBAccess db = new DBAccess();
        ServerSocket s;
        String path = null;
        try {
            System.out.println("Server đang lắng nghe...");
            s = new ServerSocket(PORT);
            while(true){
                Socket new_s = s.accept();
                //nhận lệnh giao tiếp từ client
                boolean lap = true;
                
                while(lap){
                    String cmd;
                    Scanner sc = new Scanner(new_s.getInputStream());
                    
                    cmd=sc.nextLine();
                    
                    //điều phối sự kiện yêu cầu ở phải client
                    switch(laLenh(cmd)){
                        case DANGNHAP:
                            String username=sc.nextLine();
                            String password=sc.nextLine();
                            ResultSet rs = db.Query("select * from taikhoan where username='" + username + "'and password='" + password + "'");
                            PrintWriter pw;
                            pw=new PrintWriter(new_s.getOutputStream());
                            if(rs.next()){
                                path = rs.getString("path");
                                pw.println(DANGNHAPTHANHCONG);
                                //JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
                                //Mở thư mục lên gởi về cho client
                                File dir = new File(path);
                                File dsFile[]=dir.listFiles();
                                if(dsFile==null){
                                    JOptionPane.showMessageDialog(null, "Đường dẫn không đúng hay không phải thư mục!!!");
                                }else{
                                    pw.println(dsFile.length);
                                    for(int i=0;i<dsFile.length;i++)
                                        pw.println(dsFile[i].getName());
                                }
                            }else{
                                //gởi về không mở được
                                //JOptionPane.showMessageDialog(null, "Đăng nhập không thành công!");
                                pw.println(DANGNHAPKHONGTHANHCONG);
                                pw.println("Đăng nhập không thành công");
                            }
                            pw.flush();
                            break;
                        case UPLOAD:
                            
                            System.out.println("Đã vào lệnh upload");
                            String fileName = sc.nextLine();
                            System.out.println("Đã lấy tên tập tin");
                            try {
                                String path2;
                                //kiểm tra chuỗi đường dẫn có dấu / cuối cùng hay không
                                //và gắn tên tập tin từ client vào tương ứng
                                if(path.lastIndexOf("/")>=(path.length()-1))
                                    path2 = path + fileName;
                                else
                                    path2 = path + "/" +fileName;
                                System.out.println(path2);
                                FileOutputStream fos = new FileOutputStream(new File(path2));
                                BufferedOutputStream bos = new BufferedOutputStream(fos);
                                BufferedInputStream bis = new BufferedInputStream(new_s.getInputStream());
                                byte buf[] = new byte[bis.available()];
                                bos.write(bis.read(buf));
                                bos.flush();
                                bos.close();
                                pw = new PrintWriter(new_s.getOutputStream());
                                pw.println("DANHAN");
                                pw.flush();
                                //yêu cầu update lại listbox ở server
                                //mở thư mục ra và trả về nội dung thư mục ở phía server
                                FTPServer.traThuMucClient(path,pw);
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        case DOWNLOAD:
                            //lay ten tap tin do client goi len
                            System.out.println("Da vao lenh download");
                            String fileNameD = sc.nextLine();
                            System.out.println("Da lay ten tap tin");
                            try {
                                String cpath;
                                //kiem tra chuoi duong dan co dau / cuoi cung hay ko?
                                //va gan ten tap tin tu client vao tuong ung
                                if (path.lastIndexOf("/") >= path.length() - 1) {
                                    cpath = path + fileNameD;
                                } else {
                                    cpath = path + "/" + fileNameD;
                                }
                                System.out.println(cpath);
                                //mo tap tin ra
                                BufferedInputStream bis;
                                bis = new BufferedInputStream(new FileInputStream(cpath));
                                //lap doc noi dung tap tin va goi lieu len server
                                byte buf[] = new byte[bis.available()];
                                //tao bo dem doc het du lieu tu tap tin vao bo dem roi day
                                //vao luong len server.
                                BufferedOutputStream bos;
                                bos = new BufferedOutputStream(new_s.getOutputStream());
                                bos.write(bis.read(buf));
                                System.out.println("da goi du lieu tap tin ve cho client");
                                bos.flush();
                                //doi nhan danh sach tap thu cua folder o server voi tinh trang moi
                                Scanner scRequest = new Scanner(new_s.getInputStream());
                                String cmdRequest = scRequest.nextLine();
                                System.out.println("da nhan dap tra tu server");
                                if (cmdRequest.equals("DANHAN")) 
                                    System.out.println("Đã gửi tập tin thành công");
                                else
                                    System.out.println("Gửi tập tin thất bại");
                                
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        case THOAT:
                            lap=false;
                            break;
                    }
                }
                new_s.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    static void traThuMucClient(String path, PrintWriter out){
        try {
            File dir = new File(path);
            File dsFile[];
            System.out.println("Đang đọc tập tin");
            try {
                dsFile = dir.listFiles();
                System.out.println("Đã là ds tập tin");
                out.println(dsFile.length);
                for(int i=0; i<dsFile.length; i++){
                    String filename = dsFile[i].getName();
                    out.println(filename);
                }
                out.flush();
                System.out.println("Đã gởi client");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
