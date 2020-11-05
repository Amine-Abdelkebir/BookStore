
package gestionAchat;

import java.util.Vector;
import java.io.Console;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Administrateur Admin = new Administrateur();
		Utilisateur User = new Utilisateur();
		
		Produit P = new Produit();
		LigneCommande LC = new LigneCommande();
		Commande C = new Commande();
		
		Vector<LigneCommande> tabLigneComd = new  Vector<LigneCommande>();
		
		Scanner sc= new Scanner(System.in);
		int reponse,quitter=0;
		
		
		System.out.println(" \n ___________________ *** Bienvenue � l'application gestion d'achat *** ___________________ \n");
		
		System.out.println(" le stock des produits est vide, Veuillez entrez au moins un produit pour utiliser l'application -_- \n");	
		
		
		while(quitter == 0){
			System.out.println("\n----------------------------------------- MENU -----------------------------------------\n");
			System.out.println("\nChoisir la tache a faire: \n");
			System.out.println("\t[0] pour quitter le programme\n\n");
			
			System.out.println("\t[1] pour ajouter un produit\n");
			System.out.println("\t[2] pour supprimer un produit \n");
			System.out.println("\t[3] pour lister les produits\n");
			System.out.println("\t[4] pour ajouter un produit au panier\n");
			System.out.println("\t[5] pour passer la commande \n");

			
			do{
				System.out.println("\n->");
				reponse=sc.nextInt(); 
			}
			while(reponse < 0 || reponse > 6);
			
			switch(reponse){
				case 0: quitter = 1;
					System.out.println("\n----------------------------------------- Fermeture Programme -----------------------------------------\n");
					break;
				case 1: 
					P.ajouterProduit();
					
					Thread.sleep(1);
					break;
				case 2: 
					P.supprimerProduit();
					
					Thread.sleep(1);
					break;
				case 3: 
					P.listeProduits();
						Thread.sleep(1);		
					break;
				case 4: 
					Scanner sc1= new Scanner(System.in);
					System.out.println(" Parmi les produits en stock, choissisez le produit � commander (Tapez seulement la r�f�rence de produit) : \n R�f Produit :");
					String refProd=sc1.nextLine();
					Produit PCommander = new Produit();
					// Cette partie pour retourner le produit convenable avec la r�f entrer par l'utilisateur: 
					for(int i=0; i<P.tabProduit.size(); i++) {
						if (refProd.equals(P.tabProduit.get(i).getRefProduit()) ) {
							PCommander = P.tabProduit.get(i);
						}
						/*else {
							System.out.println(" Le produit choisir hors stock ! ");
						}*/
					}
					// Cette partie pour ajouter une ligne de commande au panier :
					System.out.println(" \n Maintenant entrez la quantit� de produit ["+PCommander.getDesignation()+"] � acheter : ");
					int quantiteCommander=sc1.nextInt();
					
					// V�rification de stock & Ajout de produit au panier :
					int verif = PCommander.getQuantite()-quantiteCommander;

					if (verif < 0) {
						System.out.println(" \n ==> Quantit� de stock insuffisante ! \n\n" );
					}else {
						LigneCommande LCommander = new LigneCommande(PCommander,quantiteCommander);
						tabLigneComd.add(LCommander);
						PCommander.setQuantite(PCommander.getQuantite()-quantiteCommander); // Pour d�sincr�menter la quantit� affect�
						System.out.println(" \n => Produit Ajout� au panier avec succ�s ! \n\n => Le prix total de cette ligne de commande = "+LCommander.calculerPrixTotal()+" DT"+"\n");
					} 
					 
					// Pour affichier la liste des produits ajout�s au panier :			
					System.out.println(" ****  La liste des produits ajout�s au panier **** \n\n" );
					System.out.println("  R�f�rence de Produit \t\t D�signation de Produit \t\t Quantit� demand� \n\n" );
					for(int i=0; i<tabLigneComd.size(); i++){
						System.out.println("\t "+tabLigneComd.get(i).getP().getRefProduit()+"\t\t\t\t"+tabLigneComd.get(i).getP().getDesignation()+"\t\t\t\t\t"+tabLigneComd.get(i).getQuantite());
					}
					
					Thread.sleep(1);
					break;	
				case 5: 
					// Fonction Random pour g�n�rer la num�ro de commande : 
					Random r = new Random();
					int low = 1000;
					int high = 999999;
					int numCommande = r.nextInt(high-low) + low;
					// Fin de fonction random
					// Partie pour entrer les caract�ristiques d'une commande :
					Scanner sc3= new Scanner(System.in);
					System.out.println(" Pour passer la commande il faut terminer les donn�es suivantes : \n\n  \t* Date (jj/mm/aaaa) :");
					String date=sc3.nextLine();
					System.out.println(" \n \t* Adresse :");
					String adresse=sc3.nextLine();

					Commande Cmd = new Commande(numCommande,date,adresse);
					
					// Affichage de Facture :
					System.out.println(" \n-------------------------------------------------- Facture -------------------------------------------------- \n");
					System.out.println(" \t\t  * Num�ro de commande : #"+Cmd.getNumCommande()+"#\n");
					System.out.println(" \t\t  * Adresse : "+Cmd.getAdresseCommande()+"\n");
					System.out.println(" \t\t  * Date : "+Cmd.getDate()+"\n\n");
					System.out.println(" \t \t \t Montant total � payer = "+Cmd.montantAPayer(tabLigneComd)+" DT \n\n");
					System.out.println("-------------------------------------------------- ******* --------------------------------------------------\n");
					
					Thread.sleep(1);
					break;	
					
				default : Thread.sleep(1);
					continue;
			}
		}
		
	}

}
