import java.util.Scanner;


class InverteFrase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase = sc.nextLine();
		
		String[] palavras = new String[10];
		String palavra = "";
		int j = 0;
		
		for (int i = 0; i < frase.length(); i++) {
			String caractere = Character.toString(frase.charAt(i));
			
			if (caractere.equals(" ")) {
				palavras[j] = palavra;
				palavra = "";
				j++;
			} else {
				palavra += caractere;
			}
			
			if (i == frase.length() - 1) {
				palavras[j] = palavra;
			}
		}
		
		String fraseInvertida = "";
		
		for (int i = palavras.length - 1; i >= 0; i--) {
			if (palavras[i] != null) {
				fraseInvertida += palavras[i] + " ";
			}
		}
		
		System.out.println(fraseInvertida.trim());
	}

}