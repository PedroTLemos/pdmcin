package Atributos;

public class RepositorioAtributosArray implements RepositorioAtributos{
	private AtributoBasico[] atributos;
	private int i;
	public RepositorioAtributosArray () {
		atributos = new AtributoBasico[11];
	}
	public void inserir(AtributoBasico atributo) throws ANEException {
		switch (atributo.getNome()) {
		case "Forca":
		case "Destreza":
		case "Constituicao":
		case "Inteligencia":
		case "Sabedoria":
		case "Carisma":
		case "Velocidade":
		case "Iniciativa":
		case "PV":
		case "Percepcao Passiva":
		case "Proeficiencia":
			break;
		default:
			throw new ANEException(atributo.getNome());
		}
		atributos[i] = atributo;
		i++;
	}
	public void digaClasseRaca(String classe, String raca) throws CNEException, ANEException {
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
	public void atualizar(AtributoBasico atributo) throws ANEException {
		boolean checar_atualizar = false;
		for (int i = 0; i < atributos.length; i++) {
			if(atributos[i].getNome().equals(atributo.getNome())) {
				atributos[i] = atributo;
				checar_atualizar = true;
			}if(i == atributos.length - 1 && !(checar_atualizar)) {
				throw new ANEException(atributo.getNome());
			}
		}
	}
	public void remover(String atributo) throws ANEException {
		boolean checar_remocao = false;
		for (int i = 0; i < atributos.length; i++) {
			if(atributos[i].getNome().equals(atributo)) {
				this.i = i;
				atributos[i] = null;
				checar_remocao = true;
			}if(i == atributos.length - 1 && !(checar_remocao)) {
				throw new ANEException(atributo);
			}
		}
	}
	public AtributoBasico procurar(String atributo) throws ANEException {
		boolean checar_existe = false;
		AtributoBasico aux = null;
		for (int i = 0; i < atributos.length; i++) {
			if(atributos[i].getNome().equals(atributo)) {
				aux = atributos[i];
				checar_existe = true;
			}if(i == atributos.length - 1 && !(checar_existe)) {
				throw new ANEException(atributo);
			}
		}
		return aux;
	}
	public boolean existe(String atributo) {
		for (int i = 0; i < atributos.length; i++) {
			if(atributos[i].getNome().equals(atributo))
				return true;
		}
		return false;
	}
}
