package Bruno;
public class RepositorioPericiaLista implements RepositorioPericia {
	private static int identidade = 0;
	private Pericia informacoes;
	private RepositorioPericiaLista proximo;

	public RepositorioPericiaLista(String info){
		this.informacoes = new Pericia(info, identidade++);
	}
	
	public Pericia procurar(String nome) throws NEException {
		if(this.proximo == null)
			throw new NEException(nome);
		else if(nome.equals(this.informacoes.getNome()))
			return new Pericia(this.informacoes.getNome(), this.informacoes.getID());
		else
			return this.proximo.procurar(nome);
	}
	
	public boolean existe(String info) {
		if(this.proximo == null)
			return false;
		else if(info.equals(this.informacoes.getNome()))
			return true;
		else
			return this.proximo.existe(info);
	}

	public void inserir(String info) throws JCException {
		if(this.proximo == null)
			this.proximo = new RepositorioPericiaLista(info);
		else if(info.equals(this.informacoes.getNome()))
			throw new JCException(info);
		else
			this.proximo.inserir(info);
	}

	public void remover(String info) throws NEException {
		if(this.proximo == null)
			throw new NEException(info);
		else if(info.equals(this.proximo.informacoes.getNome()))
			this.proximo = this.proximo.proximo;
		else
			this.proximo.remover(info);
	}

	public void atualizar(Pericia informacaoAtualizada) throws NEException {
		if(this.proximo == null)
			throw new NEException(informacaoAtualizada.getNome());
		else if(informacaoAtualizada.getID()==this.informacoes.getID())
			this.informacoes = new Pericia(informacaoAtualizada.getNome(), this.informacoes.getID());
		else
			this.proximo.atualizar(informacaoAtualizada);
	}
}
