package principal;

import hashingComVetorEncadeado.ControleHash;

import java.io.IOException;

import arvoreAVL.ControleAVL;
import arvoreBinaria.ControleABB;

public class PesquisaOrdenacaoPrincipal {

	public static void main(String[] args) throws IOException {

		System.out.println("Inicio atividade com quick solo e quick + insert");
			QuickEQuickInsert quick = new QuickEQuickInsert();
			quick.init();
		System.out.println("Final atividade com quick solo e quick + insert");
		
		
		System.out.println("===================================================================");
		System.out.println("Os resultados se encontram no pacote reservado a cada atividade:\n"
				+ "QuickSort e QuickSort+InsertSort {package: quickSortInsercaoDireta }\n"
				+ "Arvore Binaria de Busca {package arvoreBinaria }\n"
				+ "Arvore AVL {package arvoreAVL }\n"
				+ "Hashing Ecandeado {package hashingComVetorEncadeado }\n"
				+ "Para visualizar o arquivos gerados basta atualizar o projeto 'F5' ");

	}

}
