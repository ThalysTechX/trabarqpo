package hashingComVetorEncadeado;

import java.io.IOException;
import lerArquivoTexto.GravaArquivo;
import lerArquivoTexto.LeitorArquivo;
import listaSimples.ListaSimples;
import listaSimples.No;
import dados.Item;

public class ControleHash {

	private static final String ARVORE_HASHING_ENCONTRADAS = "src/hashingComVetorEncadeado/DatasEncontradas-";
	private static final String ARVORE_HASHING_MEDIO = "src/hashingComVetorEncadeado/TempoMedio-ResultadoFinal";
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

	public void init() throws IOException {
		long tempo=0, tempoInicio, tempoTotal = 0;
		String tempoMedio="";
		
		GravaArquivo gravar = new GravaArquivo();
		for (int j = 0; j < this.path.length; j++) {
			for (int i = 0; i < TENTATIVAS; i++) {
				 Hash tabelaHash = new Hash(path[j]);
				// Incio da contagem do tempo
				tempoInicio = System.currentTimeMillis();			
				preencheHash(path[j], tabelaHash);

							
				String agenciasEncontradas = pesquisaAgencias(tabelaHash);
				gravar.gravaResultado(ARVORE_HASHING_ENCONTRADAS + path[j],
						agenciasEncontradas);
				// finaliza e exibe o tempo				
				tempo = System.currentTimeMillis() - tempoInicio;
				tempoTotal = tempoTotal + tempo;
			}
			tempoMedio += ("Arquivo: "+this.path[j]+" - Tempo medio: " + tempoTotal/5l)+" milleSegundos\n";
		}
		gravar.gravaResultado(ARVORE_HASHING_MEDIO, tempoMedio);

	}

	private String pesquisaAgencias(Hash tabelaHash) {
		String listaAgencias="";
		LeitorArquivo leitor = new LeitorArquivo();
		String pesq[] = leitor.lerData(ARQUIVOTEXTO_DATA_TXT);
						
		int i;
		
		for (int n = 0; n < pesq.length; n++) {
			i = tabelaHash.funcaoHash(pesq[n]);									
			ListaSimples lista = tabelaHash.vet[i];
			No aux = lista.getPrim();
			boolean achou = false;			
			while(aux!=null){
				if(aux.getInfo().getDataVenc().equalsIgnoreCase(pesq[n])){
					listaAgencias += aux.getInfo();
					achou = true;
				}
				aux = aux.getProx();
			}
			if (!achou){
				listaAgencias+="Não há promissoria na data "+pesq[n]+"\n";
			}
		}
		return listaAgencias;
	}

	private void preencheHash(String pathArq, Hash tabelaHash) {
		LeitorArquivo leitor = new LeitorArquivo();
		elementos = leitor.ler(this.CAMINHO + pathArq);
		for (int i = 0; i < elementos.length; i++) {
			tabelaHash.addNaTabela(elementos[i]);
		}
	}

}
