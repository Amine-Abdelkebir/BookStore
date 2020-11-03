
package gestionAchat;

import java.util.Vector;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Administrateur Admin = new Administrateur();
		Utilisateur User = new Utilisateur();
		
		Produit P = new Produit();
		LigneCommande LC = new LigneCommande();
		
		Vector<LigneCommande> tabLigneComd = new  Vector<LigneCommande>();
		
		Scanner sc= new Scanner(System.in);
		int reponse,quitter=0;
		
		
		
		System.out.println(" \n _______________ *** Bienvenue à l'application gestion d'achat *** _______________ \n");
		
		System.out.println(" le stock des produits est vide, Veuillez entrez au moins un produit pour utiliser l'application \n");	
		
		while(quitter == 0){
			System.out.println("\n--------------------------------MENU--------------------------------\n");
			System.out.println("\nChoisir la tache a faire: \n");
			System.out.println("\t[0] pour quitter le programme\n\n");
			
			System.out.println("\t[1] pour ajouter un produit\n");
			System.out.println("\t[2] pour lister les produits\n");
			System.out.println("\t[3] pour ajouter une ligne de commande au facture\n");
			System.out.println("\t[4] pour voir le montant total à payer \n");
			
			do{
				System.out.println("\n->");
				reponse=sc.nextInt(); 
			}
			while(reponse < 0 || reponse > 4);
			
			switch(reponse){
				case 0: quitter = 1;
					System.out.println("\n--------------------Fermeture Programme--------------------\n");
					break;
				case 1: 
					P.ajouterProduit();
					Thread.sleep(1);
					break;
				case 2: 
					P.listeProduits();
						Thread.sleep(1);		
					break;
				case 3: 
					// Juste un test provisoire du méthode ‘calculateTotalPrice’ :
					System.out.println("______________________________________________________________\n");
					Produit P1 = new Produit("ABC1234","Javel",15,2800);
					Produit P2 = new Produit("QSD2100000","Eau",60,800);
					
					LigneCommande LC1 = new LigneCommande(P1,2);
					System.out.println("// Test de méthode ‘calculateTotalPrice’ : \n\n * produit : "+P1.getDesignation()+"\n * Quantité : 2 \n\n --> Le prix total de ligne de commande = "+LC1.calculerPrixTotal()+" DT");
					
					Thread.sleep(1);
					break;
				case 4: 
					System.out.println("______________________________________________________________\n");
					Produit P3 = new Produit("ABC1234","Javel",15,2800);
					Produit P4 = new Produit("QSD2100000","Eau",60,800);
					
					LigneCommande LC3 = new LigneCommande(P3,2); //LigneCommande(Produit,quantite);
					LigneCommande LC4 = new LigneCommande(P4,10);
					
					Vector<LigneCommande> tabLigneComd1 = new  Vector<LigneCommande>();
					tabLigneComd1.add(LC3);
					tabLigneComd1.add(LC4);
					
					Commande C1 = new Commande(12547,"03/11/2020","Sousse, Sahloul");
					System.out.println(" Le montant total à payer pour la commande du référence : "+C1.getNumCommande()+" égal "+C1.montantAPayer(tabLigneComd1)+" DT");
					
					Thread.sleep(1);
					break;
				default : Thread.sleep(1);
					continue;
			}
		}
		
	}

}
 


