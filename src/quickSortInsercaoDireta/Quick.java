package quickSortInsercaoDireta;

import dados.Dados;
import dados.Item;

public class Quick {

	public void quickSort(Dados vet) {
		ordena(0, vet.getnElem() - 1,vet);
	}

	private void ordena(int esq, int dir, Dados vetor ) {
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
				ordena(esq, j,vetor);
		if (dir > i)
				ordena(i, dir,vetor);
	}	
}
