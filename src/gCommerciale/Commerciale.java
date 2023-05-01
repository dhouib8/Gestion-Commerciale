package gCommerciale;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Commerciale {
	static Vector<Article> articles = new Vector<Article>();
	static Vector<Commande> commandes = new Vector<Commande>();
	static Vector<Client> clients = new Vector<Client>();
	static Vector<Ligne> lignes = new Vector<Ligne>();

	@SuppressWarnings("resource")
	public static void  PasserCommande(Commande C) {
		Scanner in = new Scanner(System.in);
		boolean booRef, booQte;
		commandes.add(C);
		int x=1;
		while(x!=0) {
			booRef=false;
			booQte=false;
			System.out.printf("* Passer une commmande | Entrez la référence de l'article (0 pour finir) : ");
			String refart = in.next();
			if(refart.equals("0")) {
				x=0; 
				break;
			}
			
			System.out.printf("* Passer une commmande | Entrez la qunatité : ");
			int qteart = in.nextInt();
			
			for(int i = 0; i<articles.size();i++) {
				if(articles.elementAt(i).getReference().equals(refart)) {
					booRef=true;
					if(articles.elementAt(i).getQuantitestock()>=qteart) {
						articles.elementAt(i).setQuantitestock(articles.elementAt(i).getQuantitestock()-qteart);
						C.getClient().setChiffreaffaire(C.getClient().getChiffreaffaire()+articles.elementAt(i).getPrixunitaire()*qteart);
						booQte=true;
						Article art = articles.elementAt(i);
						Ligne L= new Ligne(C, art, qteart);
						lignes.add(L);
						System.out.println(qteart+" articles de référence "+refart+" sont ajoutés.");
					}
					break;
				}
			}
			if(booRef==false) System.out.println("Cet article n'existe pas.");
			if(booRef==true && booQte==false) System.out.println("Cette quantité n'existe pas.");
		}
		System.out.println("* Commande numéro "+C.getNumCom()+" ajoutée.");
		if(lignes.isEmpty()) commandes.remove(C);
		boolean found=false;
		for(int i = 0; i<lignes.size();i++) {
			if(lignes.elementAt(i).getCommande().equals(C)) found=true;	
		}
		if(found==false) commandes.remove(C);

	}
	public static void  AnnulerCommande(Commande C) {
		Iterator<Ligne> itr = lignes.iterator(); 
		while (itr.hasNext()) { 
			Ligne lig = itr.next(); 
			if(lig.getCommande().equals(C)) { 
				lig.getArticle().setQuantitestock(lig.getArticle().getQuantitestock()+lig.getQteCom());
				C.getClient().setChiffreaffaire(C.getClient().getChiffreaffaire()-lig.getArticle().getPrixunitaire()*lig.getQteCom());
				itr.remove(); 
			} 
		}
		System.out.println("* Commande numéro "+C.getNumCom()+" annulée.");
		commandes.remove(C);
	}
	public static void  AjouterArticle(Article A) {
		articles.add(A);
		System.out.println("* Article ajouté");
	}
	public static void  SupprimerArticle(Article A){
		articles.remove(A);
		System.out.println("* Article supprimé");
	}
	public static void  AjouterClient(Client C) {
		clients.add(C);
		System.out.println("* Client ajouté");
	}
	public static void  SupprimerClient(Client C){
		clients.remove(C);
		System.out.println("* Client supprimé");
	}
	public static void  ShowClients(){
		if(clients.isEmpty()) System.out.println("Pas de clients.");
		for(int i = 0; i<clients.size();i++) {
			clients.get(i).affiche();
		}
	}
	public static void  ShowArticles(){
		if(articles.isEmpty()) System.out.println("Pas d'articles.");
		for(int i = 0; i<articles.size();i++) {
			articles.get(i).affiche();
		}
	}
	public static void  ShowCommandes(){
		if(commandes.isEmpty()) System.out.println("Pas de commandes.");
		for(int i = 0; i<commandes.size();i++) {
			System.out.println(commandes.get(i).toString());
			for(int x = 0; x<lignes.size();x++) {
				if(lignes.elementAt(x).getCommande().equals(commandes.get(i))) System.out.println(lignes.get(x).toString());
			}
		}
	}
}
