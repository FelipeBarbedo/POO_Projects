
import java.io.*;
import java.util.*;

public class Arquivo {

	public ArrayList<List<String>> arquivoCartas(String caminho) {

		int i, j, k;
		ArrayList<List<String>> cartas= new ArrayList<List<String>>();
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
	
	public ArrayList<List<String>> embaralharArray(ArrayList<List<String>> lista) {
		
		Collections.shuffle(lista);
		
		return lista;
	}
}
