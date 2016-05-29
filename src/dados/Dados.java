package dados;


public class Dados {
	private Item[] vetor; 
	private int nElem; 

	public Dados(Item[] vetor, int nElem) {
		super();
		this.vetor = vetor;
		this.nElem = nElem;
	}

	public Dados() {

	}

	public Item[] getVetor() {
		return vetor;
	}

	public void setVetor(Item[] vetor) {
		this.vetor = vetor;
	}

	public int getnElem() {
		return nElem;
	}

	public void setnElem(int nElem) {
		this.nElem = nElem;
	}
}