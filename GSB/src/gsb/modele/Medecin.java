package gsb.modele;

public class Medecin {

	protected  String   codeMed;
	   protected  String   nom;
	   protected  String   prenom;
	   protected  String   adresse;
	   protected  Localite Localite;
	   protected  String   telephone;
	   protected  String   potentiel;
	   protected  String   specialite;

	   
	   public Medecin(String codeMed, String nom, String prenom, String adresse,Localite Localite, String telephone, String potentiel,
			String specialite) {
		super();
		this.codeMed = codeMed;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.Localite = Localite;
		this.telephone = telephone;
		this.potentiel = potentiel;
		this.specialite = specialite;

		
	}

	public String getCodeMed() {
		return codeMed;
	}

	public void setCodeMed(String codeMed) {
		this.codeMed = codeMed;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPotentiel() {
		return potentiel;
	}

	public void setPotentiel(String potentiel) {
		this.potentiel = potentiel;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Localite getLocalite() {
		return Localite;
	}

	public void setLocalite(Localite uneLocalite) {
		Localite = uneLocalite;
	}

}
