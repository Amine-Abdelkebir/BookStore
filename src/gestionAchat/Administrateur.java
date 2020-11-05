package gestionAchat;

public class Administrateur extends Personne{

	Administrateur(){
		super();
	}
	
	Administrateur (String login, String nom, String prenom, String role, String motDePasse){
		super(login,nom,prenom,role,motDePasse);
	}
}
