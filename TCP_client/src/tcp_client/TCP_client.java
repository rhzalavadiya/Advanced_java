package tcp_client;
import java.net.*;
import java.util.*;
import java.io.*;
public class TCP_client {
    public static void main(String[] args) throws Exception{
        Socket s=new Socket("localhost",6666);
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Array Size : - ");
        int n=sc.nextInt();
        int a[]=new int[n];
        System.out.println("Enter Element : - ");
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        dout.writeInt(n);
        for(int i=0;i<n;i++){
            int r=sc.nextInt();
            dout.writeInt(r);
        }
        DataInputStream din=new DataInputStream(s.getInputStream());
        int r;
        System.out.println("Sorted Array");
        for(int i=0;i<n;i++){
            r=din.readInt();
            System.out.println(r+"  ");
        }
        s.close();
    }  
}
