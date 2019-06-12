package Bruno;
public class NEException extends Exception{
	private String nome;
	public NEException(String nome){
		super("N�o existe tal...");
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
} 	