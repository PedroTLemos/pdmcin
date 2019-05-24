package Atributos;

public interface RepositorioAtributos {
	//funcoes basicas para inicalizacao de atributos
	public void inserir_atributo(String atributo, int valor) throws ANEException;
	public void diga_classe_raca(String classe, String raca) throws CNEException;
	public void remover_atributo(String atributo) throws ANEException;
	public Atributo procurar_atributo(String atributo) throws ANEException;
	public boolean existe_atributo(String atributo) throws ANEException;
}
