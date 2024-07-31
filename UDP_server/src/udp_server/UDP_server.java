package udp_server;
import java.net.*;
import java.util.*;
import java.io.*;
public class UDP_server {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds=new DatagramSocket(3000);
        byte[] buf=new byte[1024];
        DatagramPacket dp=new DatagramPacket(buf,1024);
        ds.receive(dp);
        String str=new String(dp.getData(),0,dp.getLength());
        String[] strs= str.split(" ");
        List<Integer> list=new ArrayList<>();
        for(String s: strs){
            try{
                list.add(Integer.parseInt(s));
            }
            catch(Exception e){
            }
        }
        Collections.sort(list);
        StringBuilder sb=new StringBuilder();
        for(int a:list){
            sb.append(a);
            sb.append(" ");
        }
        String s=sb.toString();
        DatagramPacket sorted=new DatagramPacket(s.getBytes(),s.length(),dp.getAddress(),dp.getPort());
        ds.send(sorted);
        System.out.println("Data Send : ");
        System.out.println(str);
        ds.close();
    }
}
