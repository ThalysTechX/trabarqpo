package listaSimplesABB;

import dados.*;

public class ListaSimples<U extends ObjetoComChave> extends ObjetoComChave {
	private No<U> prim;
	private No<U> ult;
	private int quantNos;

	public ListaSimples(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}
	public int getQuantNos(){
		return this.quantNos;
	}
	public No<U> getPrim(){
		return this.prim;
	}
	public No<U> getUlt(){
		return this.ult;
	}
	public boolean ehVazia (){
		return (this.prim == null);
	}
	public void inserirPrimeiro(U elem){
		No<U> novoNo = new No<U>(elem);
		if (this.ehVazia()){
			this.ult = novoNo;
		}
		novoNo.setProx(this.prim);
		this.prim = novoNo;
		this.quantNos++;
	}
	public void inserirUltimo(U elem){
		No<U> novoNo = new No<U>(elem);
		if (this.ehVazia()){
			this.prim = novoNo;
		} else {
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}
	public No<U> pesquisarNo (int chave){
		No<U> atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave)){
			atual = atual.getProx();
		}	
		return atual;
	}
	public String toString(){
		String msg = "";
		No<U> atual = this.prim;
		while (atual != null){
			msg += atual.getInfo()+"/";
			atual = atual.getProx();
		}
		return msg;
	}
	
	public void addAll(ListaSimples info) {
		No atual=info.prim;
		while (atual!=null) {
			inserirUltimo((U)(atual.getInfo()));
			atual=atual.getProx();
		}
	}
	
	@Override
	public int getChave() {
		return 0;
	}
	
	// Converte o conteudo da lista para um array simples
	public Object[] paraArray() {
		Object[] objetos=new Object[getQuantNos()];
		No<U> atual=getPrim();
		int i=0;
		while (atual!=null && i<objetos.length) {
			objetos[i++]=atual.getInfo();
			atual=atual.getProx();
		}
		return objetos;
	}
}
