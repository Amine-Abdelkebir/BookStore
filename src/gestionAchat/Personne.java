package gestionAchat;

public class Personne {

	// Les attributs :
	private long login;
	private String nom, prenom, role, motDePasse;
	
	// Les constructeurs :
	Personne (){
		this.login=0;
		this.nom="";
		this.prenom="";
		this.role="";
		this.motDePasse="";
	}
	Personne (long login, String nom, String prenom, String role, String motDePasse){
		this.login=login;
		this.nom=nom;
		this.prenom=prenom;
		this.role=role;
		this.motDePasse=motDePasse;
	}
	
	// Getters & Setters :
	public long getLogin() {
		return login;
	}
	public void setLogin(long login) {
		this.login = login;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	// les méthodes :
	
	public void login(long login, String motDePasse){

		if(login==this.login && motDePasse==this.motDePasse) {
			System.out.println("Vous etes connectez !");
		}
		else if (login!=this.login || motDePasse!=this.motDePasse) {
			System.out.println("Login ou mot de passe incorrecte !");
		}
	}
	
}
