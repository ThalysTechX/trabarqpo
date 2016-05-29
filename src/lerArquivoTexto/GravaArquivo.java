package lerArquivoTexto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import listaSimples.ListaSimples;
import dados.Item;
import dados.ItemABB;

public class GravaArquivo {

	public void grava(String nomeArq, Item vet[]) throws IOException {

		FileWriter arq = new FileWriter(nomeArq);
		PrintWriter gravarArq = new PrintWriter(arq);
		for (int i = 0; i < vet.length; i++) {
			if(vet[i] != null){
			gravarArq.printf(vet[i].getDataVenc()+";"+
		                     vet[i].getValor()+";"+					         
		                     vet[i].getNome()+"\n");
			}
		} 
		arq.close();
	}
	public void gravaABB(String nomeArq, ItemABB vet[]) throws IOException {

		FileWriter arq = new FileWriter(nomeArq);
		PrintWriter gravarArq = new PrintWriter(arq);
		for (int i = 0; i < vet.length; i++) {
			if(vet[i] != null){
			gravarArq.printf(vet[i].getDataVenc()+";"+
		                     vet[i].getValor()+";"+					       
		                     vet[i].getNome()+"\n");
			}
		} 
		arq.close();
	}
	public void gravaArvore(String nomeArq, ListaSimples list) throws IOException{
		String output=list.showLista();
		this.gravaResultado(nomeArq, output);
	}
	
	public void gravaResultado(String nomeArq, String str) throws IOException {

		FileWriter arq = new FileWriter(nomeArq);
		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.printf(str);
		arq.close();
	}
}
