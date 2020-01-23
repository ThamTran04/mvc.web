package bean;

public class Voiture extends Vehicule {
	int annee;
	String couleur;

	public Voiture(String marque, String modele, int annee, String couleur, String immatriculation) {
		super(marque, modele, 4, immatriculation);
		this.annee = annee;
		this.couleur = couleur;
	}
	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	@Override
	public String getTypeVehicule() {
		return "Voiture";
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t" + "Année: " + annee + "\t" + "Couleur: " + couleur;
	}

	@Override
	public String toString2() {
		StringBuilder builder = new StringBuilder();
		return builder.append("Voiture").append(";").append(super.toString2()).append(";").append(annee).append(";")
				.append(couleur).toString();
	}


}
