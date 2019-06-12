package PedroTenorio;

public class RepositorioItensLista implements RepositorioItens{
	
	private Item item;
	private RepositorioItensLista proximo;
	
	public RepositorioItensLista() {
		this.item = null;
		this.proximo = null;
	}
	
	public boolean existe(String nome) {
		if(this.item != null) {
			if(this.item.getNome().equals(nome)) {
				return true;
			} else {
				return this.proximo.existe(nome);
			}
		} else {
			return false;
		}
	}
	
	public void inserir(Item item) {
		if(this.item == null) {
			this.item = item;
			this.proximo = new RepositorioItensLista();
		} else {
			this.proximo.inserir(item);
		}
	}
	
	public void remover(String nome) throws ItemNaoEncontradoException{
		if(this.item != null) {
			if(this.item.getNome().equals(nome)) {
				this.item = this.proximo.item;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(nome);
			}
		} else {
			throw new ItemNaoEncontradoException();
		}
	}
	
	public void atualizar(Item item) throws ItemNaoEncontradoException{
		if(this.item != null) {
			if(this.item.getNome().equals(item.getNome())) {
				this.item = item;
			} else {
				this.proximo.atualizar(item);
			}
		} else {
			throw new ItemNaoEncontradoException();
		}
	}
	
	public Item procurar(String nome) throws ItemNaoEncontradoException{
		if(this.item != null) {
			if(this.item.getNome().equals(nome)) {
				return this.item;
			} else {
				return this.proximo.procurar(nome);
			}
		} else {
			throw new ItemNaoEncontradoException();
		}
	}
	
	public String toString(String S) {
		if(this.item != null) {
			S += "Nome: " + this.item.getNome() + "\n" + "Incremento de CA: ";
			return this.proximo.toString(S);
		} else {
			return S;
		}
	}

}
