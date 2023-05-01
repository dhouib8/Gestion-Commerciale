package gCommerciale;

public class Personne {
	protected int iden;
    private String nomsocial;
    private String adresse;
    public Personne(int iden,String nomsocial, String adresse) {
        
        this.iden = iden;
        this.nomsocial = nomsocial;
        this.adresse = adresse;

    }
    public int getIden() {
        return iden;
    }
    public void setIden(int iden) {
        this.iden = iden;
    }
    
    public String getNomsocial() {
        return nomsocial;
    }
    public void setNomsocial(String nomsocial) {
        this.nomsocial = nomsocial;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
