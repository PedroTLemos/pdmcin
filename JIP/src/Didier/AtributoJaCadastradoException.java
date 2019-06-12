package Didier;

public class AtributoJaCadastradoException extends Exception{
	//caso a classe/raca inserida nao exista a exceçao sera exposta
	private String atributo;
	public AtributoJaCadastradoException (Atributo atributo) {
		super ("Atributo ja foi cadastrado.");
		this.atributo = atributo.getNome();
	}
	public String getAJC(){
		return atributo;
	}
}