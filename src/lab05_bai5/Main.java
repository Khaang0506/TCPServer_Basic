/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab05_bai5;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Khang's PC
 */
public class Main {
    public static void main(String[] args) {
        String host="localhost";
if(args.length>0){
host=args[0];
}

for(int i=0;i<1024;i++){
try{
Socket s=new Socket(host,i);
System.out.println("Co mot server dang hoat dong  tren cong: "+i);
} catch(UnknownHostException e){
System.err.println(e);
} catch(IOException e){
System.err.println(e);
}
    }
}
}
