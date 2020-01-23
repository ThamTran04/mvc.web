package bean;

import java.util.Comparator;

public class Vehicule implements Comparable<Vehicule> {
	String marque, modele, immatriculation;
	int nombreRoues;

	public Vehicule() {
	}

	public Vehicule(String vmarque, String modele, int nombreRoues, String immatriculation) {
		marque = vmarque;
		this.modele = modele;
		this.nombreRoues = nombreRoues;
		this.immatriculation = immatriculation;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public int getNombreRoues() {
		return nombreRoues;
	}

	public void setNombreRoues(int nombreRoues) {
		this.nombreRoues = nombreRoues;
	}

	
	public String getTypeVehicule() {
		return "Vehicule";
	}
	
	@Override
	public String toString() {
		return "Marque: " + marque + "\t" + "Modele: " + modele + "\t" + "NombreRoues: " + nombreRoues + "\t"
				+ "Immatriculation: " + immatriculation;
	}

	public String toString1() {
		StringBuilder builder = new StringBuilder();
		builder.append(getMarque()).append(getModele()).append(nombreRoues).append(immatriculation);

		return builder.toString();
	}

	public String toString2() {
		StringBuilder builder = new StringBuilder();
		builder.append(getMarque()).append(";").append(getModele()).append(";").append(nombreRoues).append(";")
				.append(immatriculation);

		return builder.toString();
	}

	@Override // Comparable interface
	public int compareTo(Vehicule v) {
		if (this.marque.compareTo(v.marque) == 0) {
			return this.modele.compareTo(v.modele);
		} else {
			return this.marque.compareTo(v.marque);
		}

	}

	// Comparator interface:
	public static Comparator<Vehicule> compare = new Comparator<Vehicule>() {
		@Override // override method compare
		public int compare(Vehicule v1, Vehicule v2) {
			if (v1.marque.compareTo(v2.marque) == 0) {
				return v1.modele.compareTo(v2.modele);
			} else {
				return v1.marque.compareTo(v2.marque);
			}
		}
	};


}
