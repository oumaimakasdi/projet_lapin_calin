package pam.tp.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="proprietaire")

public class Proprietaire {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_User") 
	private Long IDUser;
	@Column(name="nom",length = 60) 
	private String nom;
	@Column(name="prenom",length = 60)
	private String prenom;
	@Column(name="adresse",length = 255)
	private String adresse;

	public Proprietaire() {}
	
	public Proprietaire(Long IDUser, String nom, String prenom, String adresse) {
		super();
		this.IDUser = IDUser;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	public long getIDUser() {
		return this.IDUser;
	}
	public void setUserID(long IDUser) {
		this.IDUser = IDUser;
	}
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return this.prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return this.adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
}
