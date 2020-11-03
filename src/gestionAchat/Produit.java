package gestionAchat;

import java.util.Scanner;
import java.util.Vector;

public class Produit {
	
	// Les attributs :
	private String refProduit, designation;
	private int quantite;
	private long prixUnitaire;
	Vector<Produit> tabProduit = new  Vector<Produit>();
	
	
	// Constructeur :
	Produit (){
		this.refProduit="";
		this.designation="";
		this.quantite=0;
		this.prixUnitaire=0;
	}
	
	Produit (String refProduit, String designation, int quantite, long prixUnitaire){
		this.refProduit=refProduit;
		this.designation=designation;
		this.quantite=quantite;
		this.prixUnitaire=prixUnitaire;
	}


	// Getters & Setters :
	public String getRefProduit() {
		return refProduit;
	}


	public void setRefProduit(String refProduit) {
		this.refProduit = refProduit;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
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
	
	public void ajouterProduit() {
        Scanner sc= new Scanner(System.in);
        System.out.println(" ****  Ajouter un produit  **** \n\n* Réf produit :" );
        String refProduit=sc.nextLine();
        System.out.println(" * Désignation de produit :");
        String desigProd=sc.nextLine();
        System.out.println(" * Quantité : ");
        int quantite=sc.nextInt();
        System.out.println(" * Prix unitaire : ");
        int prixUnitaire=sc.nextInt();
        Produit P = new Produit(refProduit,desigProd,quantite,prixUnitaire);
        this.tabProduit.add(P);
	}
	
	public void listeProduits() {	
		for(int i=0; i<this.tabProduit.size(); i++){
			System.out.println(" ****  Les caractéristiques du produit "+i+" **** \n" );
			System.out.println(" * Réf Produit : "+this.tabProduit.get(i).refProduit);
			System.out.println("\n * Désignation du Produit : "+this.tabProduit.get(i).designation);
			System.out.println("\n * Quantité : "+this.tabProduit.get(i).quantite);
			System.out.println("\n * Prix unitaire : "+this.tabProduit.get(i).prixUnitaire);
			System.out.println("____________________________________________________________________ \n");
        }
	}
	
}
