import java.util.HashMap;
import java.util.Scanner;


class WordCloud2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] texto = sc.nextLine().split(" ");
		
		HashMap<String, Integer> mapa = new HashMap<>();
		
		for (String palavra : texto) {
			if (mapa.containsKey(palavra)) {
				int frequencia = mapa.get(palavra);
				mapa.put(palavra, frequencia + 1);
			} else {
				mapa.put(palavra, 1);
			}
		}
		
		while (true) {
			String termo = sc.next();
			
			if (termo.equals("fim")) {
				break;
			} else {
				int frequencia = mapa.get(termo);
				System.out.println(frequencia);
			}
		}
	}

}