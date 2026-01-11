package pam.tp.model;

import jakarta.persistence.*;



@Entity
@Table(name="Lapin")
public class Lapin {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_Lapin")
	private long IDLapin;
	@Column(name="nom",length = 60) 
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="id_papa")
	private Lapin papa;
	@ManyToOne
	@JoinColumn(name="id_maman")
	private Lapin maman;	
	@ManyToOne
	@JoinColumn(name="id_proprietaire")
	private Proprietaire proprietaire;
	
	public Lapin() {	}
	public Lapin(String nom, Lapin papa, Lapin maman, Proprietaire proprietaire) {
		super();
		this.nom = nom;
		this.papa = papa;
		this.maman = maman;
		this.proprietaire = proprietaire;
	}
	public long getIDLapin() {
		return this.IDLapin;
	}
	public void setIDLapin(long IDLapin) {
		this.IDLapin = IDLapin;
	}	
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
}
	public Lapin getPapa() {
		return this.papa;
	}
	public void setPapa(Lapin papa) {
		this.papa = papa;
	}
	public Lapin getMaman() {
		return this.maman;
	}
	public void setMaman(Lapin maman) {
		this.maman = maman;
	}
	public Proprietaire getProprietaire() {
		return this.proprietaire;
	}
	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}	
}		
