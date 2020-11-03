package gestionAchat;

import java.util.Vector;

public class Commande {
	
	// Les attributs :
	private long numCommande;
	private String date,adresseCommande;
	Vector<LigneCommande> tabLigneComd = new  Vector<LigneCommande>();
	Vector<Commande> tabCommandes = new  Vector<Commande>();
	public Produit p;
	
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
	
	
	// Méthode pour calculer le montant total à payer (somme des montants pour les lignes de commande) :
	public double montantAPayer(Vector<LigneCommande> tabLigneComd) {
		double montant=0;
		for(int i=0;i<tabLigneComd.size();i++) {
			montant=montant+tabLigneComd.get(i).calculerPrixTotal();
		}
		return montant;
	}
	
}
