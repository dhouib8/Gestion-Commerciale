package gCommerciale;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class gCommercialeTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		
		//Client clii = new Client(1, "Haitham", "Sfax", 0);
		//Article artt1 = new Article("2", "Stylo Bleu", 1.99, 10);
		//Article artt2 = new Article("3", "Stylo Rouge", 1.99, 10);
		//Commerciale.AjouterClient(clii);Commerciale.AjouterArticle(artt1);Commerciale.AjouterArticle(artt2);
	    boolean boo;
	    int n = -1;
		while(n!=0)
		{
			System.out.printf("----------Gestion Commerciale----------\n"
					+ "1) Ajouter un article\n"
					+ "2) Supprimer un article\n"
					+ "3) Ajouter un client\n"
					+ "4) Supprimer un client\n"
					+ "5) Passer une commmande\n"
					+ "6) Annuler une commmande\n"
					+ "7) Liste des articles\n"
					+ "8) Liste des clients\n"
					+ "9) Liste des commmandes\n"
					+ "0) Quitter\n\n"
					+ "Entrez un choix : ");
			n = in.nextInt();
			switch(n) {
				case 0: return;
				case 1: System.out.printf("* Ajouter un article | Entrez la référence : ");
						String ref = in.next();
						System.out.printf("* Ajouter un article | Entrez la désignation : ");
						String des = in.next();
						System.out.printf("* Ajouter un article | Entrez le prix unitaire : ");
						double prix = in.nextDouble();
						System.out.printf("* Ajouter un article | Entrez la qunatité : ");
						int qte = in.nextInt();
						Article a = new Article(ref,des,prix,qte);
						Commerciale.AjouterArticle(a);break;
				case 2: System.out.printf("* Supprimer un article | Entrez la référence : ");
						String ref1 = in.next();
						boo=false;
						for(int i = 0; i<Commerciale.articles.size();i++) {
							if(Commerciale.articles.elementAt(i).getReference().equals(ref1)) {
								Commerciale.SupprimerArticle(Commerciale.articles.elementAt(i));
								System.out.println("L'article de référence "+ref1+" est supprimé.");
								boo=true;
								break;
							}
						}
						if(boo==false) System.out.println("Cet article n'existe pas.");
						break;
						
				case 3:	System.out.printf("* Ajouter un client | Entrez l'identifiant : ");
						int id = in.nextInt();
						System.out.printf("* Ajouter un client | Entrez le nom : ");
						String nom = in.next();
						System.out.printf("* Ajouter un client | Entrez l'adresse : ");
						String adr = in.next();
						Client cli = new Client(id,nom,adr,0);
						Commerciale.AjouterClient(cli);break;
				case 4: System.out.printf("* Supprimer un client | Entrez l'identifiant : ");
						int id1 = in.nextInt();
						boo=false;
						for(int i = 0; i<Commerciale.clients.size();i++) {
							if(Commerciale.clients.elementAt(i).getIden() == id1) {
								Commerciale.SupprimerClient(Commerciale.clients.elementAt(i));
								System.out.println("Le client d'identifiant "+id1+" est supprimé.");
								boo=true;
								break;
							}
						}
						if(boo==false) System.out.println("Cet client n'existe pas.");
						break;
				case 5: System.out.printf("* Passer une commmande | Entrez la référence de la commande : ");
						Long refcom = in.nextLong();
						System.out.printf("* Passer une commmande | Entrez l'identifiant du client : ");
						int idcli = in.nextInt();
						Date date = new Date();  
						boo=false;
											
						for(int i = 0; i<Commerciale.clients.size();i++) {
							if(Commerciale.clients.elementAt(i).getIden() == idcli) {
								Client clicom = Commerciale.clients.elementAt(i);
								Commande com = new Commande(refcom,formatter.format(date),clicom);
								Commerciale.PasserCommande(com);
								boo=true;
								break;
							}
						}
						if(boo==false) System.out.println("Cet client n'existe pas.");
						break;
				case 6: System.out.printf("* Annuler une commmande | Entrez le numéro de commande : ");
						Long numcom = in.nextLong();
						boo=false;
						for(int i = 0; i<Commerciale.commandes.size();i++) {
							if(Commerciale.commandes.elementAt(i).getNumCom().equals(numcom)) {
								Commerciale.AnnulerCommande(Commerciale.commandes.elementAt(i));
								boo=true;
								break;
							}
						}
						if(boo==false) System.out.println("Cette commande n'existe pas.");
						break;
				case 7: System.out.println("* Liste des articles : ");Commerciale.ShowArticles();break;
				case 8: System.out.println("* Liste des clients : ");Commerciale.ShowClients();break;
				case 9: System.out.println("* Liste des commandes : ");Commerciale.ShowCommandes();break;
			}
		}
	}
}
