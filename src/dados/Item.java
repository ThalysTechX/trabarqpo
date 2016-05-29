package dados;
public class Item {
	private String dataVenc;
	private String valor; 
	private String nome;
	private String cpf;
	private int chave;
	
	public Item(String dataVenc, String valor, String nome, String cpf) {
		this.dataVenc = dataVenc;
		this.valor = valor;
		this.nome = nome;
		this.cpf = cpf;
		
		
	}
	
	public Item() {
	}
	
	public String getDataVenc() {
		return dataVenc;
	}

	public void setDataVenc(String dataVenc) {
		this.dataVenc = dataVenc;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getChave() {
		return chave;
	}
	
	public String toString2() {
		return this.chave+"";
	}
	


	@Override
	public String toString() {
		String output = "[dataVenc=" + this.dataVenc +  ", valor=" + this.valor + ", nome="
				+ this.nome  + "]";
		if(this.cpf== null){
			output = this.nome;
		}
		return output+"\n";
	}


}