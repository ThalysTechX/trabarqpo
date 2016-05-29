package lerArquivoTexto;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import dados.Item;
import dados.ItemABB;

public class LeitorArquivo {
	public String[] lerData(String arq){
		FileInputStream fis = null;
		BufferedReader reader = null;

		try {
			String arquivo = arq;
			arquivo.replaceAll("[^0-9]", "");

			// Prepara o arquivo para leitura.
			fis = new FileInputStream(arquivo);

			// L� o arquivo.
			reader = new BufferedReader(new InputStreamReader(fis));

			// L� linha por linha.
			String linhaDoArquivo = reader.readLine();

			String[] campo = null;

			// Criando o vetor para receber os dados
			String vet[] = new String[200];
			int i = 0;
			
			while (linhaDoArquivo != null) {
				vet[i] = linhaDoArquivo;
				linhaDoArquivo = reader.readLine();
				i++;
			}
			return vet;

		} catch (FileNotFoundException ex) {
			System.out.println("N�o existe esse arquivo.");
			return null;
		} catch (IOException ex) {
			Logger.getLogger(LeitorArquivo.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		} finally {
			try {
				reader.close();
				fis.close();
			} catch (IOException ex) {
				Logger.getLogger(LeitorArquivo.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}	
	
	
	public Item[] ler(String arq) {

		FileInputStream fis = null;
		BufferedReader reader = null;

		try {
			String arquivo = arq;
			int arqTamanho = Integer.parseInt(arquivo.replaceAll("[^0-9]", ""));
			arquivo.replaceAll("[^0-9]", "");

			// Prepara o arquivo para leitura.
			fis = new FileInputStream(arquivo);

			// L� o arquivo.
			reader = new BufferedReader(new InputStreamReader(fis));

			// L� linha por linha.
			String linhaDoArquivo = reader.readLine();

			String[] campo = null;

			// Criando o vetor para receber os dados
			Item vet[] = new Item[arqTamanho];
			int i = 0;

			String dataVenc, nome, cpf, valor, verificador;

			while (linhaDoArquivo != null) {
				campo = linhaDoArquivo.split(";");

				dataVenc = campo[0];
				nome = campo[1];
				cpf = campo[2];
				valor = campo[3];
				verificador = campo[4];

				vet[i] = new Item(dataVenc, nome, cpf, valor);
			
				linhaDoArquivo = reader.readLine();
				i++;
			}
			return vet;

		} catch (FileNotFoundException ex) {
			System.out.println("Arquivo n�o existe.");
			return null;
		} catch (IOException ex) {
			Logger.getLogger(LeitorArquivo.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		} finally {
			try {
				reader.close();
				fis.close();
			} catch (IOException ex) {
				Logger.getLogger(LeitorArquivo.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}
	
	public ItemABB[] lerABB(String arq) {

		FileInputStream fis = null;
		BufferedReader reader = null;

		try {
			String arquivo = arq;
			int arqTamanho = Integer.parseInt(arquivo.replaceAll("[^0-9]", ""));
			arquivo.replaceAll("[^0-9]", "");

			// Prepara o arquivo para leitura.
			fis = new FileInputStream(arquivo);

			// L� o arquivo.
			reader = new BufferedReader(new InputStreamReader(fis));

			// L� linha por linha.
			String linhaDoArquivo = reader.readLine();

			String[] campo = null;

			// Criando o vetor para receber os dados
			ItemABB vet[] = new ItemABB[arqTamanho];
			int i = 0;

			String dataVenc, nome, cpf, valor, verificador;

			while (linhaDoArquivo != null) {
				campo = linhaDoArquivo.split(";");

				dataVenc = campo[0];
				nome = campo[1];
				cpf = campo[2];
				valor = campo[3];
				verificador = campo[4];

				vet[i] = new ItemABB(dataVenc, nome, cpf, valor);
				
				linhaDoArquivo = reader.readLine();
				i++;
			}
			return vet;

		} catch (FileNotFoundException ex) {
			System.out.println("Arquivo n�o existe.");
			return null;
		} catch (IOException ex) {
			Logger.getLogger(LeitorArquivo.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		} finally {
			try {
				reader.close();
				fis.close();
			} catch (IOException ex) {
				Logger.getLogger(LeitorArquivo.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}
}
