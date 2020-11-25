package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba","root",""); 
            
            Statement st;
            
            if(con != null)
            {
                st = con.createStatement();
                
                
                /*
                    Insert
                */
                
                st.execute("insert into productos (nombre, precio) values ('Leche', '35.5')");
                
                
                
                ResultSet rs = st.executeQuery("select * from productos; ");
                
                while(rs.next())
                {
                    System.out.println("Id: " + rs.getString("id"));
                    System.out.println("Nombre: " + rs.getString("nombre"));
                    System.out.println("Precio: " + rs.getString("precio"));
                    System.out.println("-----------------------------------------");
                    System.out.println("");
                }
            }
            
        }
        catch(Exception e){
        
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
}
