package tools;

import java.util.*;
import java.io.*;

public class Config {
	
	private ArrayList<List<String>> cartas;
	
	public ArrayList<List<String>> getCartas(String caminho) {

		int i, j, k;
		cartas = new ArrayList<List<String>>();
		ArrayList<String> caracteristicas = new ArrayList<String>();
				
		try {
			FileReader input = new FileReader(caminho);
			BufferedReader data = new BufferedReader(input);		
			while(data.ready()) {
				caracteristicas.add(data.readLine());		
			}
			data.close();		
		} catch(Exception ex) {
			System.out.println("Erro " + ex.getMessage());
		}
		for(i = 0, j = 6, k = 0; j <= caracteristicas.size(); i += 6, j +=6, k++) {
			cartas.add(k, caracteristicas.subList(i, j));
		}
		return cartas;
	}
	
	public ArrayList<List<String>> embaralharCartas(ArrayList<List<String>> lista) {
		
		Collections.shuffle(lista);
		return lista;
	}
	
	public ArrayList<List<String>> minhasCartas(ArrayList<List<String>> lista) {
		
		int i;
		ArrayList<List<String>> auxiliar = new ArrayList<List<String>>();
		
		for(i = 0; i < 16; i++) {
			auxiliar.add(lista.get(i));
		}
		return auxiliar;
	}
	
	public ArrayList<List<String>> outrasCartas(ArrayList<List<String>> lista) {
		
		int i;
		ArrayList<List<String>> auxiliar = new ArrayList<List<String>>();
		
		for(i = 16; i < 32; i++) {
			auxiliar.add(lista.get(i));
		}
		return auxiliar;
	}
	
	public void Jogar(ArrayList<List<String>> lista1, ArrayList<List<String>> lista2) {
		
		int i, escolha;
		int score1 = 0, score2 = 0;
		boolean teste;
		List<String> auxiliar1 = new ArrayList<String>();
		List<String> auxiliar2 = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		
		for(i = 0; i < 16; i++) {
			teste = true;
			auxiliar1 = lista1.get(i);
			auxiliar2 = lista2.get(i);
		
			System.out.println();
			System.out.print("\tCARTA: ");
			System.out.println(auxiliar1.get(0));
			System.out.print("\tNOME: ");
			System.out.println(auxiliar1.get(1));
			System.out.println("Escolha seu Atributo: ");
			System.out.print("\t\t1 - TIPO:");
			System.out.println(auxiliar1.get(2));
			System.out.print("\t\t2 - DECOMPOSICAO:");
			System.out.println(auxiliar1.get(3));
			System.out.print("\t\t3 - RECICLAVEL: ");
			System.out.println(auxiliar1.get(4));
			System.out.print("\t\t4 - ATAQUE: ");
			System.out.println(auxiliar1.get(5));
			escolha = input.nextInt();
			while(teste) {
				switch(escolha) {
					case 1:
						teste = false;
						break;
					case 2:
						teste = false;
						break;
					case 3:
						teste = false;
						break;
					case 4:
						int valor1 = Integer.parseInt(auxiliar1.get(5));
						int valor2 = Integer.parseInt(auxiliar2.get(5));
						if(valor2 < valor1) {
							score1++;
							System.out.println("----------RODADA GANHA!----------");
							System.out.println("\t\tSua carta: " + valor1);
							System.out.println("\t\tCarta do ser oponente: " + valor2);
							System.out.println("---------------------------------");
						}
						if(valor1 < valor2) {
							score2++;
							System.out.println("----------RODADA PERDIDA!----------");
							System.out.println("\t\tSua carta: " + valor1);
							System.out.println("\t\tCarta do seu oponente: " + valor2);
							System.out.println("-----------------------------------");
						}
						teste = false;
						break;
					default:
						teste = true;
				}
			}
		}
		if(score1 > score2) {
			System.out.println("vc ganhou");
		} else {
			System.out.println("vc perdeu");
		}
		input.close();
	}
}
