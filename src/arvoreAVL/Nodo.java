package arvoreAVL;
import listaSimples.ListaSimples;
import dados.Item;

public class Nodo {
	private ListaSimples info = new ListaSimples();
	private Nodo esq, dir;
	private byte fatorBalanceamento;

	Nodo(Item i) {// construtor
		this.info.inserirPrimeiro(i);
		this.fatorBalanceamento = 0;
	}

	public Nodo getDir() {
		return this.dir;
	}

	public void setDir(Nodo dir) {
		this.dir = dir;
	}

	public Nodo getEsq() {
		return this.esq;
	}

	public void setEsq(Nodo esq) {
		this.esq = esq;
	}

	public byte getFatorBalanceamento() {
		return this.fatorBalanceamento;
	}

	public void setFatorBalanceamento(byte fatorBalanceamento) {
		this.fatorBalanceamento = fatorBalanceamento;
	}

	public ListaSimples getInfo() {
		return this.info;
	}
}