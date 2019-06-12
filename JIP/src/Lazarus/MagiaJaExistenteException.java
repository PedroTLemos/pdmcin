package Lazarus;

public class MagiaJaExistenteException extends Exception {
	private String nome;

	public MagiaJaExistenteException(String nome) {
		super("Magia já existente");
		this.nome = null;
	}

	public String getnome() {
		return this.nome;
	}
}
