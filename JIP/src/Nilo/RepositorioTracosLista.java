package Nilo;

//Repositório do tipo Lista Encadeada
public class RepositorioTracosLista implements RepositorioTracos{
	private Traco traco;
	private RepositorioTracosLista proximo;
	
	
	public RepositorioTracosLista() {
		this.traco = null;
		this.proximo = null;
	}
	public void inserir(Traco traco){
		if(this.traco == null) {
			this.traco = traco;
			this.proximo = new RepositorioTracosLista();
		}
		else {
			this.proximo.inserir(traco);
		}
	}
	public void atualizar(Traco traco) throws TracoNaoEncontradoException {
		if(this.proximo.proximo != null) {
			if(this.traco.getNome().equals(traco.getNome())) {
				this.traco = traco;
			}
			else {
				this.proximo.atualizar(traco);
			}
		}
		else {
			if(this.traco.getNome().equals(traco.getNome())) {
				this.traco = traco;
			}
			else {
				throw new TracoNaoEncontradoException(traco.getNome());
			}
		}
	}
	public void remover(String nome) throws TracoNaoEncontradoException{
		if(this.proximo != null) {
			if(this.traco.getNome().equals(nome)) {
				this.traco = this.proximo.traco;
				this.proximo = new RepositorioTracosLista();
			}
			else {
				this.proximo.remover(nome);
			}
		}
		else {
			throw new TracoNaoEncontradoException(nome);
		}
	}
	public Traco procurar(String nome) throws TracoNaoEncontradoException{
		if(this.proximo != null) {
			if(this.traco.getNome().equals(nome)) {
				return this.traco;
			}
			else {
				return this.proximo.procurar(nome);
			}
		}
		else {
			throw new TracoNaoEncontradoException(nome);
		}
	}
	public boolean existe(String nome) {
		if(this.traco == null) {
			return false;
		}
		else {
			if(this.proximo != null) {
				if(this.traco.getNome().equals(nome)) {
					return true;
				}
				else {
					return this.proximo.existe(nome);
				}
			}
			else {
				if(this.traco.getNome().equals(nome)) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		
	}
	public String[][] imprimirTracos(String[][] imprimir, int indice){
		if(this.proximo.proximo != null) {
			imprimir[indice][0] = this.traco.getNome();
			imprimir[indice][1] = this.traco.getDescricao();
			return this.proximo.imprimirTracos(imprimir, ++indice);
		}
		else {
			imprimir[indice][0] = this.traco.getNome();
			imprimir[indice][1] = this.traco.getDescricao();
			return imprimir;
		}
	}
}
