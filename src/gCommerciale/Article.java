package gCommerciale;

public class Article {
	private String reference;   
    private String designation;
    private double  prixunitaire;
    private int  quantitestock;
    public Article(String reference,String designation, 
    			   double prixunitaire, int quantitestock) {
        this.reference   = reference;
        this.designation = designation;
        this.prixunitaire  = prixunitaire;
        this.quantitestock = quantitestock;
    }
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrixunitaire() {
		return prixunitaire;
	}
	public void setPrixunitaire(double prixunitaire) {
		this.prixunitaire = prixunitaire;
	}
	public int getQuantitestock() {
		return quantitestock;
	}
	public void setQuantitestock(int quantitestock) {
		this.quantitestock = quantitestock;
	}
	public void affiche(){
	    
        System.out.printf("Ref : %s | Des : %s | Prix : %.2f | qteStock: %d\n",
        				reference,designation,prixunitaire,quantitestock);
    }
	public String toString() {
		return "Article [Ref=" + reference + ", Des=" + designation + 
				", Prix=" + prixunitaire + "]";
	}
}
