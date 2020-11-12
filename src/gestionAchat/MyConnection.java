package gestionAchat;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyConnection {
    private Connection c =null;    
    
    public MyConnection() throws ClassNotFoundException, SQLException
    {
        // chargement du pilote spécifique au pilote de BD (soit ODBC ou Driver personnalisé du SGBD):
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Définition du contexte de la connection (URL de la connection):
        String url = "jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC";
        // récuperer une réference vers la connexion à la base de données (source de données) en question :
        c = DriverManager.getConnection(url,"root","");
    }
    
    public Connection getC()
    {
        return c;
    }
}

