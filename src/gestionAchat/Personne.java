package gestionAchat;

import java.util.Scanner;

public class Personne {

	// Les attributs :
	
	private String nom, prenom, role, motDePasse, login;
	
	// Les constructeurs :
	Personne (){
		this.login="";
		this.nom="";
		this.prenom="";
		this.role="";
		this.motDePasse="";
	}
	Personne (String login, String nom, String prenom, String role, String motDePasse){
		this.login=login;
		this.nom=nom;
		this.prenom=prenom;
		this.role=role;
		this.motDePasse=motDePasse;
	}
	
	// Getters & Setters :
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
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
	
}
