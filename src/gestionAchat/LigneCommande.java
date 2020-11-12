package gestionAchat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class LigneCommande {

	// Les attributs :
	private int quantite;
	private Livre L;
	public Vector<LigneCommande> tabLigneComd = new  Vector<LigneCommande>();
	
	// Constructeurs :
	LigneCommande(){
		this.L=L;
		this.quantite=0;
	}
	
	LigneCommande(Livre L, int quantite){
		this.L= L;
		this.quantite=quantite;
	}
	
	// Getters & Setters :
	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Livre getL() {
		return L;
	}

	public void setP(Livre l) {
		L = l;
	}
	
	
	// Méthode ‘calculateTotalPrice’ :
	public double calculerPrixTotal() {
		double montant=this.L.getPrixUnitaire()*this.quantite;
		return montant;
	}
	
	// Méthode ajout livre au panier dans le VECTOR "tabLigneComd" :
	public void ajouterLigneCommande() throws ClassNotFoundException, SQLException {
		Scanner sc1= new Scanner(System.in);
		// Récupération réf de livre à acheter :
		System.out.println(" \n --> Parmi les livres en stock, choissisez le livre à acheter (Tapez seulement la référence de livre) : \n\n \t * Réf Livre = ");
		String refLivre=sc1.nextLine();
		
		// Récupération les données de livre entrer l'utilisateur :
        Statement stmt =null;
        // Cnx au BD :
        MyConnection maC = new MyConnection();
        stmt = maC.getC().createStatement();
        
        ResultSet rs = stmt.executeQuery("select * from livres where refLivre='"+refLivre+"'");
  
        while(rs.next()){
        	Livre LivreCommander = new Livre(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getLong(6));
			// Récupération quantite d'achat :
			System.out.println(" \n \t * Maintenant entrez la quantité de livres ["+rs.getString(2)+"] à acheter = ");
			int quantiteCommander=sc1.nextInt();
			
			// Cette partie pour ajouter un livre au panier localement sur un VECTOR "tabLigneComd" :
			LigneCommande LigneCommander = new LigneCommande(LivreCommander,quantiteCommander);
			this.tabLigneComd.add(LigneCommander);
			
			// Message de retour :
			System.out.println(" \n => Livre Ajouté au panier avec succés ! \n\n => Le prix total de cette ligne de commande = "+LigneCommander.calculerPrixTotal()+" DT"+"\n");
			 
			// Pour afficher la liste des produits ajoutés au panier :			
			System.out.println(" \n \t\t*******  La liste des livres ajoutés au panier ******** \n\n" );
			System.out.println("  Référence de livre \t\t\t Titre de Livre \t\t Quantité demandé \n\n" );
			for(int i=0; i<this.tabLigneComd.size(); i++){
				System.out.println("\t "+this.tabLigneComd.get(i).getL().getRefLivre()+"\t\t\t\t\t"+this.tabLigneComd.get(i).getL().getTitre()+"\t\t\t\t"+this.tabLigneComd.get(i).getQuantite());
			}
        }
	}
	
	// Méthode ajout une Commande & les lignes de commande :
	public void ajouterCommande () throws ClassNotFoundException, SQLException {
		
		// Fonction Random pour générer le numéro de commande : 
		Random r = new Random();
		int low = 1000;
		int high = 999999;
		int numCommande = r.nextInt(high-low) + low;
		// Fin de fonction random
		
		// Partie pour entrer les caractéristiques d'une commande :
		Scanner sc3= new Scanner(System.in);
		System.out.println(" Pour valider une commande, il faut terminer les données suivantes : \n\n  \t* Date (jj/mm/aaaa) :");
		String date=sc3.nextLine();
		System.out.println(" \n \t* Adresse :");
		String adresse=sc3.nextLine();
		// Cnx au BD :
        Statement stmt2 =null;
        MyConnection maC2 = new MyConnection();
        // Test de connectivité :
        if(maC2 == null){
            System.out.println(" \n Problème de connexion à la source de données...");
        }else{  
        	stmt2 = maC2.getC().createStatement();
        	// Requete d'ajout les données nécessiares d'une commande dans table 'commande' :
        	String req = "insert into commande values( '" +numCommande + "', '"+ date + "','"+ adresse +"')";
        	stmt2.executeUpdate(req);
        	
        	// Requete pour ajouter les lignes de commande enregistrer dans le vecteur 'tabLigneComd' vers la BD (table 'ligneCommande') :
        	for(int i=0; i<tabLigneComd.size();i++) {
	        	                                          
        		String req2 = "insert into lignecommande (refLivre,numCommande,quantite)values((SELECT refLivre FROM livres WHERE refLivre = "+tabLigneComd.get(i).getL().getRefLivre() +"), (SELECT numCommande FROM commande WHERE numCommande = "+ numCommande+"), "+tabLigneComd.get(i).getQuantite()+")";
        		stmt2.executeUpdate(req2);	
        	}
        	// Message de retour :
        	System.out.println(" \n --> Commande validé avec succés -_-" );
        }
	}
	
}
