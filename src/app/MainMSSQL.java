package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class MainMSSQL {
    
    public static void main(String[] args) {

        try
        {
            String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;"
                    + "databaseName=prueba;"
                    + "user=sa;"
                    + "password=1234";
            
            Connection con = DriverManager.getConnection(connectionUrl); 
            
            
            Statement st;
            
            if(con != null)
            {
                st = con.createStatement();
                
                
                /*
                    Insert
                */
                
                st.execute("insert into productos (nombre, precio) values ('Chocolate', '25.3')");
                
                
                
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
