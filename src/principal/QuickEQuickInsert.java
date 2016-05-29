package principal;

import java.io.File;
import java.io.IOException;

import quickSortInsercaoDireta.Quick;
import quickSortInsercaoDireta.QuickInsercao;
import algoritmosPesquisa.PesquisaBinaria;
import lerArquivoTexto.GravaArquivo;
import lerArquivoTexto.LeitorArquivo;
import dados.Dados;
import dados.Item;

public class QuickEQuickInsert {
	public static String strAuxFinal="";
	/**
	 * @param args
	 * @throws IOException 
	 */
	public  void init () throws IOException {
		
		String pesq[];
		
		LeitorArquivo leitor = new LeitorArquivo();
		
		pesq = leitor.lerData("src/lerArquivotexto/data.txt");
		
		Controle("src/lerArquivotexto/promissoria500ord.txt",pesq);
		Controle("src/lerArquivotexto/promissoria500inv.txt",pesq);
		Controle("src/lerArquivotexto/promissoria500alea.txt",pesq);
		
		Controle("src/lerArquivotexto/promissoria1000ord.txt",pesq);
		Controle("src/lerArquivotexto/promissoria1000inv.txt",pesq);
		Controle("src/lerArquivotexto/promissoria1000alea.txt",pesq);
		
		Controle("src/lerArquivotexto/promissoria5000ord.txt",pesq);
		Controle("src/lerArquivotexto/promissoria5000inv.txt",pesq);
		Controle("src/lerArquivotexto/promissoria5000alea.txt",pesq);
		
		Controle("src/lerArquivotexto/promissoria10000ord.txt",pesq);
		Controle("src/lerArquivotexto/promissoria10000inv.txt",pesq);
		Controle("src/lerArquivotexto/promissoria10000alea.txt",pesq);
	
		Controle("src/lerArquivotexto/promissoria50000ord.txt",pesq);
		Controle("src/lerArquivotexto/promissoria50000inv.txt",pesq);
		Controle("src/lerArquivotexto/promissoria50000alea.txt",pesq);
		
		GravaArquivo gravar = new GravaArquivo();
		gravar.gravaResultado("src/quickSortInsercaoDireta/media.txt", strAuxFinal);
	}
	public static String getNomeArq(String caminho){
	    // vamos obter o índice da última aparição do separador de caminho
		//int posAux=0;
		int pos = caminho.lastIndexOf('/');
	    if (pos > -1) {
	       return caminho.substring(pos+1, caminho.length());
	    }
	    //posAux = pos;
	    // por padrão vamos retornar uma string vazia
	    return "";
	  }
	public static void Controle(String str,String[] pesq) throws IOException{
		
		Dados dado = new Dados();
		Quick qk = new Quick();
		PesquisaBinaria pqs = new PesquisaBinaria();
		QuickInsercao qki = new QuickInsercao();
		Item vet[];
		LeitorArquivo leitor = new LeitorArquivo();
		String pesquisa[];
		String straux="";
		
		long tempo, tempoInicio, tempoTotal=0;
		int count=0;
		pesquisa = pesq;
		GravaArquivo grav = new GravaArquivo();
				
		do {
			// começa a promissoriar o tempo
	    	tempoInicio = System.currentTimeMillis();

			// carrega primeira listagem do txt para o vetor
			vet = leitor.ler(str);

			// joga o vetor na classe do algoritmo
			dado.setVetor(vet);
			dado.setnElem(vet.length);

			// roda o quick puro
			qk.quickSort(dado);
			//dado.quickSort(false);

			// finaliza e exibe o tempo
			tempo = System.currentTimeMillis() - tempoInicio;
			tempoTotal = tempoTotal + tempo;
			//straux += ("Tempo Quick; parcial; " + tempo)+"\n\n";
			
			count++;
		} while (count<5);
		//straux += ("Tempo Quick;  medio; " + tempoTotal/5)+"\n\n";
		
		strAuxFinal += "Quick  " + str +" "+ tempoTotal/5+"\n"; 
		
		grav.grava("src/quickSortInsercaoDireta/"+getNomeArq(str)+"_listaOrdenadaQuick.txt", vet);
		
		count = 0;
		tempoTotal = 0;
		
		do {
			// começa a contar o tempo
	    	tempoInicio = System.currentTimeMillis();

			// carrega primeira listagem do txt para o vetor
			vet = leitor.ler(str);

			// joga o vetor na classe do algoritmo
			dado.setVetor(vet);
			dado.setnElem(vet.length);

			// roda o quick + insercao
			qki.quickSortInsetDireta(dado);
			//dado.quickSort(true);

			// finaliza e exibe o tempo
			tempo = System.currentTimeMillis() - tempoInicio;
			tempoTotal = tempoTotal + tempo;
			//straux += ("Tempo Quick + Insercao; parcial; " + tempo)+"\n\n";
			
			count++;
		} while (count<5);
		//straux += ("Tempo Quick + Insercao;  medio; " + tempoTotal/5)+"\n\n";
		strAuxFinal += "Quick + Insercao " + str + " " + tempoTotal/5+"\n";
		grav.grava("src/quickSortInsercaoDireta/"+getNomeArq(str)+"_ListaOrdenadaQuickInsercao.txt", vet);
		
		straux += "Pesquisa\n\n";
		
		for (int n = 0; n < 200; n++) {
            int posAux;
			int posicao = pqs.pesqBinaria(pesquisa[n], dado);

			if (posicao == -1) {
				straux += ("Não há promissoria na data " + pesquisa[n] + "")+"\n";
			} else {
		
				straux += (vet[posicao].toString())+"\n";
				
				posAux = posicao;
				
				while ((posAux+1 < vet.length)&&(vet[posAux].getDataVenc().equals(vet[posAux+1].getDataVenc()))){
					straux += (vet[posAux+1].toString())+"\n";
					posAux++;
				}
				
				posAux = posicao;
				
				while ((posAux-1 > 0)&&(vet[posAux].getDataVenc().equals(vet[posAux-1].getDataVenc()))){
					straux += (vet[posAux-1].toString())+"\n";
					posAux--;
				}
				
			}
			straux += "\n";
		}
				
		GravaArquivo gra = new GravaArquivo();
		gra.gravaResultado("src/quickSortInsercaoDireta/"+getNomeArq(str)+"_Pesquisa.txt", straux);
		
	}
}