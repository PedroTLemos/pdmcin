package Nilo;
import java.util.*;

public class Fachada {
	public static void main(String[] args) throws TracoJaCadastradoException, TracoNaoEncontradoException {
		Scanner in = new Scanner(System.in);
		RepositorioTracosLista repTracos = new RepositorioTracosLista();
		CadastroTracos tracos = new CadastroTracos(repTracos);
		
		tracos.cadastrar(new Traco("Inteligente", "Vc n e burro"));
		try {
			tracos.cadastrar(new Traco("Inteligente", "nop"));
		}
		catch(Exception TracoJaCadastradoException){
			System.out.println("Traco ja cadastrado");
		}
		tracos.cadastrar(new Traco("Burro", "Vc n e inteligente"));
		tracos.atualizar(new Traco("Burro", "cu"));

		System.out.print(tracos.imprimirTracos());
	}
}
