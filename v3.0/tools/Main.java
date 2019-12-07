package tools;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {

		Config baralho = new Config();
		ArrayList<List<String>> cartas;
		ArrayList<List<String>> minhasCartas, outrasCartas;
		List<String> cores;
		
		cartas = baralho.getCartas("/home/fbarbedo/eclipse-workspace/caract.txt");
		cartas = baralho.embaralharCartas(cartas);
		minhasCartas = baralho.minhasCartas(cartas);
		outrasCartas = baralho.outrasCartas(cartas);
		cores = baralho.getCores("/home/fbarbedo/eclipse-workspace/cores.txt");
		baralho.Jogar(minhasCartas, outrasCartas, cores);
		
		
	}

}
