package arvoreAVL;

import java.io.IOException;
import lerArquivoTexto.GravaArquivo;
import lerArquivoTexto.LeitorArquivo;
import dados.Item;

public class ControleAVL {

	private static final String ARVORE_AVL_DATAS_ENCONTRADAS = "src/arvoreAVL/DatasEncontradas-";
	private static final String ARQUIVOTEXTO_LISTA_ORDENADA = "src/arvoreAVL/ListaOrdenada-";
	private static final String ARVORE_AVL_TEMPO_MEDIO = "src/arvoreAVL/TempoMedio-ResultadoFinal";
	private static final String ARQUIVOTEXTO_DATA_TXT = "src/lerArquivotexto/data.txt";
	final int TENTATIVAS = 5;
	final String CAMINHO = "src/lerArquivotexto/";
	private String path[] = { "promissoria500alea.txt", "promissoria500inv.txt",
			"promissoria500ord.txt", "promissoria1000alea.txt", "promissoria1000inv.txt",
			"promissoria1000ord.txt", "promissoria5000alea.txt", "promissoria5000inv.txt",
			"promissoria5000ord.txt", "promissoria10000alea.txt", "promissoria10000inv.txt",
			"promissoria10000ord.txt", "promissoria50000alea.txt", "promissoria50000inv.txt",
	 		"promissoria50000ord.txt" };

	
	private Item elementos[];
	private Item elemOrdenados[];

	public void init() throws IOException {
		long tempo=0, tempoInicio, tempoTotal = 0;
		String tempoMedio="";
		
		GravaArquivo gravar = new GravaArquivo();
		for (int j = 0; j < this.path.length; j++) {
			for (int i = 0; i < TENTATIVAS; i++) {
				 ArvoreAVL avl = new ArvoreAVL();
				// Incio da promissoriagem do tempo
				tempoInicio = System.currentTimeMillis();
				preencheAVL(path[j], avl);

				elemOrdenados = avl.CamCentral(elementos.length);
				// Gravando elementos ordenados da AVL Ex.:
				// ListaOrdenada-promissoria500alea.txt
				
				gravar.grava(ARQUIVOTEXTO_LISTA_ORDENADA + path[j], elemOrdenados);
				String agenciasEncontradas = pesquisaAgencias(avl);
				gravar.gravaResultado(ARVORE_AVL_DATAS_ENCONTRADAS + path[j],
						agenciasEncontradas);
				// finaliza e exibe o tempo
				tempo = System.currentTimeMillis() - tempoInicio;
				tempoTotal = tempoTotal + tempo;
			}
			tempoMedio += ("Arquivo: "+this.path[j]+" - Tempo medio: " + tempoTotal/5l)+" milleSegundos\n";
		}
		gravar.gravaResultado(ARVORE_AVL_TEMPO_MEDIO, tempoMedio);

	}

	private String pesquisaAgencias(ArvoreAVL avl) {
		
		String listaAgencias="";
		LeitorArquivo leitor = new LeitorArquivo();
		String pesq[] = leitor.lerData(ARQUIVOTEXTO_DATA_TXT);

		for (int n = 0; n < pesq.length; n++) {
			Nodo elem = avl.busca(pesq[n]);
			if (elem != null) {
				listaAgencias+=elem.getInfo().showLista();
			} else {
				listaAgencias+="Não há promissoria "+pesq[n]+" nao encontrada\n";
			}
		}
		return listaAgencias;
	}

	private void preencheAVL(String pathArq, ArvoreAVL avl) {
		LeitorArquivo leitor = new LeitorArquivo();
		elementos = leitor.ler(this.CAMINHO + pathArq);
		for (int i = 0; i < elementos.length; i++) {
			avl.insereRaiz(elementos[i]);
		}
	}

}
