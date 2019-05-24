package Atributos;

public class Atributo {
	private String nome;
	private int valor;
	private int modificador;
	public Atributo(String nome, int valor) {
		this.nome = nome;
		this.valor = valor;
		this.modificador = Math.floorDiv(this.valor-10, 2);
	}
	public String getNome() {
		return this.nome;
	}
	public int getValor() {
		return this.valor;
	}
	public void setValor(int n) {
		this.valor += n;
	}
	public int getMod() {
		return this.modificador;
	}
}