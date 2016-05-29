package dados;
public class ItemABB extends ObjetoComChave {
	private String dataVenc;
	private String cpf; 
	private String nome;
	private String valor;
	private int chave;

	public ItemABB(String dataVenc, String valor, String nome, String cpf) {
		super();
		this.dataVenc = dataVenc;
		this.valor = valor;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public ItemABB() {
	}
	

	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public String getDataVenc() {
		return dataVenc;
	}

	public void setDataVenc(String dataVenc) {
		this.dataVenc = dataVenc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getChave() {
		return chave;
	}
	
	public String toString2() {
		return this.chave+"";
	}
	
	


	@Override
	public String toString() {
		return "Item [dataVenc=" + dataVenc + ", valor=" + valor  + ", nome="
				+ nome + ", chave=" + chave + "]";
	}
}