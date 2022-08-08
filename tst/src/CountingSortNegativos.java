import java.util.Arrays;
import java.util.Scanner;


class CountingSortNegativos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] numeros = sc.nextLine().split(" ");
		int k = sc.nextInt();
		int menor = sc.nextInt();
		
		int[] inteiros = new int[numeros.length];
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(numeros[i]);
		}
		
		countingSort(inteiros, k, menor);
	}

	public static void countingSort(int[] a, int maior, int menor) {
		int[] c = new int[maior - menor + 1];
		
		for (int i = 0; i < a.length; i++) {
			c[a[i] - menor] += 1;
			System.out.println(Arrays.toString(c));
		}
		
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}
		
		System.out.print("Cumulativa do vetor de contagem - ");
		System.out.println(Arrays.toString(c));
		
		int[] b = new int[a.length];
		
		for (int i = a.length - 1; i >= 0; i--) {
			b[c[a[i] - menor] - 1] = a[i];
			c[a[i] - menor] -= 1;
		}
		
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(b));
	}
	
}