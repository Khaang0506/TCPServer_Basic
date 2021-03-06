/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab05_bai5;

import java.net.ServerSocket;
import java.net.Socket;
import tcpserver.ServerThread;
import tcpserver.TCPServer;

/**
 *
 * @author Khang's PC
 */
public class Server {
    static final int PORT = 8888;
    private ServerSocket server = null;
    public Server(){
        try {
            server = new ServerSocket(PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void action(){
        Socket socket = null;
        int i = 0;
        System.out.println("Server is listening...");
        try {
            while((socket=server.accept())!=null){
                new ServerThread(socket,"Client#"+i);
                System.out.printf("Thread for Client#%d generating...%n",i++);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Server().action();
    }
}
