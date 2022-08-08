package algoritmos;


import java.util.Arrays;
import java.util.Scanner;


public class RadixSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] numeros = sc.nextLine().split(" ");
		int nDig = sc.nextInt();
		int[] inteiros = new int[numeros.length];
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(numeros[i]);
		}
		
		System.out.println(Arrays.toString(radixSort(inteiros, nDig)));
	}

	private static int[] radixSort(int[] a, int nDig) {
		for (int i = 1; i <= nDig; i++) {
			a = countingSort(a, i);
		}
		
		return a;
	}

	private static int[] countingSort(int[] a, int nthDig) {
		int[] c = new int[9];
		
		for (int i = 0; i < a.length; i++) {
			int d = (int) (a[i] % Math.pow(10, nthDig));
			d = (int) (d / Math.pow(10, nthDig - 1));
			
			c[d - 1] += 1;
		}
		
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}
		
		int[] b = new int[a.length];
		
		for (int i = a.length - 1; i >= 0; i--) {
			int d = (int) (a[i] % Math.pow(10, nthDig));
			d = (int) (d / Math.pow(10, nthDig - 1));
			
			b[c[d - 1] - 1] = a[i];
			c[d - 1] -= 1;
		}
		
		return b;
	}

}