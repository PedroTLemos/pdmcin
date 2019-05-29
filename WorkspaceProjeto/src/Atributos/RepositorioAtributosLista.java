package Atributos;

public class RepositorioAtributosLista implements RepositorioAtributos{
	private AtributoBasico atributo;
	private RepositorioAtributosLista proximo;
	public RepositorioAtributosLista() {
		this.atributo = null;
		this.proximo = null;
	}
	public void inserir(AtributoBasico atributo) throws ANEException{
		switch (atributo.getNome()) {
		case "Forca":
		case "Destreza":
		case "Constituicao":
		case "Inteligencia":
		case "Sabedoria":
		case "Carisma":
			break;
		default:
			throw new ANEException(atributo.getNome());
		}
		if(this.atributo == null) {
			this.atributo = atributo;
			this.proximo = new RepositorioAtributosLista();
		}
	}
	public void digaClasseRaca(String classe, String raca) throws CNEException, ANEException{
		switch (classe) {
		case "Mago":
			this.inserir(new Atributo("PV", 6+this.procurar("Constituicao").getMod()));
		case "Guerreiro":
			this.inserir(new Atributo("PV", 10+this.procurar("Constituicao").getMod()));
		case "Clerigo":
			this.inserir(new Atributo("PV", 8+this.procurar("Constituicao").getMod()));
			break;
		default:
			throw new CNEException(classe);
		}
		switch (raca) {
		case "Elfo":
			this.inserir(new Atributo("Velocidade", 9));
			this.atualizar(new Atributo("Destreza", this.procurar("Destreza").getValor()+2));
			this.atualizar(new Atributo("Inteligencia", this.procurar("Inteligencia").getValor()+1));
			break;
		case "Humano":
			this.inserir(new Atributo("Velocidade", 9));
			this.atualizar(new Atributo("Forca", this.procurar("Destreza").getValor()+1));
			this.atualizar(new Atributo("Destreza", this.procurar("Destreza").getValor()+1));
			this.atualizar(new Atributo("Constituicao", this.procurar("Destreza").getValor()+1));
			this.atualizar(new Atributo("Inteligencia", this.procurar("Destreza").getValor()+1));
			this.atualizar(new Atributo("Sabedoria", this.procurar("Destreza").getValor()+1));
			this.atualizar(new Atributo("Carisma", this.procurar("Destreza").getValor()+1));
			break;
		case "Anao":
			this.inserir(new Atributo("Velocidade", 6));
			this.atualizar(new Atributo("Constituicao", this.procurar("Constituicao").getValor()+2));
			this.atualizar(new Atributo("Forca", this.procurar("Forca").getValor()+1));
			break;
		default:
			throw new CNEException(raca);
		}
		this.inserir(new Atributo("Iniciativa", this.procurar("Destreza").getMod()));
		this.inserir(new Atributo("Proficiencia", 2));
		this.inserir(new Atributo("Percepcao Passiva", 10+this.procurar("Sabedoria").getMod()));
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
}
