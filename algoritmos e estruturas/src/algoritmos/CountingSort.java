package algoritmos;


import java.util.Arrays;
import java.util.Scanner;


public class CountingSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] numeros = sc.nextLine().split(" ");
		int k = sc.nextInt();
		int[] inteiros = new int[numeros.length];
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(numeros[i]);
		}
		
		System.out.println(Arrays.toString(countingSort(inteiros, k)));
	}

	private static int[] countingSort(int[] a, int k) {
		int[] c = new int[k];
		
		for (int i = 0; i < a.length; i++) {
			c[a[i] - 1] += 1;
		}
		
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}
		
		int[] b = new int[a.length];

		for (int i = a.length - 1; i >= 0; i--) {
			b[c[a[i] - 1] - 1] = a[i];
			c[a[i] - 1] -= 1;
		}
		
		return b;
	}

}