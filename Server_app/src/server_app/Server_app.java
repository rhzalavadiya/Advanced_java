package server_app;
import java.io.*;
import java.net.*;
public class Server_app {
    public static void main(String[] args) {
        try{
            ServerSocket ss=new ServerSocket(6666);
            Socket s=ss.accept();
            DataInputStream ds=new DataInputStream(s.getInputStream());
            String str=(String)ds.readUTF();
            System.out.println("Message : - "+str);
            ss.close();
        } 
        catch(Exception e){
            System.out.println(e);
        }
    }
}
