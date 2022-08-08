import java.util.Arrays;
import java.util.Scanner;


class RadixSortDoisDigitos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] numeros = sc.nextLine().split(" ");
		int d = sc.nextInt();
		int[] inteiros = new int[numeros.length];
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(numeros[i]);
		}

		radixSort(inteiros, d);
	}

	public static int[] radixSort(int[] inteiros, int d) {
		for (int i = 2; i <= d; i += 2) {
			inteiros = countingSort(inteiros, i);
			System.out.println(Arrays.toString(inteiros));
		}
		
		return inteiros;
	}

	public static int[] countingSort(int[] inteiros, int nthDig) {
		int[] c = new int[99];
		
		for (int i = 0; i < inteiros.length; i++) {
			int d = (int) (inteiros[i] % Math.pow(10, nthDig));
			d = (int) (d / Math.pow(10, nthDig - 2));
			
			c[d - 1] += 1;
		}
		
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}
		
		int[] b = new int[inteiros.length];
		
		for (int i = inteiros.length - 1; i >= 0; i--) {
			int d = (int) (inteiros[i] % Math.pow(10, nthDig));
			d = (int) (d / Math.pow(10, nthDig - 2));
			
			b[c[d - 1] - 1] = inteiros[i];
			c[d - 1] -= 1;
		}
		
		return b;
	}

}