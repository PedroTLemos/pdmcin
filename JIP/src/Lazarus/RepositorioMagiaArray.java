package Lazarus;

public class RepositorioMagiaArray implements RepositorioMagia {
	private Magia[] magias;
	private int indice;

	public RepositorioMagiaArray(int tam) {
		magias = new Magia[tam];
		indice = 0;
	}

	public void inserir(String magia) {
		magias[indice] = new Magia(magia);
		indice = indice + 1;
	}

	public void atualizar(Magia magia) throws MagiaNaoEncontradaException {
		for (int vdecont = 0; vdecont < indice; vdecont++) {
			if (this.magias[vdecont].getid() == magia.getid()) {
				this.magias[vdecont] = magia;
				return;
			}
		}
		throw new MagiaNaoEncontradaException(magia.getnome());
	}

	public void remover(String nome) throws MagiaNaoEncontradaException {
		boolean a = false;
		if (existe(nome)) {
			for (int i = 0; i < this.indice; i++) {
				if (this.magias[i].getnome().equals(nome)) {
					this.magias[i] = null;
					indice = indice - 1;
				}
			}
		} else {
			throw new MagiaNaoEncontradaException(nome);
		}
	}

	public Magia procurar(String nome) throws MagiaNaoEncontradaException {
		Magia m = null;
		boolean b = false;
		for (int i = 0; i < this.indice && !b; i++) {
			if (magias[i].getnome().equals(nome)) {
				b = true;
				m = magias[i];

			} else {
				throw new MagiaNaoEncontradaException(nome);
			}
		}

		return m;
	}

	public boolean existe(String nome) {
		boolean a = false;
		for (int i = 0; i < this.indice && !a; i++) {
			if (this.magias[i].getnome().equals(nome)) {
				a = true;
			} else {
				a = false;
			}
		}
		return a;
	}
}