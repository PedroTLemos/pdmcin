package Nilo;

//Repositorio do tipo Array
public class RepositorioTracosArray implements RepositorioTracos{
	private Traco[] tracos;
	private int indice;
	public RepositorioTracosArray(int tam) {
		this.indice = 0;
		tracos = new Traco[tam];
	}
	public void inserir(Traco traco){
		if(indice < tracos.length) {
			tracos[this.indice] = traco;
			this.indice++;
		}
	}
	public Traco procurar(String nome) throws TracoNaoEncontradoException {
		boolean existe = false;
		int indice = 0;
		for(int i = 0; i < this.indice; i++) {
			if(tracos[i].getNome().equals(nome)) {
				existe = true;
				indice = i;
			}
		}
		if(existe) {
			return tracos[indice];
		}
		else {
			throw new TracoNaoEncontradoException(nome);
		}
	}
	public boolean existe(String nome) {
		boolean existe = false;
		for(int i = 0; i <= this.indice; i++) {
			if(tracos[i] != null && tracos[i].getNome().equals(nome)) {
				existe = true;
			}
		}
		return existe;
	}
	public void remover(String nome) throws TracoNaoEncontradoException{
		boolean existe = false;
		int indice = 0;
		for(int i = 0; i < this.indice; i++) {
			if(tracos[i].getNome().equals(nome)) {
				existe = true;
				indice = i;
			}
		}
		if(existe) {
			tracos[indice] = tracos[this.indice-1];
			tracos[this.indice-1] = null;
			this.indice--;
		}
		else {
			throw new TracoNaoEncontradoException(nome);
		}
	}
	public void atualizar(Traco traco) throws TracoNaoEncontradoException{
		boolean existe = false;
		int indice = 0;
		for(int i = 0; i < this.indice; i++) {
			if(tracos[i].getNome().equals(traco.getNome())) {
				existe = true;
				indice = i;
			}
		}
		if(existe) {
			tracos[indice] = traco;
		}
		else {
			throw new TracoNaoEncontradoException(traco.getNome());
		}
	}
	public String[][] imprimirTracos(String[][] imprimir,int indice){
		for(int i = 0; i < imprimir.length; i++) {
			imprimir[i][0] = tracos[i].getNome();
			imprimir[i][1] = tracos[i].getDescricao();
		}
		return imprimir;
	}
	
}
