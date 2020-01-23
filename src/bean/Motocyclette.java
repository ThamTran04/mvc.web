package bean;

public class Motocyclette extends Vehicule {
	int puissance;

	public Motocyclette(String marque, String modele, int puissance, String immatriculation) {
		super(marque, modele, 2, immatriculation);
		this.puissance = puissance;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	@Override
	public String getTypeVehicule() {
		return "Moto";
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t" + "Puissance: " + puissance;
	}

	@Override
	public String toString2() {
		StringBuilder builder = new StringBuilder();
		return builder.append("Motocyclette").append(";").append(super.toString2()).append(";").append(puissance)
				.toString();
	}

}
