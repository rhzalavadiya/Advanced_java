/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;
import java.sql.*;
public class P1 {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from stud ");
            while(rs.next())
                System.out.println(rs.getInt(1)+" | "+rs.getString(2));
            con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    
}
