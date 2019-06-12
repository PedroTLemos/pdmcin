package PedroTenorio;

public class RepositorioItensArray implements RepositorioItens {

	private Item[] inventario;
	private int indice;

	public RepositorioItensArray() {
		this.inventario = new Item[0];
		this.indice = 0;
	}

	public boolean existe(String nome) {
		boolean existe = false;
		for (int i = 0; i < inventario.length && !(existe); i++) {
			if (inventario[i] != null && inventario[i].getNome().equals(nome)) {
				existe = true;
			}
		}
		indice++;
		return existe;
	}

	public void inserir(Item item) {
		Item[] temporario = new Item[inventario.length + 1];
		if (inventario.length == 0) {
			temporario[0] = item;
		} else {
			for (int i = 0; i < inventario.length || i == 0; i++) {
				temporario[i] = inventario[i];
			}
		}

		temporario[inventario.length] = item;
		inventario = temporario;
	}

	public void remover(String nome) throws ItemNaoEncontradoException {
		if (this.existe(nome)) {
			Item[] temporario = new Item[inventario.length - 1];
			int indicetemporario = 0;
			for (int i = 0; i < inventario.length; i++) {
				if (!(inventario[i].equals(nome))) {
					temporario[indicetemporario] = inventario[i];
					indicetemporario++;
				}
			}
			indice--;
			inventario = temporario;
		} else {
			throw new ItemNaoEncontradoException();
		}
	}

	public void atualizar(Item item) throws ItemNaoEncontradoException {
		if (this.existe(item.getNome())) {
			for (int i = 0; i < inventario.length; i++) {
				if (inventario[i].getNome().equals(item.getNome())) {
					inventario[i] = item;
				}
			}
		} else {
			throw new ItemNaoEncontradoException();
		}
	}

	public Item procurar(String nome) throws ItemNaoEncontradoException {
		Item itemprocurado = null;
		if (this.existe(nome)) {
			for (int i = 0; i < inventario.length; i++) {
				if (inventario[i].getNome().equals(nome)) {
					itemprocurado = inventario[i];
				}
			}
			return itemprocurado;
		} else {
			throw new ItemNaoEncontradoException();
		}
	}

	public String toString(String S) {
		for (int i = 0; i < inventario.length; i++) {
			S += inventario[i].getNome() + "\n";
		}
		return S;
	}

}
