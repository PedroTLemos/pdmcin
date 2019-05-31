package Atributos;

public interface RepositorioAtributos {
	//funcoes basicas para inicalizacao de atributos
	public void inserir(AtributoBasico atributo);
	public void digaClasseRaca(String classe, String raca) throws CNEException, ANEException;
	public void atualizar(AtributoBasico atributo) throws ANEException;
	public void remover(String atributo) throws ANEException;
	public AtributoBasico procurar(String atributo) throws ANEException;
	public boolean existe(String atributo);
	public String saida();
}
