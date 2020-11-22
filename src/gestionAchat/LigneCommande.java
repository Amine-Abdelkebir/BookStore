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
	
	
	// M�thode �calculateTotalPrice� :
	public double calculerPrixTotal() {
		double montant=this.L.getPrixUnitaire()*this.quantite;
		return montant;
	}
	
	// M�thode ajout livre au panier dans le VECTOR "tabLigneComd" :
	public void ajouterLigneCommande() throws ClassNotFoundException, SQLException {
		Scanner sc1= new Scanner(System.in);
		// R�cup�ration r�f de livre � acheter :
		System.out.println(" \n --> Parmi les livres en stock, choissisez le livre � acheter (Tapez seulement la r�f�rence de livre) : \n\n \t * R�f Livre = ");
		String refLivre=sc1.nextLine();
		
		// R�cup�ration les donn�es de livre entrer l'utilisateur :
        Statement stmt =null;
        // Cnx au BD :
        MyConnection maC = new MyConnection();
        stmt = maC.getC().createStatement();
        
        ResultSet rs = stmt.executeQuery("select * from livres where refLivre='"+refLivre+"'");
  
        while(rs.next()){
        	Livre LivreCommander = new Livre(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getLong(6));
			// R�cup�ration quantite d'achat :
			System.out.println(" \n \t * Maintenant entrez la quantit� de livres ["+rs.getString(2)+"] � acheter = ");
			int quantiteCommander=sc1.nextInt();
			
			// Cette partie pour ajouter un livre au panier localement sur un VECTOR "tabLigneComd" :
			LigneCommande LigneCommander = new LigneCommande(LivreCommander,quantiteCommander);
			this.tabLigneComd.add(LigneCommander);
			
			// Message de retour :
			System.out.println(" \n => Livre Ajout� au panier avec succ�s ! \n\n => Le prix total de cette ligne de commande = "+LigneCommander.calculerPrixTotal()+" DT"+"\n");
			 
			// Pour afficher la liste des produits ajout�s au panier :			
			System.out.println(" \n \t\t*******  La liste des livres dans la panier ******** \n\n" );
			System.out.println("  R�f�rence de livre \t\t\t Titre de Livre \t\t Quantit� demand� \n\n" );
			for(int i=0; i<this.tabLigneComd.size(); i++){
				System.out.println("\t "+this.tabLigneComd.get(i).getL().getRefLivre()+"\t\t\t\t\t"+this.tabLigneComd.get(i).getL().getTitre()+"\t\t\t\t"+this.tabLigneComd.get(i).getQuantite());
			}
        }
	}
	
	// M�thode ajout livre au panier dans le VECTOR "tabLigneComd" :
	public void supprimerLigneCommande() throws ClassNotFoundException, SQLException {
		
		// Pour afficher la liste des livres en cours dans la panier :			
        System.out.println(" \n \t\t*******  La liste des livres existants dans la panier ******** \n\n" );
		System.out.println("  R�f�rence de livre \t\t\t Titre de Livre \t\t Quantit� demand� \n\n" );
		for(int i=0; i<this.tabLigneComd.size(); i++){
			System.out.println("\t "+this.tabLigneComd.get(i).getL().getRefLivre()+"\t\t\t\t\t"+this.tabLigneComd.get(i).getL().getTitre()+"\t\t\t\t"+this.tabLigneComd.get(i).getQuantite()+" \n");
		}
		
		Scanner sc1= new Scanner(System.in);
		// R�cup�ration r�f de livre � acheter :
		System.out.println(" \n --> Parmi les livres au panier, choissisez le livre � supprimer (Tapez seulement la r�f�rence de livre) : \n\n \t * R�f Livre = ");
		String refLivre=sc1.nextLine();
		
		// R�cup�ration les donn�es de livre entrer l'utilisateur :
        Statement stmt =null;
        // Cnx au BD :
        MyConnection maC = new MyConnection();
        stmt = maC.getC().createStatement();
        
        for (int j=0; j<tabLigneComd.size();j++) {
        	 if (refLivre.equals(tabLigneComd.get(j).L.getRefLivre()) ) {
        		 tabLigneComd.remove(j);
     			// Message de retour :
     			System.out.println(" \n => Livre supprim� du panier avec succ�s ! ");
        	 }else 
        		 System.out.println(" \n => Le livre n'existe pas dans la panier ! ");
        }        
		// Pour afficher la liste des produits dans la panier :			
        System.out.println(" \n \t\t*******  La liste final des livres dans la panier ******** \n\n" );
		System.out.println("  R�f�rence de livre \t\t\t Titre de Livre \t\t Quantit� demand� \n\n" );
		for(int i=0; i<this.tabLigneComd.size(); i++){
			System.out.println("\t "+this.tabLigneComd.get(i).getL().getRefLivre()+"\t\t\t\t\t"+this.tabLigneComd.get(i).getL().getTitre()+"\t\t\t\t"+this.tabLigneComd.get(i).getQuantite());
		}        
	}
	
	// M�thode ajout une Commande & les lignes de commande :
	public void ajouterCommande () throws ClassNotFoundException, SQLException {
		
		String msgRetour="";
		// Fonction Random pour g�n�rer le num�ro de commande : 
		Random r = new Random();
		int low = 1000;
		int high = 999999;
		int numCommande = r.nextInt(high-low) + low;
		// Fin de fonction random
		
		// Partie pour entrer les caract�ristiques d'une commande :
		Scanner sc3= new Scanner(System.in);
		System.out.println(" Pour valider une commande, il faut terminer les donn�es suivantes : \n\n  \t* Date (jj/mm/aaaa) :");
		String date=sc3.nextLine();
		System.out.println(" \n \t* Adresse :");
		String adresse=sc3.nextLine();
		// Cnx au BD :
        Statement stmt2 =null;
        MyConnection maC2 = new MyConnection();
        // Test de connectivit� :
        if(maC2 == null){
            System.out.println(" \n Probl�me de connexion � la source de donn�es...");
        }else{  
        	stmt2 = maC2.getC().createStatement();
        	// Requete d'ajout les donn�es n�cessiares d'une commande dans table 'commande' :
        	String req = "insert into commande values( '" +numCommande + "', '"+ date + "','"+ adresse +"')";
        	stmt2.executeUpdate(req);
        	
        	// Requete pour ajouter les lignes de commande enregistrer dans le vecteur 'tabLigneComd' vers la BD (table 'ligneCommande') :
        	for(int i=0; i<tabLigneComd.size();i++) {
	        	
        		ResultSet rs = stmt2.executeQuery("select * from livres where refLivre='"+tabLigneComd.get(i).getL().getRefLivre()+"'");
       		            
                int testControleQte=0;
                
                while(rs.next()) {
                	int quantiteLivreEnStock = rs.getInt(5);
                	if (quantiteLivreEnStock >= tabLigneComd.get(i).quantite ) {             		
                		testControleQte=1;
                	}
                	else testControleQte=-1;
                }
                
                if(testControleQte!=1 && testControleQte==-1 && testControleQte!=0) {
                	msgRetour=" \n --> Quantit� de stock est insuffisante !";
                	break;
                }
                else if (testControleQte==1 && testControleQte!=-1 && testControleQte!=0) {
            		String req2 = "insert into lignecommande (refLivre,numCommande,quantite)values((SELECT refLivre FROM livres WHERE refLivre = '"+tabLigneComd.get(i).getL().getRefLivre() +"'), (SELECT numCommande FROM commande WHERE numCommande = "+ numCommande+"), "+tabLigneComd.get(i).getQuantite()+")";
            		stmt2.executeUpdate(req2);
            		
            		// Mise � jour de quantite command� :
            		String reqSoustractionQte ="UPDATE livres SET quantite = quantite -"+tabLigneComd.get(i).quantite+" WHERE refLivre='"+tabLigneComd.get(i).getL().getRefLivre()+"'";
            		stmt2.executeUpdate(reqSoustractionQte);

            		msgRetour=" \n --> Commande valid� avec succ�s -_-";
                }
        	}
        	// Message de retour :
        	System.out.println(msgRetour);
        }
		// Vider le vecteur 'tabLigneComd' pour pr�parer au prochaine commande : 
		tabLigneComd.clear();
	}
	
}
