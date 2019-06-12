package Didier;

public class Atributo2 extends AtributoBasico {
	private int modificador;
	public Atributo2(String nome, int valor) {
		super(nome, valor);
		this.modificador = valor;
	}
	public int getMod() {
		return this.modificador;
	}
}