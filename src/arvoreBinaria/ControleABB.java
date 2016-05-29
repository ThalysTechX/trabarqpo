package arvoreBinaria;

import java.io.IOException;
import java.util.Date;

import lerArquivoTexto.GravaArquivo;
import lerArquivoTexto.LeitorArquivo;
import listaSimplesABB.ListaSimples;
import listaSimplesABB.No;
import dados.Item;
import dados.ItemABB;
import dados.ObjetoComChave;

public class ControleABB {
	
	class Resultado extends ObjetoComChave {
		long tempoInicio=new Date().getTime(),tempoFinal;
		
		public void terminar() {
			tempoFinal=new Date().getTime();
		}
			
		public long getTempo() {
			return tempoFinal-tempoInicio;
		}

		@Override
		public int getChave() {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public long getMedia(ListaSimples<Resultado> resultados) {
		if (resultados.ehVazia())
			return 0;
		
		long total = 0;
		No<Resultado> atual=resultados.getPrim();
		while (atual!=null) {
			total+=atual.getInfo().getTempo();
			atual=atual.getProx();
		}
		return total/resultados.getQuantNos();
	}
	
	class Media extends ObjetoComChave {
		long media;
		
		public Media(long valor) {
			media=valor;
		}

		@Override
		public int getChave() {
			return 0;
		}		
	}
	
	public void init() throws IOException{
		
		String entrada[]=new String[]{"promissoria500alea", "promissoria500inv",
				"promissoria500ord", "promissoria1000alea", "promissoria1000inv",
				"promissoria1000ord", "promissoria5000alea", "promissoria5000inv",
				"promissoria5000ord", "promissoria10000alea", "promissoria10000inv",
				"promissoria10000ord", "promissoria50000alea", "promissoria50000inv",
		 		"promissoria50000ord"};
		ListaSimples<Media> saidas=new ListaSimples<Media>();

		for (String cadaUm:entrada) {
			ListaSimples<Resultado> resultados=new ListaSimples<Resultado>();
			for (int i=0;i<5;i++)
				resultados.inserirUltimo(processa(cadaUm));
			
			Media media=new Media(getMedia(resultados));
			saidas.inserirUltimo(media);
		}

		GravaArquivo gra = new GravaArquivo();
		String medias=new String();
		No<Media> atual=saidas.getPrim();
		for (int i=0;atual!=null && i<entrada.length;i++,atual=atual.getProx())
			medias+=entrada[i]+": "+atual.getInfo().media+"ms"+(i<entrada.length-1?";":".")+"\n";
		gra.gravaResultado("src/arvoreBinaria/medias.txt", ""+medias);

	}
	
	public static void executarProcesso(String str,String[] pesq,String nome) throws IOException{
		ItemABB vet[];
		LeitorArquivo leitor = new LeitorArquivo();
		
		// carrega primeira listagem do txt para o vetor
		vet = leitor.lerABB(str);
		ArvoreBinaria ab=new ArvoreBinaria();
		ab.insereElementos(vet);
		vet = ab.obterVetorOrdenado();
		ab.Balancear(vet);
		
		ItemABB[] itens=ab.obterVetorOrdenado();
		
		ArvoreBinaria arvoreBinariaBalanceada=new ArvoreBinaria();
		arvoreBinariaBalanceada.Balancear(itens);

		Object[] encontrados=arvoreBinariaBalanceada.pesquisa(pesq).paraArray();
		
		GravaArquivo gra = new GravaArquivo();

		String resultadoPesquisa="";
		for (int i=0;i<pesq.length;i++) {
			resultadoPesquisa+=pesq[i]+": "+(((ListaSimples<ItemABB>)(encontrados[i])).getQuantNos()==0?"NAO ENCONTRADO":(encontrados[i]))+"\n";
		}
		
		gra.gravaResultado("src/arvoreBinaria/resultado_"+nome+".txt",""+resultadoPesquisa);		
		gra.gravaABB("src/arvoreBinaria/ordenados_"+nome+".txt", itens);		
	}

	//LEITURA DO ARQUIVO AGENCIA PARA BUSCA
	public Resultado processa(String entrada) throws IOException {
		Resultado resultado=new Resultado();
		String pesq[];
		
		LeitorArquivo leitor = new LeitorArquivo();
		pesq = leitor.lerData("src/lerArquivoTexto/data.txt");
		
		executarProcesso("src/lerArquivoTexto/"+entrada+".txt",pesq,entrada);

		resultado.terminar();		
		return resultado;
	}
}
