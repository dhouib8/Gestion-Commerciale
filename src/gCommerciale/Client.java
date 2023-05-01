package gCommerciale;

public class Client extends Personne {
	private double chiffreaffaire;
	public Client(int iden, String nomsocial, String adresse, double chiffreaffaire) 
	{
		super(iden, nomsocial, adresse);
		this.chiffreaffaire = chiffreaffaire;
	}
	public double getChiffreaffaire() {
        return chiffreaffaire;
    }
    public void setChiffreaffaire(double chiffreaffaire) {
        this.chiffreaffaire = chiffreaffaire;
    }
    public void affiche(){
    	//System.out.println("ID : "+getIden()+" | Nom : "+getNomsocial()+
    	//		" | Adresse : "+getAdresse()+" | chAffaire : "+chiffreaffaire);
    	System.out.println("ID : "+iden+" | Nom : "+getNomsocial()+
    	    			" | Adresse : "+getAdresse()+" | chAffaire : "+chiffreaffaire);
    }
	public String toString() {
		return "Client [ID=" + getIden() + ", Nom=" + getNomsocial() + 
				", Adresse=" + getAdresse() + ", chAffaire=" + chiffreaffaire + "]";
	}
}
