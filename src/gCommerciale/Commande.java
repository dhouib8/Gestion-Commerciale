package gCommerciale;

public class Commande {
	private Long numCom;
    private String dateCom;
    private Client Client;
	public Commande(Long numCom, String dateCom, Client client) {
		this.numCom = numCom;
		this.dateCom = dateCom;
		Client = client;
	}
	public Long getNumCom() {
		return numCom;
	}
	public void setNumCom(Long numCom) {
		this.numCom = numCom;
	}
	public String getDateCom() {
		return dateCom;
	}
	public void setDateCom(String dateCom) {
		this.dateCom = dateCom;
	}
	public Client getClient() {
		return Client;
	}
	public void setClient(Client client) {
		Client = client;
	}
	public String toString() {
		return "Commande [numCom=" + numCom + ", dateCom=" + 
				dateCom + ", " + Client.toString() + "]";
	}
}


