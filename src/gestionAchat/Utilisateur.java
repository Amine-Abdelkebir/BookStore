package gestionAchat;

import java.util.Vector;

public class Utilisateur extends Personne {

	Utilisateur(){
		super();
	}
	
	Utilisateur (long login, String nom, String prenom, String role, String motDePasse){
		super(login,nom,prenom,role,motDePasse);
	}
	 
	
}
