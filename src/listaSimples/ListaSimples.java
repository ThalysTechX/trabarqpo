package listaSimples;
import dados.Item;
public class ListaSimples {
	private No prim;
	private No ult;
	private int quantNos;

	public ListaSimples(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}
	public int getQuantNos(){
		return this.quantNos;
	}
	public No getPrim(){
		return this.prim;
	}
	public No getUlt(){
		return this.ult;
	}
	public boolean ÈVazia (){
		return (this.prim == null);
	}
	public void inserirPrimeiro(Item elem){
		No novoNo = new No (elem);
		if (this.ÈVazia()){
			this.ult = novoNo;
		}
		novoNo.setProx(this.prim);
		this.prim = novoNo;
		this.quantNos++;
	}
	public void inserirUltimo (Item elem){
		No novoNo = new No (elem);
		if (this.ÈVazia()){
			this.prim = novoNo;
		} else {
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}
	public No pesquisarNo (int chave){
		No atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave)){
			atual = atual.getProx();
		}	
		return atual;
	}
	
	public void concatenarListas(ListaSimples l1){
		this.ult.setProx(l1.getPrim());
		this.quantNos+=l1.quantNos;
	}
	public boolean removerNo (int chave) {
		No atual = this.prim;
		No ant = null;
		if (ÈVazia()){
			return false;
		} else {
			while ((atual != null)&&(atual.getInfo().getChave()!= chave)){
				ant = atual;
				atual = atual.getProx();
			}
			if (atual == null){
				return false;
			}
			else{
				if (atual == this.prim){
					if (this.prim == this.ult){
						this.ult = null;
					}
					this.prim = this.prim.getProx();
				} else {
					if (atual == this.ult){
						this.ult = ant;
					}
					ant.setProx(atual.getProx());
				}
				this.quantNos--;
				return true;
			}
		}
	}
	
	public String showLista(){
		String output="";
		No aux = this.prim;
		while (aux != null) {
			output+= aux.getInfo();
			aux = aux.getProx();
		}
		
		return output;
	}
}
