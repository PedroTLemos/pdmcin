package Didier;

public class RepositorioAtributosLista implements RepositorioAtributos{
	private AtributoBasico atributo;
	private RepositorioAtributosLista proximo;
	public RepositorioAtributosLista() {
		this.atributo = null;
		this.proximo = null;
	}
	public void inserir(AtributoBasico atributo){
		if(this.atributo == null) {
			this.atributo = atributo;
			this.proximo = new RepositorioAtributosLista();
		}else {
			this.proximo.inserir(atributo);
		}
	}
	public void digaClasseRaca(String classe, String raca) throws CNEException, ANEException{
		switch (raca) {
		case "Elfo":
			this.inserir(new Atributo2("Velocidade", 9));
			this.atualizar(new Atributo2("Destreza", this.procurar("Destreza").getValor()+2));
			this.atualizar(new Atributo2("Inteligencia", this.procurar("Inteligencia").getValor()+1));
			break;
		case "Humano":
			this.inserir(new Atributo2("Velocidade", 9));
			this.atualizar(new Atributo("Forca", this.procurar("Forca").getValor()+1));
			this.atualizar(new Atributo("Destreza", this.procurar("Destreza").getValor()+1));
			this.atualizar(new Atributo("Constituicao", this.procurar("Constituicao").getValor()+1));
			this.atualizar(new Atributo("Inteligencia", this.procurar("Inteligencia").getValor()+1));
			this.atualizar(new Atributo("Sabedoria", this.procurar("Sabedoria").getValor()+1));
			this.atualizar(new Atributo("Carisma", this.procurar("Carisma").getValor()+1));
			break;
		case "Anao":
			this.inserir(new Atributo2("Velocidade", 6));
			this.atualizar(new Atributo2("Constituicao", this.procurar("Constituicao").getValor()+2));
			this.atualizar(new Atributo2("Forca", this.procurar("Forca").getValor()+1));
			break;
		default:
			throw new CNEException(raca);
		}
		this.inserir(new Atributo2("Iniciativa", this.procurar("Destreza").getMod()));
		this.inserir(new Atributo2("Proficiencia", 2));
		this.inserir(new Atributo2("Percepcao Passiva", 10+this.procurar("Sabedoria").getMod()));
		switch (classe) {
		case "Mago":
			this.inserir(new Atributo2("PV", 6+this.procurar("Constituicao").getMod()));
			break;
		case "Guerreiro":
			this.inserir(new Atributo2("PV", 10+this.procurar("Constituicao").getMod()));
			break;
		case "Clerigo":
			this.inserir(new Atributo2("PV", 8+this.procurar("Constituicao").getMod()));
			break;
		default:
			throw new CNEException(classe);
		}
	}
	public void atualizar(AtributoBasico atributo) throws ANEException{
		if(this.atributo.getNome().equals(atributo.getNome())) {
			this.atributo = atributo;
		}else if (this.proximo == null) {
			throw new ANEException(atributo.getNome());
		}else {
			this.proximo.atualizar(atributo);
		}
	}
	public void remover(String atributo) throws ANEException{
		if (this.atributo == null) {
			throw new ANEException(atributo);
		}
		else if(this.atributo.getNome().equals(atributo)) {
			this.atributo = this.proximo.atributo;
			this.proximo = this.proximo.proximo;
		}else {
			this.proximo.remover(atributo);
		}
	}
	public AtributoBasico procurar(String atributo) throws ANEException {
		AtributoBasico aux = null;
		if(this.atributo == null) {
			throw new ANEException(atributo);
		}else if(this.atributo.getNome().equals(atributo)) {
			aux = this.atributo;
			return aux;
		}else {
			return this.proximo.procurar(atributo);
		}
	}
	public boolean existe(String atributo){
		if(this.atributo == null) {
			return false;
		}else if (this.atributo.getNome().equals(atributo)) {
			return true;
		}else {
			return this.proximo.existe(atributo);
		}
	}
	public String saida(String inicial) {
		if (this.atributo != null) {
			inicial += this.atributo.getNome()+": "+this.atributo.getValor();
			switch (this.atributo.getNome()) {
			case "Forca":
			case "Inteligencia":
			case "Destreza":
			case "Sabedoria":
			case "Constituicao":
			case "Carisma":
				inicial += ", Modificador: "+this.atributo.getMod();
			default:
				inicial += "\n";
			}return this.proximo.saida(inicial);
		}else {
			return inicial;
		}
	}
}
