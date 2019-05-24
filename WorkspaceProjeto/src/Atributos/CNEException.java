package Atributos;

public class CNEException extends Exception{
	//caso a classe/raca inserida nao exista a exceçao sera exposta
	private String classeracaerrada;
	public CNEException (String classeracaerrada) {
		super ("A classe/raca nao existe.");
		this.classeracaerrada = classeracaerrada;
	}
	public String getCE(){
		return classeracaerrada;
	}
}