package Atributos;

public class RepositorioAtributosArray implements RepositorioAtributos{
	private Atributo[] atributos;
	private int i;
	public RepositorioAtributosArray () {
		atributos = new Atributo[27];
	}
	public void inserir(Atributo atributo) throws ANEException {
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
		atributos[i] = atributo;
		i++;
	}
	public void digaClasseRaca(String classe, String raca) throws CNEException {
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
	public void atualizar(Atributo atributo) throws ANEException {
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
	public Atributo procurar(String atributo) throws ANEException {
		boolean checar_existe = false;
		Atributo aux = null;
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
