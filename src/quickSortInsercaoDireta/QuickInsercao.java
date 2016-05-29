package quickSortInsercaoDireta;

import dados.Dados;
import dados.Item;

public class QuickInsercao {
	public void insercaoDireta(int esq, int dir, Dados vetor) {
		Item[] vet = vetor.getVetor();
		int i, j;
		Item temp;
		for (j = esq + 1; j <= dir; j++) {
			temp = vet[j];
			i = j;

			while ( (i > esq) && ((vet[i - 1].getDataVenc().compareTo(temp.getDataVenc()) > 0)||
				                   vet[i - 1].getDataVenc().compareTo(temp.getDataVenc()) == 0 && vet[i - 1].getNome().compareTo(temp.getNome()) > 0)) {
				vet[i] = vet[i - 1];
				--i;
			}
			vet[i] = temp;
		}
	}

	public void quickSortInsetDireta(Dados vetor) {
		ordena(0, vetor.getnElem() - 1,vetor);
	}

	private void ordena(int esq, int dir,Dados vetor) {
		Item[] vet = vetor.getVetor();
		int i = esq, j = dir;
		//int pivo;
		String pivoChavePri,pivoChaveSec;
		Item temp;
		pivoChavePri = vet[(i + j) / 2].getDataVenc();
		pivoChaveSec = vet[(i + j) / 2].getNome();
		do {
			while ( (vet[i].getDataVenc().compareTo(pivoChavePri) < 0) || 
					(vet[i].getDataVenc().compareTo(pivoChavePri) == 0 &&vet[i].getNome().compareTo(pivoChaveSec) < 0) )
				i++;
			while ( (vet[j].getDataVenc().compareTo(pivoChavePri) > 0) ||
					(vet[j].getDataVenc().compareTo(pivoChavePri) == 0 && vet[j].getNome().compareTo(pivoChaveSec) > 0))
				j--;
			if (i <= j) {
				temp = vet[i];
				vet[i] = vet[j];
				vet[j] = temp;
				i++;
				j--;
			}
		} while (i <= j);
		if (esq < j)
			if (j-esq <= 20)
				insercaoDireta(esq, j,vetor);
			else
				ordena(esq, j,vetor);
		if (dir > i)
			if (dir-i <= 20)
				insercaoDireta(i, dir,vetor);
			else
				ordena(i, dir,vetor);
	}	
}
