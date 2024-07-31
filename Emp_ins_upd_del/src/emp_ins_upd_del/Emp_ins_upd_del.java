
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp_ins_upd_del;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class Emp_ins_upd_del {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
            Statement st = con.createStatement();
            String ins="insert into emp(eid,enm) value (5,'Ekta')";
            st.executeUpdate(ins);
            String upd="update emp set enm='Drashti' where eid=1";
            st.executeUpdate(upd);
            String del="delete from emp where eid=4";
            st.executeUpdate(del);
            ResultSet rs = st.executeQuery("select * from emp ");
            while(rs.next())
                System.out.println(rs.getInt(1)+" | "+rs.getString(2));
            con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    
}
   
