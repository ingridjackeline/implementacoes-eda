package algoritmos;


import java.util.Arrays;
import java.util.Scanner;


public class InsertionSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] numeros = sc.nextLine().split(" ");
		int[] inteiros = new int[numeros.length];
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(numeros[i]);
		}
		
		insertionSort(inteiros);
		System.out.println(Arrays.toString(inteiros));
	}

	private static void insertionSort(int[] v) {
		for (int i = 1; i < v.length; i++) {
			int j = i;
			
			while (j > 0 && v[j] < v[j - 1]) {
				int aux = v[j];
				v[j] = v[j - 1];
				v[j - 1] = aux;
				j--;
			}
		}
	}

}