package tools;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {

		Config baralho = new Config();
		ArrayList<List<String>> cartas;
		ArrayList<List<String>> minhasCartas, outrasCartas;
		
		cartas = baralho.getCartas("/home/fbarbedo/eclipse-workspace/caract.txt");
	//	System.out.println(cartas.get(31));
		cartas = baralho.embaralharCartas(cartas);
	//	System.out.println(cartas.get(31));
		minhasCartas = baralho.minhasCartas(cartas);
		outrasCartas = baralho.outrasCartas(cartas);
//		System.out.println(minhasCartas.size());
//		System.out.println(outrasCartas.size());
		baralho.Jogar(minhasCartas, outrasCartas);
		
		
	}

}
