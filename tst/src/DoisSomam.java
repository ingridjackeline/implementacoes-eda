import java.util.Scanner;


class DoisSomam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] numeros = sc.nextLine().split(" ");
		int soma = sc.nextInt();
		int[] inteiros = new int[numeros.length];
		String numerosSomados = "";
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(numeros[i]);
		}
		
		for (int i = 0; i < inteiros.length - 1; i++) {
			for (int j = i + 1; j < inteiros.length; j++) {
				if (inteiros[i] + inteiros[j] == soma) {
					numerosSomados += inteiros[i] + " " + inteiros[j];
					break;
				}	
			}
			if (!numerosSomados.isEmpty()) { break; }
		}
		
		if (numerosSomados.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(numerosSomados);
		}
	}

}