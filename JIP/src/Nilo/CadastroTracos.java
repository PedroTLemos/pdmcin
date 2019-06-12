package Nilo;

//Classe Negocio 
public class CadastroTracos {
	private RepositorioTracos tracos;
	private int tamanho;
	
	public CadastroTracos(RepositorioTracos rep) {
		this.tracos = rep;
		this.tamanho = 0;
	}
	public void cadastrar(Traco traco) throws TracoJaCadastradoException{
		if(!tracos.existe(traco.getNome())) {
			tracos.inserir(traco);
			this.tamanho++;
		}
		else {
			throw new TracoJaCadastradoException(traco.getNome());
		}
	}
	public void remover(String nome) throws TracoNaoEncontradoException {
		this.tracos.remover(nome);
		this.tamanho--;
	}
	public void atualizar(Traco traco) throws TracoNaoEncontradoException{
		this.tracos.atualizar(traco);
	}
	public boolean existe(String nome) {
		return this.tracos.existe(nome);
	}	
	public Traco procurar(String nome) throws TracoNaoEncontradoException{
		return this.tracos.procurar(nome);
	}
	public String imprimirTracos(){
		String[][] imprimir = new String[this.tamanho][2];
		for(int i = 0; i < this.tamanho; i++) {
			imprimir[i][0] = "";
			imprimir[i][1] = "";
		}
		String output = "";
		String[][] tracosArray = this.tracos.imprimirTracos(imprimir, 0);
		for(int i = 0; i < tracosArray.length; i++) {
			output = output + tracosArray[i][0] + ": " + tracosArray[i][1] + "\n";
		}
		return output;
	}
}
