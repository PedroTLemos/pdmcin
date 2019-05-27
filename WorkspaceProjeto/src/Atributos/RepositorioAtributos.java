package Atributos;

public interface RepositorioAtributos {
	//funcoes basicas para inicalizacao de atributos
	public void inserir(Atributo atributo) throws ANEException;
	public void digaClasseRaca(String classe, String raca) throws CNEException;
	public void atualizar(Atributo atributo) throws ANEException;
	public void remover(String atributo) throws ANEException;
	public Atributo procurar(String atributo) throws ANEException;
	public boolean existe(String atributo);
}
