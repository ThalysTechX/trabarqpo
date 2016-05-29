package arvoreBinaria;

import listaSimplesABB.ListaSimples;
import dados.ItemABB;

public class Nodo {
	private ListaSimples<ItemABB> info=new ListaSimples<ItemABB>();
	private Nodo esq, dir;
	

	Nodo(ItemABB i) {
		info.inserirPrimeiro(i);
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

	public ListaSimples<ItemABB> getInfo() {
		return this.info;
	}

	public ItemABB getInfoPrimeiro() {
		return this.info.getPrim().getInfo();
	}

	//print da arvore, apenas para teste
	public void print(String caminho) {
		System.out.println(caminho+info);
		
		if (esq!=null)
			esq.print(caminho+"<");
		if (dir!=null)
			dir.print(caminho+">");
	}
}