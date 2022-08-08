import java.util.Scanner;


class TopN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] numeros = sc.nextLine().split(" ");
		int n = sc.nextInt();
		
		int[] inteiros = new int[numeros.length];
		String maioresElementos = "";
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(numeros[i]);
		}
		
		for (int i = 0; i < inteiros.length - 1; i++) {
			int indiceMaior = i;
			for (int j = i + 1; j < inteiros.length; j++) {
				if (inteiros[j] > inteiros[indiceMaior]) {
					indiceMaior = j;
				}
			}
			
			int inteiroAuxiliar = inteiros[i];
			inteiros[i] = inteiros[indiceMaior];
			inteiros[indiceMaior] = inteiroAuxiliar;
		}
		
		for (int i = 0; i < n; i ++) {
			maioresElementos += inteiros[i] + " ";
		}
		
		System.out.println(maioresElementos.trim());
	}

}