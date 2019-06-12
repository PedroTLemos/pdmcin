package Bruno;
import java.util.Scanner;

public class test {
	public static void main(String[] args) throws JCException, NEException{
		Scanner in = new Scanner(System.in);
		RepositorioPericia repositorio = new RepositorioPericiaArray();
		String temp[] = new String[5];
		Pericia tempd;
		
		while(in.hasNext()){
			repositorio.inserir("a");
		}
		in.close();
	}
}
