package Atributos;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		RepositorioAtributosArray rep = new RepositorioAtributosArray();
		CadastroAtributos cadastro = new CadastroAtributos(rep);
		for (int i = 0; i < 6; i++) {
			try {
				cadastro.cadastrar(new Atributo(in.next(), in.nextInt()));
			}
			catch(AtributoJaCadastradoException k) {
				System.out.println(k.getMessage());
				System.out.println("Atributo ja inserido: "+k.getAJC());
			}
		}
		try {
			cadastro.dizerClasseERaca(in.next(), in.next());
		}
		catch(ANEException k) {
			System.out.println(k.getMessage());
			System.out.println("Atributo errado/ausente: "+k.getAE());
		}
		catch(CNEException j) {
			System.out.println(j.getMessage());
			System.out.println(j.getCE()+" nao esta presente nessa versao");
		}
		System.out.println(cadastro.saida(""));
	}
}
