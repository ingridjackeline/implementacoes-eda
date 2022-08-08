import java.util.Scanner;


class MarianaLivros {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] nomesLivros = sc.nextLine().split(",");
		
		for (int i = 0; i < nomesLivros.length; i++) {
			int j = i;
			while (j > 0 && nomesLivros[j].compareTo(nomesLivros[j - 1]) < 0) {
				String aux = nomesLivros[j];
				nomesLivros[j] = nomesLivros[j - 1];
				nomesLivros[j - 1] = aux;
				j--;
			}
			
			String nomes = "";
			for (int k = 0; k < nomesLivros.length; k++) {
				nomes += nomesLivros[k];
				
				if (k != nomesLivros.length - 1) {
					nomes += ", ";
				}
			}
			
			System.out.println(nomes);
		}
	}

}