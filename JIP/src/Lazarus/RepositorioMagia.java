package Lazarus;

public interface RepositorioMagia {
	void inserir(String magia);
	void atualizar(Magia magia) throws MagiaNaoEncontradaException;
	void remover(String nome) throws MagiaNaoEncontradaException;
	Magia procurar(String nome) throws MagiaNaoEncontradaException;
	boolean existe(String nome);
}