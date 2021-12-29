/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab05_bai6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Khang's PC
 */
public class frmClient extends javax.swing.JFrame {

    /**
     * Creates new form frmClient
     */
    public frmClient() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fchPath = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        txtDomain = new javax.swing.JTextField();
        btnUp = new javax.swing.JButton();
        btnDownload = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnBrowser = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstPath = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstClientPath = new javax.swing.JList<>();
        txtPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Domain:");

        btnUp.setText("Up");
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });

        btnDownload.setText("Download");
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });

        jLabel2.setText("User");

        jLabel3.setText("Pass");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnBrowser.setText("Browser");
        btnBrowser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowserActionPerformed(evt);
            }
        });

        jLabel4.setText("Client's Folder");

        jLabel5.setText("Server Folder");

        lstPath.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(lstPath);

        lstClientPath.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstClientPath);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtDomain, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnUp)
                                .addGap(18, 18, 18)
                                .addComponent(btnDownload))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLogin)
                                    .addComponent(btnBrowser, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDomain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUp)
                    .addComponent(btnDownload))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnBrowser)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Socket s;
    public static final int PORT = 10000;
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        //tạo socket
        String domain = this.txtDomain.getText();
        try {
            InetAddress ia = InetAddress.getByName(domain);
            try {
                s = new Socket(ia, PORT);
                //gởi user, pass lên server
                PrintWriter pw = new PrintWriter(s.getOutputStream());
                //lấy dữ liệu từ form đó sử dụng gõ vào
                String user = this.txtUser.getText();
                String pass = this.txtPass.getText();
                String cmd = "DANGNHAP";
                pw.println(cmd);
                pw.println(user);
                pw.println(pass);
                System.out.println(cmd);
                System.out.println(user);
                System.out.println(pass);
                pw.flush();
                //client đợi phản hồi từ server
                Scanner sc = new Scanner(s.getInputStream());
                int cmdR = sc.nextInt();
                if(cmdR==1){
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
                    //lưu đường dẫn hiện tại mà list hiển thị danh sách tập tin trong thư mục đó
                    DefaultListModel dm = new DefaultListModel();
                    int n = sc.nextInt();
                    for(int i=0;i<n;i++){
                        dm.addElement(sc.nextLine());
                    }
                    this.lstPath.setModel(dm);
                }else{
                    JOptionPane.showMessageDialog(this, "Đăng nhập không thành công!!!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    String path;
    private void btnBrowserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowserActionPerformed
        // TODO add your handling code here:
        fchPath.setVisible(true);
        //thiết lập
        fchPath.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //kiểm tra form này được chọn nút gì?
        if(fchPath.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
            try {
                path = fchPath.getSelectedFile().getCanonicalPath();
                File dir = new File(path);
                File dsFile[] = dir.listFiles();
                if(dsFile==null){
                    JOptionPane.showMessageDialog(null, "Sai đường dẫn");
                }else{
                    try {
                        //lưu đường dẫn hiện tại mà list hiển thị danh tập
                        //tin trong folder đó
                        DefaultListModel dm = new DefaultListModel();
                        for(int i=0; i<dsFile.length;i++){
                            String filename = dsFile[i].getName();
                            dm.addElement(filename);
                        }
                        this.lstClientPath.setModel(dm);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.toString());
                    }
                }
            } catch (Exception e) {
            }
    }//GEN-LAST:event_btnBrowserActionPerformed

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
        // TODO add your handling code here:
        String fileName = (String) this.lstClientPath.getSelectedValue();
        String cpath = path+"\\"+fileName;
        System.out.println(cpath);
        try {
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            //gởi tín hiệu lệnh
            pw.println("UPLOAD");
            pw.flush();
            System.out.println("Đã gởi lệnh upload len server");
            pw.println(fileName);
            pw.flush();
            System.out.println("Đã gởi tên tập tin lên server");
            BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
            DataOutputStream dos = new DataOutputStream(bos);
            //mở tập tin ra
            BufferedInputStream bis= new BufferedInputStream(new FileInputStream(cpath));
            //lap đọc nội dung tập tin và gởi liệu lên server
            byte buf[] = new byte[bis.available()];
            //tạo bộ đếm đọc hết dữ liệ từ tập tin vào bộ đếm rồi đẩy
            //vào luồng lên server.
            bos.write(bis.read(buf));
            System.out.println("Đã gởi dữ liệu tập tin lên server");
            bos.flush();
            //bis.close();
            //đợi nhận danh sách tập thư của folder ở server với tình trạng mới
            Scanner sc = new Scanner(s.getInputStream());
            String cmd = sc.nextLine();
            System.out.println("Đã nhận đáp trả từ server");
            if(cmd.equals("DANHAN")){
                JOptionPane.showMessageDialog(null, "Đã gửi tập tin thành công");
                
            }else{
                JOptionPane.showMessageDialog(null, "Gửi tập tin thất bại");
            }
            //nhận update
            updateFolderServer();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnUpActionPerformed

    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
        // TODO add your handling code here:
        //lay tap tin can download
        String fileName = (String) this.lstPath.getSelectedValue();
        System.out.println(fileName);
        try {
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            //goi tin hieu lenh
            pw.println("DOWNLOAD");
            pw.flush();
            System.out.println("Da goi lenh download len server");
            pw.println(fileName);
            pw.flush();
            //doi server goi noi dung tap tin ve
            System.out.println("Doi server goi noi dung tap tin ve");
            String cpath = path + "\\" + fileName;
            FileOutputStream fos;
            fos = new FileOutputStream(new File(cpath));
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
            byte buf[] = new byte[bis.available()];
            bos.write(bis.read(buf));
            bos.flush();
            bos.close();
            pw = new PrintWriter(s.getOutputStream());
            pw.println("DANHAN");
            pw.flush();
            //cap nhat lai thu muc client vua download
            this.capNhatClientFolder(cpath);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnDownloadActionPerformed

    private void capNhatClientFolder(String cpath) {
        //mo thu muc voi duong dan path ra
        File dir = new File(path);
        File dsFile[] = dir.listFiles();
        if (dsFile == null) {
            JOptionPane.showMessageDialog(null, " Duong dan sai!");
        } else {
            try {
                //luu duong dan hien tai ma list hien thi danh tap tin trong folder do.
                //path=txtPath.getText();
                DefaultListModel dm = new DefaultListModel();
                for (int i = 0; i < dsFile.length; i++) {
                    String filename = dsFile[i].getName();
                    dm.addElement(filename);
                }
                this.lstClientPath.setModel(dm);
                this.validate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }
    public void updateFolderServer(){
        try {
            BufferedInputStream bi = new BufferedInputStream(s.getInputStream());
            Scanner sc = new Scanner(bi);
            DefaultListModel dm  = new DefaultListModel();
            //server gởi về số lượng tập tin thư mục sau khi upload
            int n = sc.nextInt();
            System.out.println("Đã nhận được số lượng tập tin gởi từ server");
            //nhận tên từng tập tin thư mục
            for(int i=0; i<n; i++){
                String filename = sc.nextLine();
                dm.addElement(filename);
            }
            System.out.println("Đã hiển thị xong danh sách tập tin");
            //hiển thị lên form
            this.lstPath.setModel(dm);
            //về lại giao diện
            this.validate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi", e.toString(), JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowser;
    private javax.swing.JButton btnDownload;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnUp;
    private javax.swing.JFileChooser fchPath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> lstClientPath;
    private javax.swing.JList<String> lstPath;
    private javax.swing.JTextField txtDomain;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}