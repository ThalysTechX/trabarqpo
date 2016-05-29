package arvoreBinaria;

import listaSimplesABB.ListaSimples;
import listaSimplesABB.No;
import dados.Item;
import dados.ItemABB;

public class ArvoreBinaria {
	private Nodo raiz;

	public ArvoreBinaria() {
		this.raiz = null;
	}

	//METODO DE INSERCAO
	public void insereRaiz(ItemABB elem) {
		this.raiz = this.insere(elem, this.raiz);
	}

	private Nodo insere(ItemABB elem, Nodo no) {
		if (no == null) {
			Nodo novo = new Nodo(elem);
			return novo;
		} else {

			int compare = elem.getDataVenc().compareTo(no.getInfoPrimeiro().getDataVenc());
			if (compare == 0) {
				no.getInfo().inserirUltimo(elem);
				return no;
			} else if (compare < 0) {
				no.setEsq(this.insere(elem, no.getEsq()));
				return no;
			} else {
				no.setDir(this.insere(elem, no.getDir()));
				return no;
			}
		}
	}

	public void insereElementos(ItemABB[] vet) {
		for (ItemABB i:vet) {
			insereRaiz(i);
		}
	}	
	
	public void Balancear(ItemABB[] vetOrdenado) {
		this.Balancear(vetOrdenado, 0, vetOrdenado.length-1);
	}
	
	private void Balancear(ItemABB[] vet, int inic, int fim){
		int meio;
		if (fim >= inic){
			meio = (inic+fim)/2;
			insereRaiz(vet[meio]);
			this.Balancear (vet, inic, meio - 1);
			this.Balancear (vet, meio + 1, fim);
		}
	}	
		
	/*
	 * FAZ O CAMINHAMENTO CENTRAL PARA OBTER O VETOR ORDENADO [VO]
	 * CONSTROI A ARVORE BINARIA BALANCEADA [ABB]
	 */
	public ItemABB[] obterVetorOrdenado() {
		ListaSimples<ItemABB> colecao=new ListaSimples<ItemABB>();
		
		obterItens(raiz,colecao);

		ItemABB[] retorno=new ItemABB[colecao.getQuantNos()];
		No<ItemABB> atual=colecao.getPrim();
		int cont=0;
		while (atual!=null && cont<retorno.length) {
			retorno[cont++]=atual.getInfo();
			atual=atual.getProx();
		}
		return retorno;
	}
	
	private void obterItens(Nodo no,ListaSimples<ItemABB> itensColetados) {
		if (no==null)
			return;
		obterItens(no.getEsq(),itensColetados);
		itensColetados.addAll(no.getInfo());
		obterItens(no.getDir(),itensColetados);
	}
	
	//METODO DE PESQUISA
	// Usando generics para que seja possível criar uma ListaSimples de ListaSimples de Item
	// https://docs.oracle.com/javase/tutorial/java/generics/types.html
	public ListaSimples<ListaSimples<ItemABB>> pesquisa(String[] pesq) {
		ListaSimples<ListaSimples<ItemABB>> encontrados=new ListaSimples<ListaSimples<ItemABB>>();
		for (int i=0;i<pesq.length;i++) {
			ListaSimples<ItemABB> encontradosDestaPesquisa=new ListaSimples<ItemABB>();
			
			obterEncontrados(raiz,pesq[i],encontradosDestaPesquisa);
			
			encontrados.inserirUltimo(encontradosDestaPesquisa);
		}
		
		return encontrados;
	}

	private void obterEncontrados(Nodo no,String busca,
			ListaSimples<ItemABB> encontradosDestaPesquisa) {
		if (no==null)
			return;
		
		ItemABB item=no.getInfoPrimeiro();
		int compare=busca.compareTo(item.getDataVenc());
		if (compare==0) {
			encontradosDestaPesquisa.addAll(no.getInfo());
			return;
		} else if (compare>0) {
			obterEncontrados(no.getDir(), busca, encontradosDestaPesquisa);
		} else {
			obterEncontrados(no.getEsq(), busca, encontradosDestaPesquisa);
		}
	}
	
	
}


