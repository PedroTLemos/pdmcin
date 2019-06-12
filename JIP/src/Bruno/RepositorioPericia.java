package Bruno;
public interface RepositorioPericia {
	Pericia procurar(String nome) throws NEException;

	boolean existe(String info);

	void inserir(String info) throws JCException;

	void remover(String info) throws NEException;

	void atualizar(Pericia informacaoAtualizada) throws NEException;
}