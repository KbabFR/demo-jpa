package diginamic_jpa.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Personne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 64, nullable = false)
	private String nom;
	
	@Column(columnDefinition = "varchar(64) NOT NULL")
	private String prenom;
	
	private String telephone;
	
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	private LocalDate dateNaissance;
	
	private Boolean actif = true;

	
	//----------CONSTRUCTOR----------
	
	public Personne() {
		super();
	}
	
	public Personne(String nom, String prenom, Genre genre) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
	}

	
	//----------TOSTRING----------
	
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", genre="
				+ genre + ", dateNaissance=" + dateNaissance + ", actif=" + actif + "]";
	}
	
	
	//----------GETTER/SETTER----------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}
	
	
}
