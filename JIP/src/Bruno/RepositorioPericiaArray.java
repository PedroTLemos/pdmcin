package Bruno;
public class RepositorioPericiaArray implements RepositorioPericia {
	private Pericia array[];
	private int identidade, indice;
	
	public Pericia procurar(String info) throws NEException {
		for(int i = 0; i < indice; i++)
			if(info.equals(this.array[i].getNome()))
				return new Pericia(this.array[i].getNome(), this.array[i].getID());
		throw new NEException(info);
	}
	
	public boolean existe(String info) {
		for(int i = 0; i < indice; i++)
			if(info.equals(this.array[i].getNome()))
				return true;
		return false;
	}
	
	public void inserir(String info) throws JCException {
		if(this.existe(info))
			throw new JCException(info);
		if(indice < this.array.length)
			this.array[indice++] = new Pericia(info, identidade++);
		else {
			Pericia temp[] = new Pericia[2 * this.array.length];
			
			for(int i = 0; i < this.array.length; i++)
				temp[i] = this.array[i];
			
			temp[indice++] = new Pericia(info, identidade++);
			
			this.array = temp;
		}
	}
	
	public void remover(String info) throws NEException {
		int i = 0;
		for(i = 0; i < indice && info.equals(this.array[i].getNome()); i++);
		
		if(i == indice)
			throw new NEException(info);
		
		for(indice--; i < indice; i++)
			this.array[i] = this.array[i + 1];
	}
	
	public void atualizar(Pericia informacaoAtualizada) throws NEException {
		for(int i = 0; i < indice; i++)
			if(this.array[i].getID() == informacaoAtualizada.getID()) {
				this.array[i] = new Pericia(informacaoAtualizada.getNome(), this.array[i].getID());
				return;
			}
		
		throw new NEException(informacaoAtualizada.getNome());
	}
}