package Lazarus;

public class MagiaNaoEncontradaException extends Exception {
	private String nome;

	public MagiaNaoEncontradaException(String nome) {
		super("Magia não encontrada");
		this.nome = nome;
	}

	public String getnome() {
		return this.getnome();
	}
}