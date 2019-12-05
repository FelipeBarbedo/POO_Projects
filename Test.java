
import java.util.*;

public class Test {

	public static void main(String[] args) {

		ArrayList<List<String>> cartas = new ArrayList<List<String>>();
		Arquivo baralho = new Arquivo();
		
		cartas = baralho.arquivoCartas("/home/fbarbedo/eclipse-workspace/caract.txt");
		System.out.println(cartas.get(31));
		cartas = baralho.embaralharArray(cartas);
		
		System.out.println(cartas.get(31));
	}
}
