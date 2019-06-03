package Atributos;

public interface RepositorioAtributos {
	//funcoes basicas para inicalizacao de atributos
	public void inserir(AtributoBasico atributo); //insere o atributo
	public void digaClasseRaca(String classe, String raca) throws CNEException, ANEException; //altera atributos
	//baseado em classe e raca
	public void atualizar(AtributoBasico atributo) throws ANEException; //atualizacao de dados
	public void remover(String atributo) throws ANEException; //remove atributo
	public AtributoBasico procurar(String atributo) throws ANEException; //procura e retorna atributo
	public boolean existe(String atributo); //verifica a existencia do objeto
	public String saida(String inicial); //retorna string de saida
}
