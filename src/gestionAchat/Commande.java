package gestionAchat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Commande {
	
	// Les attributs :
	private long numCommande;
	private String date,adresseCommande;
	LigneCommande LigneComd;
	
	// Constructeurs :
	Commande(){
		this.numCommande=0;
		this.date="";
		this.adresseCommande="";
	}
	
	Commande(long numCommande, String date, String adresseCommande){
		this.numCommande=numCommande;
		this.date=date;
		this.adresseCommande=adresseCommande;
	}

	// Getters & Setters :
	public long getNumCommande() {
		return numCommande;
	}

	public void setNumCommande(long numCommande) {
		this.numCommande = numCommande;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAdresseCommande() {
		return adresseCommande;
	}

	public void setAdresseCommande(String adresseCommande) {
		this.adresseCommande = adresseCommande;
	}
	
	// Les méthodes :
	
	// Méthode pour afficher la liste de commande enregistré dans la base des données :
	public void listeCommande() throws ClassNotFoundException, SQLException {

        Statement stmt =null;
        
        MyConnection maC = new MyConnection();
        stmt = maC.getC().createStatement();
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM commande");
        
        System.out.println("\n\n \t ****** La liste des commandes ****** \n\n");
        while(rs.next()){      	 
        	System.out.println("\t         #"+rs.getString("numCommande")+" | "+rs.getString("adresse")+"\n");
        }
	}
	
	// Méthode pour supprimer une commande :
	public void supprimerCommande() throws ClassNotFoundException, SQLException {
		Scanner sc1= new Scanner(System.in);
        Statement stmt =null;
        
        MyConnection maC = new MyConnection();
        stmt = maC.getC().createStatement();
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM commande");
        System.out.println("\n\n \t ****** liste des commandes validées ****** \n");
        while(rs.next()){      	 
        	System.out.println("\n \t         #"+rs.getString("numCommande")+" | "+rs.getString("adresse")+"\n");
        }
        
        System.out.println("\n --> Parmi les commandes au dessus, tapez le numéro de commande qui vous voulez supprimer \n\n * N° Commande :");
        long numCmd=sc1.nextLong();
        // Suppression :
    	stmt = maC.getC().createStatement();
    	String req = "DELETE FROM commande WHERE numCommande='"+numCmd+"'";
    	stmt.executeUpdate(req);
    	System.out.println(" \n La commande est supprimée avec succés !" );
	}
	
	// Méthode pour calculer montant total d'une commande (Facture) :
	public void montantAPayer(String numCmd) throws ClassNotFoundException, SQLException {
        Statement stmt =null;
        
        MyConnection maC = new MyConnection();
        stmt = maC.getC().createStatement();
        
        ResultSet rs1 = stmt.executeQuery("SELECT SUM(LC.quantite*L.prixUnitaire) AS PrixTotal FROM lignecommande LC, livres L WHERE LC.numCommande='"+numCmd+"' AND LC.refLivre=L.refLivre");
                
        while(rs1.next()){
        	System.out.println(" \t \t \t Montant total à payer = "+rs1.getString("PrixTotal")+" DT \n\n");
        }
	}
	
	// Méthode affiche facture :
	public void afficheFacture() throws ClassNotFoundException, SQLException {
		
	    Scanner sc= new Scanner(System.in);
        System.out.println("\n --> Pour voir la facture, s'il vous plait tapez le numéro de commande :" );
        String numCmd=sc.nextLine();
        
        Statement stmt =null;
        
        MyConnection maC = new MyConnection();
        stmt = maC.getC().createStatement();
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM commande WHERE numCommande='"+numCmd+"'");
                
        while(rs.next()){
        	
    		System.out.println(" \n\n-------------------------------------------------- Facture -------------------------------------------------- \n");
    		System.out.println(" \t\t  * Numéro de commande : #"+rs.getString(1)+"\n");
    		System.out.println(" \t\t  * Adresse : "+rs.getString(3)+"\n");
    		System.out.println(" \t\t  * Date : "+rs.getString(2)+"\n\n");       	
    		montantAPayer(numCmd);
    		System.out.println("-------------------------------------------------- ******* --------------------------------------------------\n");
        }
	}
	
}
