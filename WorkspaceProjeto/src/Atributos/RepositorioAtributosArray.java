package Atributos;

public class RepositorioAtributosArray implements RepositorioAtributos{
	private Atributo[] atributos;
	private int i;
	public RepositorioAtributosArray (int tamanho) {
		atributos = new Atributo[tamanho];
	}
	public void inserir_atributo(String atributo, int valor) throws ANEException {
		switch (atributo) {
		case "Forca":
		case "Destreza":
		case "Constituiçao":
		case "Inteligencia":
		case "Sabedoria":
		case "Carisma":
			break;
		default:
			throw new ANEException(atributo);
		}
		atributos[i] = new Atributo(atributo, valor);
		i++;
	}
	public void diga_classe_raca(String classe, String raca) throws CNEException {
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
}
