package hashingComVetorEncadeado;

import listaSimples.ListaSimples;
import dados.Item;


public class Hash {
	ListaSimples vet[];
	String arquivo;
	int arqTamanho, qtdeElem;
    
	public Hash(String pathFile) {
		arquivo = pathFile;
		qtdeElem = Integer.parseInt(pathFile.replaceAll("[^0-9]", ""));

		arqTamanho = calularM((int) (qtdeElem * 1.1));
		vet = new ListaSimples[arqTamanho];
		inicializaListas();
	}
	
	final void inicializaListas(){
		for(int i = 0; i < arqTamanho; i++){			
			vet[i] = new ListaSimples();
		}
	}
	
	final int calularM(int primo){
		int conf=0;
		while(conf!=2){
			conf=0;
			primo++;		
			for (int i = 1; i <= primo; i++) {
				if(primo%i==0){
					conf++;
				}
			}			
		} 
		return primo; 
	}
	
	final int funcaoHash(String chave){
		char carac;
		int i, soma=0;
		for (i=0; i<chave.length(); i++){
		carac = chave.charAt(i);
		soma += Character.getNumericValue(carac);
		}
		return soma % arqTamanho;
	}
		

	final void addNaTabela(Item aux){			 
		vet[funcaoHash(aux.getDataVenc())].inserirUltimo(aux);		
	}

}
