
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

		Menu();
	}
	
	
	// Méthode affiche MENU :
	public static void Menu() throws InterruptedException, ClassNotFoundException, SQLException {		
		Livre P = new Livre();
		LigneCommande LC = new LigneCommande();
		Commande C = new Commande();
		
		Scanner sc= new Scanner(System.in);
		int reponse,quitter=0;
			
		System.out.println(" \n ___________________ *** Bienvenue à l'application gestion d'achat des livres *** ___________________ \n");	
		
		System.out.println("\n Vous voulez connecter en tant que : \n");
		System.out.println("\n \t[1] Administrateur\n");
		System.out.println("\n \t[2] Simple utilisateur\n\n");
		System.out.println("\n \t --> Choix : \n\n");
		int session = sc.nextInt();
		
		if(session ==1) {
			Administrateur Admin = new Administrateur("AD1245","Espace","ADMIN","Administrateur","test");
		
			while(quitter == 0){
				System.out.println("\n ----------------------------------------- MENU ------------------------------------------\n");
				System.out.println("\t \t \t \t    *** "+Admin.getNom()+" "+Admin.getPrenom()+" ***\n\n");
				
				System.out.println("\t[0] Se déconnecter\n\n");
				
				System.out.println("\t[1] Ajouter un livre\n");
				System.out.println("\t[2] Modifier un livre\n");
				System.out.println("\t[3] Supprimer un livre \n");
				System.out.println("\t[4] Liste des livres en stock \n");
				System.out.println("\t[5] Liste des commandes validées\n");
				System.out.println("\t[6] Voir la facture d'une commande\n");
			
				do{
					System.out.println("\n->");
					reponse=sc.nextInt(); 
				}
				while(reponse < 0 || reponse > 7);
				
				switch(reponse){
					case 0: quitter = 1;
						//System.out.println("\n----------------------------------------- Fermeture Programme -----------------------------------------\n");
						Menu();
						break;
					case 1: 
						P.ajouterLivre();
						Thread.sleep(1);
						break;
					case 2: 
						P.modifierLivre();
						Thread.sleep(1);
						break;
					case 3: 
						P.supprimerLivre();
						Thread.sleep(1);
					break;
					case 4: 
						P.listeLivres();
						Thread.sleep(1);		
						break;
					case 5: 
						C.listeCommande();
						Thread.sleep(1);
					break;
					case 6: 
						C.afficheFacture();
						Thread.sleep(1);
					break;
						
					default : Thread.sleep(1);
					
					continue;
				}
			}
		}
		else if (session ==2) {
			Utilisateur User = new Utilisateur("US7754","Espace","CLIENT","User","test");
			
			while(quitter == 0){
				System.out.println("\n \n----------------------------------------- MENU ------------------------------------------\n");
				System.out.println("\t \t \t \t  *** "+User.getNom()+" "+User.getPrenom()+" ***\n\n");
				
				System.out.println("\t[0] Se déconnecter\n\n");
				
				System.out.println("\t[1] Liste des livres en stock \n");
				System.out.println("\t[2] Ajouter un livre au panier\n");
				System.out.println("\t[3] Supprimer un livre du panier\n");
				System.out.println("\t[4] Valider la commande en cours \n");
				System.out.println("\t[5] Liste des commandes validées\n");
				System.out.println("\t[6] Supprimer une commande\n");
				System.out.println("\t[7] Voir la facture d'une commande\n");
			
				do{
					System.out.println("\n->");
					reponse=sc.nextInt(); 
				}
				while(reponse < 0 || reponse > 8);
				
				switch(reponse){
					case 0: quitter = 1;
						//System.out.println("\n----------------------------------------- Fermeture Programme -----------------------------------------\n");
						Menu();
					break;
					case 1: 
						P.listeLivres();
						Thread.sleep(1);		
						break;
					case 2:
						LC.ajouterLigneCommande();
						Thread.sleep(1);
						break;
					case 3:
						LC.supprimerLigneCommande();;
						Thread.sleep(1);
						break;
					case 4: 
						LC.ajouterCommande();
						Thread.sleep(1);
						break;
					case 5: 
						C.listeCommande();
						Thread.sleep(1);
					break;
					case 6: 
						C.supprimerCommande();;
						Thread.sleep(1);
					break;
					case 7: 
						C.afficheFacture();
						Thread.sleep(1);
					break;
						
					default : Thread.sleep(1);
					
					continue;
				}
			}//Fin boucle While
		} 
		else  System.out.println("\n --> Choix incorrecte ! \n");
				Menu();
	}
	
}//Class main
