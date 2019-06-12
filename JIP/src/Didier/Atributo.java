package Didier;

public class Atributo extends AtributoBasico {
	private int modificador;
	public Atributo(String nome, int valor) {
		super(nome, valor);
		this.modificador = Math.floorDiv(valor-10, 2);
	}
	public int getMod() {
		return this.modificador;
	}
}