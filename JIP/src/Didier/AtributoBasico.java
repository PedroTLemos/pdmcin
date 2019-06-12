package Didier;

public abstract class AtributoBasico {
	private String nome;
	private int valor;
	public AtributoBasico(String nome, int valor) {
		this.nome = nome;
		this.valor = valor;
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
	public abstract int getMod();
}