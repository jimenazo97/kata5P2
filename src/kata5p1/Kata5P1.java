/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andresjimenez
 */
public class Kata5P1 {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        Class.forName("org.sqlite.JDBC");	
        Connection con=DriverManager.getConnection("jdbc:sqlite:KATAS.db");
        
        Statement st;
        st = con.createStatement();
        
        String query= "SELECT * FROM PEOPLE";
        ResultSet res= st.executeQuery(query);
        while(res.next()){
            System.out.println(res.getInt(1));
            System.out.println(res.getString(2));
        }
    }
    
}
