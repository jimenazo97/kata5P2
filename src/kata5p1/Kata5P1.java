/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
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
        
        String query1="create table  if not exists Mail ('id' integer PRIMARY KEY AUTOINCREMENT,'mail' text not null)";
        st.execute(query1);
        String emails="emailsfile.txt";
        muestraContenido(emails);
    }    
        
    /**
     *
     * @param emails
     * @throws FileNotFoundException
     * @throws IOException
     * @throws java.sql.SQLException
     */
    public static void muestraContenido(String emails) throws FileNotFoundException, IOException, SQLException {
      Connection cone=DriverManager.getConnection("jdbc:sqlite:KATAS.db");
      String mail;
      FileReader f = new FileReader(emails);
        try (BufferedReader b = new BufferedReader(f)) {
            while((mail = b.readLine())!=null) {
                String query="insert into Mail(mail) values('" + mail + "')";
                Statement st1;
                st1=cone.createStatement();
                st1.executeUpdate(query);
            } 
        }       
        
        
        
        
    }
}  
    

