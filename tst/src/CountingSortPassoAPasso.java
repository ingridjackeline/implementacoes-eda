import java.util.Scanner;


class CountingSortPassoAPasso {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] numeros = sc.nextLine().split(" ");
		int k = sc.nextInt();
		int[] inteiros = new int[numeros.length];
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(numeros[i]);
		}
		
		countingSort(inteiros, k);
	}

	public static void countingSort(int[] a, int k) {
		int[] c = new int[k + 1];
		
		for (int i = 0; i < a.length; i++) {
			c[a[i]] += 1;
			imprimeStatus(c);
		}
		
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}
		
		System.out.print("Cumulativa do vetor de contagem - ");
		imprimeStatus(c);
		
		int[] b = new int[a.length];

		for (int i = a.length - 1; i >= 0; i--) {
			b[c[a[i]] - 1] = a[i];
			c[a[i]] -= 1;
		}
		
		imprimeStatus(c);
		imprimeStatus(b);
	}
	
	public static void imprimeStatus(int[] v) {
		String status = "";
		
		for (int inteiro : v) {
			status += inteiro + " ";
		}
		
		System.out.println(status.trim());
	}

}