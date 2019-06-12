package Lazarus;

public class CadastrarMagia {
	private RepositorioMagia repositorioMagia;

	public CadastrarMagia() {
		this.repositorioMagia = new RepositorioMagiaLista();
	}

	public void cadastrar(Magia magia) throws MagiaJaExistenteException {
		if (this.repositorioMagia.existe(magia.getnome()))
			throw new MagiaJaExistenteException(magia.getnome());
		this.repositorioMagia.inserir(magia.getnome());
	}

	public Magia procurar(String nome) throws MagiaNaoEncontradaException {
		return this.repositorioMagia.procurar(nome);
	}

	public void remover(String nome) throws MagiaNaoEncontradaException {
		this.repositorioMagia.remover(nome);
	}

	public boolean existe(String nome){
		return this.repositorioMagia.existe(nome);
	}

	public void atualizar(Magia magianova) throws MagiaNaoEncontradaException {
		this.repositorioMagia.atualizar(magianova);
	}
}