package gestionAchat;

import java.sql.*;
import java.util.Scanner;
import java.util.Vector;

public class Livre {
	
	// Les attributs :
	private String refLivre, titre, auteur, dateSortie;
	private int quantite;
	private long prixUnitaire;
	
	
	// Constructeur :
	Livre (){
		this.refLivre="";
		this.titre="";
		this.auteur="";
		this.dateSortie="";
		this.quantite=0;
		this.prixUnitaire=0;
	}
	
	Livre (String refLivre, String titre, String auteur, String dateSortie, int quantite, long prixUnitaire){
		this.refLivre=refLivre;
		this.titre=titre;
		this.auteur=auteur;
		this.dateSortie=dateSortie;
		this.quantite=quantite;
		this.prixUnitaire=prixUnitaire;
	}

	// Getters & Setters :

	public String getRefLivre() {
		return refLivre;
	}

	public void setRefLivre(String refLivre) {
		this.refLivre = refLivre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(String dateSortie) {
		this.dateSortie = dateSortie;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public long getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(long prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	
	// les méthodes :
	
	// Méthode d'ajout
	public void ajouterLivre() throws ClassNotFoundException, SQLException {
        Scanner sc= new Scanner(System.in);
        System.out.println(" ****  Ajouter un livre  **** \n\n* Réf livre :" );
        String refLivre=sc.nextLine();
        System.out.println(" * Titre de livre :");
        String titre=sc.nextLine();
        System.out.println(" * Nom d'auteur :");
        String auteur=sc.nextLine();
        System.out.println(" * Date de sortie (jj/mm/aaaa) :");
        String dateSortie=sc.nextLine();
        System.out.println(" * Quantité de stock : ");
        int quantite=sc.nextInt();
        System.out.println(" * Prix unitaire : ");
        int prixUnitaire=sc.nextInt();
        
        Statement stmt =null;
        MyConnection maC = new MyConnection();
        // Test de connectivité :
        if(maC == null){
            System.out.println(" \n Problème de connexion à la source de données...");
        }else{
            // Suppression :
        	stmt = maC.getC().createStatement();
        	String req = "insert into livres values( '" +refLivre + "', '"+ titre + "','"+ auteur + "','"+ dateSortie + "'," +quantite + ", " + prixUnitaire + ")";
        	stmt.executeUpdate(req);
        	System.out.println(" \n Le livre est ajouté avec succés " );
        }
	}
	
	// Méthode suppression d'un livre :
	public void supprimerLivre() throws ClassNotFoundException, SQLException {

        Scanner sc= new Scanner(System.in);
        System.out.println(" ****  Supprimer un livre  **** \n\n* Réf livre :" );
        String refLivre=sc.nextLine();
        Statement stmt =null;
        
        MyConnection maC = new MyConnection();
        // Test de connectivité :
        if(maC == null){
            System.out.println(" \n Problème de connexion à la source de données...");
        }else{
            // Suppression :
        	stmt = maC.getC().createStatement();
        	String req = "DELETE FROM livres WHERE refLivre='"+refLivre+"'";
        	stmt.executeUpdate(req);
        	System.out.println(" \n Le livre est supprimé avec succés !" );
        }
	}
	
	// Méthode lister les livres :
	public void listeLivres () throws ClassNotFoundException, SQLException {
        Statement stmt =null;
       
        MyConnection maC = new MyConnection();
        stmt = maC.getC().createStatement();
        
        ResultSet rs = stmt.executeQuery("select * from livres");
        int i=0;
        while(rs.next())
        {
        	i=i+1;
			System.out.println(" ******  Les caractéristiques du livre "+i+" ****** \n" );
			System.out.println(" * Réf Livre : "+rs.getString(1));
			System.out.println("\n * Titre de livre : "+rs.getString(2));
			System.out.println("\n * Auteur de livre : "+rs.getString(3));
			System.out.println("\n * Date de sortie : "+rs.getString(4));
			System.out.println("\n * Quantite de stock : "+rs.getString(5));
			System.out.println("\n * Prix unitaire : "+rs.getString(6));
			System.out.println("____________________________________________________________________ \n");
       
        }
	}
	
}

