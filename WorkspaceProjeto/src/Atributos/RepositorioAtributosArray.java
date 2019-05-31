package Atributos;

public class RepositorioAtributosArray implements RepositorioAtributos{
	private AtributoBasico[] atributos;
	private int i;
	public String out = "";
	public RepositorioAtributosArray () {
		atributos = new AtributoBasico[11];
	}
	public void inserir(AtributoBasico atributo) {
		atributos[i] = atributo;
		i++;
	}
	public void digaClasseRaca(String classe, String raca) throws CNEException, ANEException {
		switch (raca) {
		case "Elfo":
			this.inserir(new Atributo2("Velocidade", 9));
			this.atualizar(new Atributo("Destreza", this.procurar("Destreza").getValor()+2));
			this.atualizar(new Atributo("Inteligencia", this.procurar("Inteligencia").getValor()+1));
			break;
		case "Humano":
			this.inserir(new Atributo2("Velocidade", 9));
			this.atualizar(new Atributo("Forca", this.procurar("Destreza").getValor()+1));
			this.atualizar(new Atributo("Destreza", this.procurar("Destreza").getValor()+1));
			this.atualizar(new Atributo("Constituicao", this.procurar("Destreza").getValor()+1));
			this.atualizar(new Atributo("Inteligencia", this.procurar("Destreza").getValor()+1));
			this.atualizar(new Atributo("Sabedoria", this.procurar("Destreza").getValor()+1));
			this.atualizar(new Atributo("Carisma", this.procurar("Destreza").getValor()+1));
			break;
		case "Anao":
			this.inserir(new Atributo2("Velocidade", 6));
			this.atualizar(new Atributo("Constituicao", this.procurar("Constituicao").getValor()+2));
			this.atualizar(new Atributo("Forca", this.procurar("Forca").getValor()+1));
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
	public void atualizar(AtributoBasico atributo) throws ANEException {
		boolean checar_atualizar = false;
		for (int i = 0; i < atributos.length && !checar_atualizar; i++) {
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
		for (int i = 0; i < atributos.length && !checar_remocao; i++) {
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
		for (int i = 0; i < atributos.length && !checar_existe; i++) {
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
			if(atributos[i] != null && atributos[i].getNome().equals(atributo))
				return true;
		}
		return false;
	}
	public String saida(){
		for (int i = 0; i < atributos.length; i++) {
			out += atributos[i].getNome()+": "+atributos[i].getValor();
			switch (atributos[i].getNome()) {
			case "Forca":
			case "Inteligencia":
			case "Destreza":
			case "Sabedoria":
			case "Constituicao":
			case "Carisma":
				out += ", Modificador: "+atributos[i].getMod();
			default:
				out += "\n";
			}
		}
		return out;
	}
}
