package algoritmos;


import java.util.Arrays;
import java.util.Scanner;


public class MergeSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] numeros = sc.nextLine().split(" ");
		int[] inteiros = new int[numeros.length];
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(numeros[i]);
		}
		
		mergeSort(inteiros, 0, inteiros.length - 1);
		System.out.println(Arrays.toString(inteiros));
	}
	
	private static void mergeSort(int[] v, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			mergeSort(v, left, middle);
			mergeSort(v, middle + 1, right);
			merge(v, left, middle, right);
		}
	}

	private static void merge(int[] v, int left, int middle, int right) {
		int[] helper = new int[v.length];
		
		for (int i = left; i <= right; i++) {
			helper[i] = v[i];
		}
		
		int i = left;
		int j = middle + 1;
		int k = left;
		
		while (i <= middle && j <= right) {
			if (helper[i] < helper[j]) {
				v[k++] = helper[i++];
			} else {
				v[k++] = helper[j++];
			}
		}
		
		while (i <= middle) {
			v[k++] = helper[i++];
		}
		
		while (j <= right) {
			v[k++] = helper[j++];
		}
	}

}