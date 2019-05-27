package Atributos;

public class ANEException extends Exception{
	//caso o atributo inserido nao exista a exceçao sera exposta
	private String atributoerrado;
	public ANEException (String atributoerrado) {
		super ("O atributo nao existe.");
		this.atributoerrado = atributoerrado;
	}
	public String getAE(){
		return atributoerrado;
	}
}