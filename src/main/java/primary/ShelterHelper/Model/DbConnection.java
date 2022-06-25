package primary.ShelterHelper.Model;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.SQLRecoverableException;

public class DbConnection {

    public Connection databaselink;

     public Connection getConnection()
     {
         String databasename="shelterhelper";
         String url="jdbc:mysql://localhost/"+databasename;
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             databaselink= DriverManager.getConnection(url,"root","12345678");
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
        return databaselink;
     }



}
