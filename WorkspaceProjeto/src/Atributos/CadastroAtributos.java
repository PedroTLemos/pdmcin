package Atributos;

public class CadastroAtributos {
	private RepositorioAtributos atributos;
	public CadastroAtributos(RepositorioAtributos rep) {
		atributos = rep;
	}
	public void cadastrar(Atributo atributo) throws AtributoJaCadastradoException, ANEException{
		if(!atributos.existe(atributo.getNome())) {
			atributos.inserir(atributo);
		}else {
			throw new AtributoJaCadastradoException(atributo);
		}
	}
	public void dizerClasseERaca(String classe, String raca) throws CNEException, ANEException{
		atributos.digaClasseRaca(classe, raca);
	}
	public void atualizar(Atributo atributo) throws ANEException{
		atributos.atualizar(atributo);;
	}
	public void remover(String atributo) throws ANEException{
		atributos.remover(atributo);;
	}
	public void procurar(String atributo) throws ANEException{
		atributos.procurar(atributo);;
	}
}
