package listaSimplesABB;
import dados.*;
public class No<U extends ObjetoComChave> {
	private U info; // a declara��o do tipo Item est� no capitulo 1
	private No<U> prox;

	public No(U elem){  // a vari�vel elem cont�m os dados que ser�o armazenados
		this.info = elem;
		this.prox = null; // esta linha � opcional, pois o prox � automaticamente 
//definido como null
	}
	public U getInfo (){
		return this.info;
	}
	public void setInfo(U elem){
		this.info = elem;
	}
	public No<U> getProx(){
		return this.prox;
	}
	public void setProx(No<U> _no){
		this.prox = _no;
	}

}
