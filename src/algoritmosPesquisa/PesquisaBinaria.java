package algoritmosPesquisa;

import dados.Dados;
import dados.Item;

public class PesquisaBinaria {
	
	public int pesqBinaria (String chave, Dados vetor){
		Item[] vet = vetor.getVetor();
		int meio, esq, dir;
		esq = 0;
		dir = vetor.getnElem()-1;
		while (esq <= dir){
			meio = (esq + dir)/2;
			if (chave.compareTo(vet[meio].getDataVenc()) == 0)
				return meio;
			else{
				if (chave.compareTo(vet[meio].getDataVenc()) < 0 )
					dir = meio - 1;
				else
					esq = meio + 1;
			}
		}
		return -1;
	}
}
