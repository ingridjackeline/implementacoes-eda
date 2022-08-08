package algoritmos;


import java.util.Arrays;
import java.util.Scanner;


public class QuickSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] numeros = sc.nextLine().split(" ");
		int[] inteiros = new int[numeros.length];
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(numeros[i]);
		}
		
		quickSort(inteiros, 0, inteiros.length - 1);
		System.out.println(Arrays.toString(inteiros));
	}

	private static void quickSort(int[] v, int left, int right) {
		if (left < right) {
			int index_pivot = partition(v, left, right);
			quickSort(v, left, index_pivot - 1);
			quickSort(v, index_pivot + 1, right);
		}
	}

	private static int partition(int[] v, int left, int right) {
		int pivot = v[left];
		int i = left;
		
		for (int j = left + 1; j<= right; j++) {
			if (v[j] <= pivot) {
				i += 1;
				int aux = v[i];
				v[i] = v[j];
				v[j] = aux;
			}
		}
		
		int aux = v[left];
		v[left] = v[i];
		v[i] = aux;
		
		return i;
	}

}