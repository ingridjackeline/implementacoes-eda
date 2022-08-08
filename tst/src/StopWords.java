import java.util.Scanner;


class StopWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] palavrasTexto = sc.nextLine().split(" ");
		String[] stopWords = sc.nextLine().split(" ");
		String textoModificado = "";
		
		for (int i = 0; i < palavrasTexto.length; i++) {
			for (int j = 0; j < stopWords.length; j++) {
				if (stopWords[j].equals(palavrasTexto[i])) {break;}
				
				if (j == stopWords.length - 1) {
					textoModificado += palavrasTexto[i] + " ";
				}
			}
		}
		
		System.out.println(textoModificado.trim());
	}

}