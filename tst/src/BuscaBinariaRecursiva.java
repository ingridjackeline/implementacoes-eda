import java.util.Scanner;


class BuscaBinariaRecursiva {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] numeros = sc.nextLine().split(" ");
		int n = sc.nextInt();
		int[] inteiros = new int[numeros.length];
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(numeros[i]);
		}
		
		buscaBinaria(inteiros, n, 0, inteiros.length - 1);
	}
	
	public static void buscaBinaria(int[] inteiros, int n, int inicio, int fim) {
		if (inicio <= fim) {
			int meio = (inicio + fim) / 2;
			System.out.println(meio);
			
			if (inteiros[meio] > n) {
				buscaBinaria(inteiros, n, inicio, meio - 1);
			} else if (inteiros[meio] < n) {
				buscaBinaria(inteiros, n, meio + 1, fim);
			}
		} else {
			System.out.println(-1);
		}
	}

}