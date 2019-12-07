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
	
	public List<String> getCores(String caminho) {
		
		List<String> cores = new ArrayList<String>();
		
		try {
			FileReader input = new FileReader(caminho);
			BufferedReader data = new BufferedReader(input);		
			while(data.ready()) {
				cores.add(data.readLine());		
			}
			data.close();		
		} catch(Exception ex) {
			System.out.println("Erro " + ex.getMessage());
		}
		
		return cores;
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
	
	public void Jogar(ArrayList<List<String>> lista1, ArrayList<List<String>> lista2, List<String> cores) {
		
		int i, j, k, l, escolha;
		double dvalor1, dvalor2;
		boolean controle = true;
		int rodada = 1;
		int valor1, valor2;
		String cor1, cor2;
		int score1 = 0, score2 = 0;
		boolean teste;
		List<String> auxiliar1 = new ArrayList<String>();
		List<String> auxiliar2 = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		Random r = new Random();
		
		for(i = 0, j = 1; j < 16; i += 2, j += 2) {
			teste = true;
			auxiliar1 = lista1.get(i);
			auxiliar2 = lista2.get(i);
		
			System.out.println("*************************SUA RODADA*************************");
			System.out.println("\t\t\t\t\tRODADA " + rodada + " de 16");
			System.out.println();
			System.out.print("\tCARTA: ");
			System.out.println(auxiliar1.get(0));
			System.out.print("\tNOME: ");
			System.out.println(auxiliar1.get(1));
			System.out.println("\tESCOLHA SEU ATRIBUTO: ");
			System.out.print("\t\t1 - TIPO: ");
			System.out.println(auxiliar1.get(2));
			System.out.print("\t\t2 - DECOMPOSICAO: ");
			System.out.println(auxiliar1.get(3) + " ANOS");
			System.out.print("\t\t3 - RECICLAVEL: ");
			System.out.println(auxiliar1.get(4));
			System.out.print("\t\t4 - ATAQUE: ");
			System.out.println(auxiliar1.get(5));
			escolha = input.nextInt();
			while(teste) {
				switch(escolha) {
					case 1:
						cor1 = auxiliar1.get(2);
						cor2 = auxiliar2.get(2);
						for(k = 0; ; k += 6) {
							if(cor1.equals(cores.get(k))) {
								break;
							}
						}
						l = k;
						while(controle) {
							l++;
							if(l == k + 6) {
								score2++;
								System.out.println("-------------------------VOCE PERDEU!-------------------------");
								System.out.println("\t\tSUA CARTA: " + cor1);
								System.out.println("\t\tCARTA DO NPC: " + cor2);
								System.out.println("---------------------------------------------------------------------------");
								break;
							}
							if(cores.get(l).equals(cor2)) {
								score1++;
								System.out.println("-------------------------VOCE GANHOU!-------------------------");
								System.out.println("\t\tSUA CARTA: " + cor1);
								System.out.println("\t\tCARTA DO NPC: " + cor2);
								System.out.println("---------------------------------------------------------------------------");
								break;
							}
							if(cores.get(66).equals(cor1)) {
								if(cor2.equals("CINZA")) {
									score2++;
									System.out.println("-------------------------VOCE PERDEU!-------------------------");
									System.out.println("\t\tSUA CARTA: " + cor1);
									System.out.println("\t\tCARTA DO NPC: " + cor2);
									System.out.println("---------------------------------------------------------------------------");
									break;
								} else {
									score1++;
									System.out.println("-------------------------VOCE GANHOU!-------------------------");
									System.out.println("\t\tSUA CARTA: " + cor1);
									System.out.println("\t\tCARTA DO NPC: " + cor2);
									System.out.println("---------------------------------------------------------------------------");
									break;
								}	
							}
							if(cor1.equals(cor2)) {
								System.out.println("-------------------------EMPATE-------------------------");
								System.out.println("DECISAO NAS PROXIMAS RODADAS.");
								System.out.println("\t\tSUA CARTA: " + cor1);
								System.out.println("\t\tCARTA DO NPC: " + cor2);
								System.out.println("---------------------------------------------------------------------------");
							}
						}			 
						teste = false;
						break;
					case 2:
						dvalor1 = Double.parseDouble(auxiliar1.get(3));
						dvalor2 = Double.parseDouble(auxiliar2.get(3));
						if(dvalor1 < dvalor2 && dvalor1 != -1 && dvalor2 != -1) {
							score1++;
							System.out.println("-------------------------VOCE GANHOU!-------------------------");
							System.out.println("\t\tSUA CARTA: " + dvalor1 + " ANOS DE  DECOMPOSICAO");
							System.out.println("\t\tCARTA DO NPC: " + dvalor2 + " ANOS DE  DECOMPOSICAO");
							System.out.println("---------------------------------------------------------------------------");
						}
						if(dvalor2 < dvalor1 && dvalor1 != -1 && dvalor2 != -1) {
							score2++;
							System.out.println("-------------------------VOCE PERDEU!-------------------------");
							System.out.println("\t\tSUA CARTA: " + dvalor1 + " ANOS DE  DECOMPOSICAO");
							System.out.println("\t\tCARTA DO NPC: " + dvalor2 + " ANOS DE  DECOMPOSICAO");
							System.out.println("---------------------------------------------------------------------------");
						}
						if(dvalor2 == -1 && dvalor1 != -1) {
							score1++;
							System.out.println("-------------------------VOCE GANHOU!-------------------------");
							System.out.println("\t\tSUA CARTA: " + dvalor1 + " ANOS DE  DECOMPOSICAO");
							System.out.println("\t\tCARTA DO NPC: DECOMPOSICAO INDETERMINADA");
							System.out.println("---------------------------------------------------------------------------");
						}
						if(dvalor2 != -1 && dvalor1 == -1) {
							score2++;
							System.out.println("-------------------------VOCE PERDEU!-------------------------");
							System.out.println("\t\tSUA CARTA: DECOMPOSICAO INDETERMINADA");
							System.out.println("\t\tCARTA DO NPC: " + dvalor2 + " ANOS DE  DECOMPOSICAO");
							System.out.println("---------------------------------------------------------------------------");
						}
						if(dvalor1 == dvalor2) {
							System.out.println("-------------------------EMPATE-------------------------");
							System.out.println("DECISAO NA PROXIMA RODADA.");
							System.out.println("---------------------------------------------------------------------------");
						}
						teste = false;
						break;
					case 3:
						valor1 = Integer.parseInt(auxiliar1.get(4));
						valor2 = Integer.parseInt(auxiliar2.get(4));
						if(valor1 == 1 && valor2 == 0) {
							score1++;
							System.out.println("-------------------------VOCE GANHOU!-------------------------");
							System.out.println("\t\tSUA CARTA: RECICLAVEL");
							System.out.println("\t\tCARTA DO NPC: NAO RECICLAVEL");
							System.out.println("---------------------------------------------------------------------------");
						}
						if(valor1 == 0 && valor2 == 1) {
							score2++;
							System.out.println("-------------------------VOCE PERDEU!-------------------------");
							System.out.println("\t\tSUA CARTA: NAO RECICLAVEL");
							System.out.println("\t\tCARTA DO NPC: RECICLAVEL");
							System.out.println("---------------------------------------------------------------------------");
						}
						if(valor1 == valor2) {
							System.out.println("-------------------------EMPATE-------------------------");
							System.out.println("DECISAO NA PROXIMA RODADA.");
							System.out.println("---------------------------------------------------------------------------");
						}
						teste = false;
						break;
					case 4:
						valor1 = Integer.parseInt(auxiliar1.get(5));
						valor2 = Integer.parseInt(auxiliar2.get(5));
						if(valor2 < valor1) {
							score1++;
							System.out.println("-------------------------VOCE GANHOU!-------------------------");
							System.out.println("\t\tSUA CARTA: " + valor1 + " PONTOS DE ATAQUE.");
							System.out.println("\t\tCARTA DO NPC: " + valor2 + " PONTOS DE ATAQUE.");
							System.out.println("---------------------------------------------------------------------------");
						}
						if(valor1 < valor2) {
							score2++;
							System.out.println("-------------------------VOCE PERDEU!-------------------------");
							System.out.println("\t\tSUA CARTA: " + valor1 + " PONTOS DE ATAQUE.");
							System.out.println("\t\tCARTA DO NPC:: " + valor2 + " PONTOS DE ATAQUE.");
							System.out.println("---------------------------------------------------------------------------");
						}
						if(valor1 == valor2) {
							System.out.println("-------------------------EMPATE-------------------------");
							System.out.println("DECISAO NA PROXIMA RODADA.");
							System.out.println("---------------------------------------------------------------------------");
						}
						teste = false;
						break;
					default:
						teste = true;
				}
				rodada++;
				System.out.println("\t\t\t\t\tPLACAR: " + " VOCE: " + score1 + " vs " + "NPC: " + score2);
				System.out.println();
			}
			teste = true;
			auxiliar1 = lista1.get(j);
			auxiliar2 = lista2.get(j);
			while(teste) {
				System.out.println("*************************RODADA DO NPC*************************");
				System.out.println("\t\t\t\t\tRODADA " + rodada + " de 16");
				System.out.println();
				switch((r.nextInt(4) + 1)) {
					case 1:
						cor1 = auxiliar1.get(2);
						cor2 = auxiliar2.get(2);
						for(k = 0; ; k += 6) {
							if(cor1.equals(cores.get(k))) {
								break;
							}
						}
						l = k;
						while(controle) {
							l++;
							if(l == k + 6) {
								score2++;
								System.out.println("-------------------------NPC GANHOU!-------------------------");
								System.out.println("\t\tSUA CARTA: " + cor1);
								System.out.println("\t\tCARTA DO NPC: " + cor2);
								System.out.println("---------------------------------------------------------------------------");
								break;
							}
							if(cores.get(l) == cor2) {
								score1++;
								System.out.println("-------------------------NPC PERDEU!-------------------------");
								System.out.println("\t\tSUA CARTA: " + cor1);
								System.out.println("\t\tCARTA DO NPC: " + cor2);
								System.out.println("---------------------------------------------------------------------------");
								break;
							}
							if(cores.get(66).equals(cor1)) {
								if(cor2.equals("CINZA")) {
									score2++;
									System.out.println("-------------------------NPC GANHOU!-------------------------");
									System.out.println("\t\tSUA CARTA: " + cor1);
									System.out.println("\t\tCARTA DO NPC: " + cor2);
									System.out.println("---------------------------------------------------------------------------");
									break;
								} else {
									score1++;
									System.out.println("-------------------------NPC PERDEU!-------------------------");
									System.out.println("\t\tSUA CARTA: " + cor1);
									System.out.println("\t\tCARTA DO NPC: " + cor2);
									System.out.println("---------------------------------------------------------------------------");
									break;
								}
							}
							if(cor1.equals(cor2)) {
								System.out.println("-------------------------EMPATE-------------------------");
								System.out.println("DECISAO NAS PROXIMAS RODADAS.");
								System.out.println("\t\tSUA CARTA: " + cor1);
								System.out.println("\t\tCARTA DO NPC: " + cor2);
								System.out.println("---------------------------------------------------------------------------");
							}
						}
						teste = false;
						break;
					case 2:
						dvalor1 = Double.parseDouble(auxiliar1.get(3));
						dvalor2 = Double.parseDouble(auxiliar2.get(3));
						if(dvalor1 < dvalor2 && dvalor1 != -1 && dvalor2 != -1) {
							score1++;
							System.out.println("-------------------------NPC PERDEU!-------------------------");
							System.out.println("\t\tSUA CARTA: " + dvalor1 + " ANOS DE  DECOMPOSICAO");
							System.out.println("\t\tCARTA DO NPC: " + dvalor2 + " ANOS DE  DECOMPOSICAO");
							System.out.println("---------------------------------------------------------------------------");
						}
						if(dvalor2 < dvalor1 && dvalor1 != -1 && dvalor2 != -1) {
							score2++;
							System.out.println("-------------------------NPC GANHOU!-------------------------");
							System.out.println("\t\tSUA CARTA: " + dvalor1 + " ANOS DE  DECOMPOSICAO");
							System.out.println("\t\tCARTA DO NPC: " + dvalor2 + " ANOS DE  DECOMPOSICAO");
							System.out.println("---------------------------------------------------------------------------");
						}
						if(dvalor2 == -1 && dvalor1 != -1) {
							score1++;
							System.out.println("-------------------------NPC PERDEU!-------------------------");
							System.out.println("\t\tSUA CARTA: " + dvalor1 + " ANOS DE  DECOMPOSICAO");
							System.out.println("\t\tCARTA DO NPC: DECOMPOSICAO INDETERMINADA");
							System.out.println("---------------------------------------------------------------------------");
						}
						if(dvalor2 != -1 && dvalor1 == -1) {
							score2++;
							System.out.println("-------------------------NPC GANHOU!-------------------------");
							System.out.println("\t\tSUA CARTA: DECOMPOSICAO INDETERMINADA");
							System.out.println("\t\tCARTA DO NPC: " + dvalor2 + " ANOS DE  DECOMPOSICAO");
							System.out.println("---------------------------------------------------------------------------");
						}
						if(dvalor1 == dvalor2) {
							System.out.println("-------------------------EMPATE-------------------------");
							System.out.println("DECISAO NA PROXIMA RODADA.");
							System.out.println("---------------------------------------------------------------------------");
						}
						teste = false;
						break;
					case 3:
						valor1 = Integer.parseInt(auxiliar1.get(4));
						valor2 = Integer.parseInt(auxiliar2.get(4));
						if(valor1 == 1 && valor2 == 0) {
							score1++;
							System.out.println("-------------------------NPC PERDEU!-------------------------");
							System.out.println("\t\tSUA CARTA: RECICLAVEL");
							System.out.println("\t\tCARTA DO NPC: NAO RECICLAVEL");
							System.out.println("---------------------------------------------------------------------------");
						}
						if(valor1 == 0 && valor2 == 1) {
							score2++;
							System.out.println("-------------------------NPC GANHOU!-------------------------");
							System.out.println("\t\tSUA CARTA: NAO RECICLAVEL");
							System.out.println("\t\tCARTA DO NPC: RECICLAVEL");
							System.out.println("---------------------------------------------------------------------------");
						}
						if(valor1 == valor2) {
							System.out.println("-------------------------EMPATE-------------------------");
							System.out.println("DECISAO NA PROXIMA RODADA.");
							System.out.println("---------------------------------------------------------------------------");
						}
						teste = false;
						break;
					case 4:
						valor1 = Integer.parseInt(auxiliar1.get(5));
						valor2 = Integer.parseInt(auxiliar2.get(5));
						if(valor2 < valor1) {
							score1++;
							System.out.println("-------------------------NPC PERDEU!-------------------------");
							System.out.println("\t\tSUA CARTA: " + valor1 + " PONTOS DE ATAQUE.");
							System.out.println("\t\tCARTA DO NPC: " + valor2 + " PONTOS DE ATAQUE.");
							System.out.println("---------------------------------------------------------------------------");
						}
						if(valor1 < valor2) {
							score2++;
							System.out.println("-------------------------NPC GANHOU!-------------------------");
							System.out.println("\t\tSUA CARTA: " + valor1 + " PONTOS DE ATAQUE.");
							System.out.println("\t\tCARTA DO NPC: " + valor2 + " PONTOS DE ATAQUE.");
							System.out.println("---------------------------------------------------------------------------");
						}
						teste = false;
						break;
					default:
						System.out.println("TRY AGAIN!");
						teste = true;
				}
				rodada++;
				System.out.println("\t\t\t\t\tPLACAR: " + " VOCE: " + score1 + " vs " + "NPC: " + score2);
				System.out.println();
			}
		}
		if(score1 > score2) {
			System.out.println("-------------------------VOCE GANHOU O JOGO!-------------------------");
		} else {
			if(score1 < score2 ) {
				System.out.println("-------------------------NPC GANHOU O JOGO!-------------------------");
			} else {
				System.out.println("-------------------------EMPATE NO JOGO!-------------------------");
			}
		}
		input.close();
	}
}
