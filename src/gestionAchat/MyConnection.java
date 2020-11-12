package gestionAchat;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyConnection {
    private Connection c =null;    
    
    public MyConnection() throws ClassNotFoundException, SQLException
    {
        // chargement du pilote sp�cifique au pilote de BD (soit ODBC ou Driver personnalis� du SGBD):
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // D�finition du contexte de la connection (URL de la connection):
        String url = "jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC";
        // r�cuperer une r�ference vers la connexion � la base de donn�es (source de donn�es) en question :
        c = DriverManager.getConnection(url,"root","");
    }
    
    public Connection getC()
    {
        return c;
    }
}

