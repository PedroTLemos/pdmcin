package Atributos;

public class RepositorioAtributosLista implements RepositorioAtributos{
	private Atributo atributo;
	private RepositorioAtributosLista proximo;
	public RepositorioAtributosLista() {
		this.atributo = null;
		this.proximo = null;
	}
	public void inserir(Atributo atributo) throws ANEException{
		switch (atributo.getNome()) {
		case "Forca":
		case "Destreza":
		case "Constituiçao":
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
	public void digaClasseRaca(String classe, String raca) throws CNEException{
		switch (classe) {
		case "Mago":
		case "Guerreiro":
		case "Clerigo":
			break;
		default:
			throw new CNEException(classe);
		}
		switch (raca) {
		case "Elfo":
		case "Anao":
		case "Humano":
			break;
		default:
			throw new CNEException(raca);
		}
	}
	public void atualizar(Atributo atributo) throws ANEException{
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
	public Atributo procurar(String atributo) throws ANEException {
		Atributo aux = null;
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
