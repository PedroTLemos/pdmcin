package PedroTenorio;

public class CadastroItens {
	
	private RepositorioItens inventario;
	
	public CadastroItens(RepositorioItens rep) {
		this.inventario = rep;
	}
	
	public void cadastrar(Item item) throws ItemJaCadastradoException{
		if(!inventario.existe(item.getNome())) {
			this.inventario.inserir(item);
		} else {
			throw new ItemJaCadastradoException();
		}
	}
	
	public void atualizar(Item item) throws ItemNaoEncontradoException{
		this.inventario.atualizar(item);
	}
	
	public void remover(String nome) throws ItemNaoEncontradoException{
		this.inventario.remover(nome);
	}
	
	public void procurar(String nome) throws ItemNaoEncontradoException{
		this.inventario.procurar(nome);
	}
	
	public boolean existe(String nome) {
		return this.inventario.existe(nome);
	}

}
