package Lazarus;

public class RepositorioMagiaLista implements RepositorioMagia {
	private Magia magia;
	private RepositorioMagiaLista proximo;
	private int indice;
	private String nome;

	public RepositorioMagiaLista() {
		magia = null;
		proximo = null;
		indice = 0;
		nome = magia.getnome();
	}

	public void inserir(String magia) {
		if (this.magia == null) {
			this.magia = new Magia(magia);
			this.proximo = new RepositorioMagiaLista();
			this.indice = this.indice + 1;
		} else {
			this.proximo.inserir(magia);
		}
	}

	public void atualizar(Magia magia) throws MagiaNaoEncontradaException {
		if (this.magia.getid() == magia.getid()) {
			this.magia = magia;
			return;
		} else if (this.proximo == null) {
			throw new MagiaNaoEncontradaException(magia.getnome());
		} else {
			this.proximo.atualizar(magia);
		}

	}

	public void remover(String magia) throws MagiaNaoEncontradaException {
		if (this.magia != null) {
			if (this.magia.getnome().equals(magia)) {
				this.magia = this.proximo.magia;
				this.proximo = this.proximo.proximo;
				this.indice = this.indice - 1;
			} else {
				this.proximo.remover(magia);
			}
		} else {
			throw new MagiaNaoEncontradaException(magia);
		}
	}

	public Magia procurar(String nome) throws MagiaNaoEncontradaException {
		if (existe(nome)) {
			if (this.magia.getnome().equals(nome)) {
				return this.magia;
			} else if (!this.magia.getnome().equals(nome)) {
				this.proximo.procurar(nome);
				return null;
			} else {
				throw new MagiaNaoEncontradaException(nome);
			}
		} else {
			return null;
		}
	}

	public boolean existe(String nome) {
		boolean a = false;
		if (nome.equals(this.magia.getnome())) {
			a = true;
		} else {
			proximo.existe(nome);
			if (!existe(nome)) {
				a = false;
			}
		}

		return a;
	}
}