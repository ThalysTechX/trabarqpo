package arvoreAVL;

import dados.Item;

public class ArvoreAVL {
	private Nodo raiz;
	private boolean h;

	public ArvoreAVL() {
		this.raiz = null;
		this.h = true;
	}

	public void insereRaiz(Item elem) {
		this.raiz = this.insere(elem, this.raiz);
	}

	private Nodo insere(Item elem, Nodo no) {
		if (no == null) {
			Nodo novo = new Nodo(elem);
			this.h = true;
			return novo;
		} else {
			String dataVencRaiz = no.getInfo().getPrim().getInfo().getDataVenc();
			int fatorComparacao = elem.getDataVenc().compareTo(dataVencRaiz);
			if (fatorComparacao < 0 ) {
				// Insere à esquerda e verifica se precisa balancear à direita
				no.setEsq(this.insere(elem, no.getEsq()));
				no = this.balancearDir(no);
				return no;
			} else if (fatorComparacao > 0){
				// Insere à direita e verifica se precisa balancear à esquerda
				no.setDir(this.insere(elem, no.getDir()));
				no = this.balancearEsq(no);
				return no;
			}else{
				no.getInfo().inserirUltimo(elem);
				return no;

			}
		}
	}

	private Nodo balancearDir(Nodo no) {
		if (this.h)
			switch (no.getFatorBalanceamento()) {
			case 1:
				no.setFatorBalanceamento((byte) 0);
				this.h = false;
				break;
			case 0:
				no.setFatorBalanceamento((byte) -1);
				break;
			case -1:
				no = this.rotacaoDireita(no);
			}
		return no;
	}

	private Nodo balancearEsq(Nodo no) {
		if (this.h)
			switch (no.getFatorBalanceamento()) {
			case -1:
				no.setFatorBalanceamento((byte) 0);
				this.h = false;
				break;
			case 0:
				no.setFatorBalanceamento((byte) 1);
				break;
			case 1:
				no = this.rotacaoEsquerda(no);
			}
		return no;
	}

	private Nodo rotacaoDireita(Nodo no) {
		Nodo temp1, temp2;
		temp1 = no.getEsq();
		if (temp1.getFatorBalanceamento() == -1) {
			no.setEsq(temp1.getDir());
			temp1.setDir(no);
			no.setFatorBalanceamento((byte) 0);
			no = temp1;
		} else {
			try{
				temp2 = temp1.getDir();
				temp1.setDir(temp2.getEsq());
				temp2.setEsq(temp1);
				no.setEsq(temp2.getDir());
				temp2.setDir(no);
				if (temp2.getFatorBalanceamento() == -1)
					no.setFatorBalanceamento((byte) 1);
				else
					no.setFatorBalanceamento((byte) 0);
				if (temp2.getFatorBalanceamento() == 1)
					temp1.setFatorBalanceamento((byte) -1);
				else
					temp1.setFatorBalanceamento((byte) 0);
				no = temp2;
			}catch(NullPointerException np){
				
			}
		}
		no.setFatorBalanceamento((byte) 0);
		this.h = false;
		return no;
	}

	private Nodo rotacaoEsquerda(Nodo no) {
		Nodo temp1, temp2;
		temp1 = no.getDir();
		if (temp1.getFatorBalanceamento() == 1) {
			no.setDir(temp1.getEsq());
			temp1.setEsq(no);
			no.setFatorBalanceamento((byte) 0);
			no = temp1;
		} else {
			try{
				temp2 = temp1.getEsq();
				temp1.setEsq(temp2.getDir());
				temp2.setDir(temp1);
				no.setDir(temp2.getEsq());
				temp2.setEsq(no);
				if (temp2.getFatorBalanceamento() == 1)
					no.setFatorBalanceamento((byte) -1);
				else
					no.setFatorBalanceamento((byte) 0);
				if (temp2.getFatorBalanceamento() == -1)
					temp1.setFatorBalanceamento((byte) 1);
				else
					temp1.setFatorBalanceamento((byte) 0);
				no = temp2;
			}catch(NullPointerException np){
				
			}
		}
		no.setFatorBalanceamento((byte) 0);
		this.h = false;
		return no;
	}
	
	public Nodo busca(String elem) {
		return busca(this.raiz, elem);
	}

	protected Nodo busca(Nodo nodo, String elem) {
		while (nodo != null) {
			if(nodo.getInfo().getPrim() != null) {
				String dataVencRaiz = nodo.getInfo().getPrim().getInfo().getDataVenc();
				int fatorComparacao = elem.compareTo(dataVencRaiz);
				if (fatorComparacao == 0) {
					return nodo;
				}
				else if (fatorComparacao < 0) {
					nodo = nodo.getEsq();
				}
				else {
					nodo = nodo.getDir();
				}
			}
		}
		return null;
	}
	public Item [] CamCentral (int quantNos){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[quantNos];
		return (FazCamCentral (this.raiz, vet, n));
	}
	private Item [] FazCamCentral (Nodo arv, Item [] vet, int []n){
		if (arv != null) {
			vet = FazCamCentral (arv.getEsq(),vet,n);
			Item itemDaAVL = arv.getInfo().getPrim().getInfo();
			vet[n[0]] = itemDaAVL;
			n[0]++;
			vet = FazCamCentral (arv.getDir(),vet,n);
		}
		return vet;
	}

}