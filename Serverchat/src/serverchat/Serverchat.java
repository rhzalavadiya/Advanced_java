
package serverchat;
import java.io.*;
import java.net.*;
public class Serverchat {
    private ServerSocket server;
    private int port=5600;
    public Serverchat()
    {
        try{
            server=new ServerSocket(port);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Serverchat server=new Serverchat();
        server.connection();
    }
    public void connection()
    {
        System.out.println("Wait for Time");
        try{
            Socket soc=server.accept();
            System.out.println("client Accepted : - "+ soc);
            DataInputStream dis=new DataInputStream(new BufferedInputStream(soc.getInputStream()));
            boolean done=false;
            while(!done){
               try{
                   String line=dis.readUTF();
                   System.out.println(line);
                   done=line.equals("bye");
               }
               catch(IOException e){
                   done=true;
               }
            }
            dis.close();
            soc.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
