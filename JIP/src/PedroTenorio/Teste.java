package PedroTenorio;

import java.util.*;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		Item ADC = new ItemArmadura("Armadura de Couro", "Armadura simples de couro velho", 2, "Sem efeitos especiais");
		Item ADC2 = new ItemArmadura("Armadura de Couro", "Armadura de couro tratado", 3, "Sem efeitos especiais");
		RepositorioItens rep = new RepositorioItensLista();
		CadastroItens cadastro = new CadastroItens(rep);
		try {
			cadastro.cadastrar(ADC);
		} catch(ItemJaCadastradoException E){
			System.out.println(E.getMessage());
			System.out.println("Voc� j� possui: " + ADC.getNome());
		}
		try {
			cadastro.atualizar(ADC2);
		} catch(ItemNaoEncontradoException E) {
			System.out.println(E.getMessage());
			System.out.println(ADC2.getNome() + " n�o existe!");
		}
		
		
		System.out.println(rep.toString(""));
		
		
		
		

	}

}
