
package gestionAchat;

import java.util.Vector;
import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Administrateur Admin = new Administrateur();
		Utilisateur User = new Utilisateur();
		
		Livre P = new Livre();
		LigneCommande LC = new LigneCommande();
		Commande C = new Commande();
		
		Scanner sc= new Scanner(System.in);
		int reponse,quitter=0;
			
		System.out.println(" \n ___________________ *** Bienvenue à l'application gestion d'achat *** ___________________ \n");	
				
		while(quitter == 0){
			System.out.println("\n \n----------------------------------------- MENU ------------------------------------------\n");
			System.out.println("\nChoisir la tache a faire: \n");
			System.out.println("\t[0] pour quitter le programme\n\n");
			
			System.out.println("\t[1] Ajouter un livre\n");
			//System.out.println("\t[2] Modifier un livre\n");
			System.out.println("\t[2] Supprimer un livre \n");
			System.out.println("\t[3] Liste des livres\n");
			System.out.println("\t[4] Ajouter un livre au panier\n");
			System.out.println("\t[5] Valider la commande en cours \n");
			System.out.println("\t[6] Liste des commandes validées\n");
			System.out.println("\t[7] Voir la facture d'une commande\n");

			
			do{
				System.out.println("\n->");
				reponse=sc.nextInt(); 
			}
			while(reponse < 0 || reponse > 9);
			
			switch(reponse){
				case 0: quitter = 1;
					System.out.println("\n----------------------------------------- Fermeture Programme -----------------------------------------\n");
					break;
				case 1: 
						P.ajouterLivre();
					Thread.sleep(1);
					break;
				case 2: 
					P.supprimerLivre();
				Thread.sleep(1);
				break;
				case 3: 
						P.listeLivres();
					Thread.sleep(1);		
					break;
				case 4:
						LC.ajouterLigneCommande();
					Thread.sleep(1);
					break;	
				case 5: 
						LC.ajouterCommande();
					Thread.sleep(1);
					break;
				case 6: 
						C.listeCommande();
					Thread.sleep(1);
				break;
				case 7: 
						C.afficheFacture();
					Thread.sleep(1);
				break;
					
				default : Thread.sleep(1);
					continue;
			}
		}
		
	}

}
