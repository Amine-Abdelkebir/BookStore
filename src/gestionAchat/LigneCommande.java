package gestionAchat;

import java.util.Vector;

public class LigneCommande {

	// Les attributs :
	private int quantite;
	private Produit P;
	Vector<LigneCommande> tabLigneComd = new  Vector<LigneCommande>();
	
	// Constructeurs :
	LigneCommande(){
		this.P=P;
		this.quantite=0;
	}
	
	LigneCommande(Produit P, int quantite){
		this.P= P;
		this.quantite=quantite;
	}
	
	// Getters & Setters :
	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Produit getP() {
		return P;
	}

	public void setP(Produit p) {
		P = p;
	}
	
	
	// Méthode ‘calculateTotalPrice’ :
	
	public double calculerPrixTotal() {
		double montant=this.P.getPrixUnitaire()*this.quantite;
		return montant;
	}
	
}
