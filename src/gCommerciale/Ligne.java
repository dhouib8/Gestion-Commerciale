package gCommerciale;

public class Ligne {
    
    private Commande Commande;
    private Article Article;
    private int qteCom;
	public Ligne(gCommerciale.Commande commande, gCommerciale.Article article, int qteCom) {
		Commande = commande;
		Article = article;
		this.qteCom = qteCom;
	}
	public Commande getCommande() {
		return Commande;
	}
	public void setCommande(Commande commande) {
		Commande = commande;
	}
	public Article getArticle() {
		return Article;
	}
	public void setArticle(Article article) {
		Article = article;
	}
	public int getQteCom() {
		return qteCom;
	}
	public void setQteCom(int qteCom) {
		this.qteCom = qteCom;
	}
	public String toString() {
		return "Ligne [numCom=" + Commande.getNumCom() + ", " + Article.toString() + ", qteCom=" + qteCom + "]";
	}
}
