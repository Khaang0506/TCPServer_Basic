/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpchat_bai3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Khang's PC
 */
public class ThreadChat implements Runnable{
    private Scanner in = null;
    private Socket socket = null;
    public frmClient chat = null;
    ServerSocket server = null;
    
    public ThreadChat(){
        try {
            server = new ServerSocket(4567);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(this).start();
    }
    
    public void run(){
        try {
            while(true){
                while((socket = server.accept())!=null){
                    this.in = new Scanner(this.socket.getInputStream());
                    String chuoi = in.nextLine().trim();
                    chat.Hienthi(chuoi+"\n");
                }
            }
        } catch (Exception e) {
        }finally{
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }
}
