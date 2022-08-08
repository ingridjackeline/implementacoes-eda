package algoritmos;


import java.util.Arrays;
import java.util.Scanner;


public class SelectionSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] numeros = sc.nextLine().split(" ");
		int[] inteiros = new int[numeros.length];
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(numeros[i]);
		}
		
		selectionSort(inteiros);
		System.out.println(Arrays.toString(inteiros));
	}

	private static void selectionSort(int[] v) {
		for (int i = 0; i < v.length - 1; i++) {
			int i_menor = i;
			
			for (int j = i + 1; j < v.length; j++) {
				if (v[j] < v[i_menor]) {
					i_menor = j;
				}
			}
			
			int aux = v[i];
			v[i] = v[i_menor];
			v[i_menor] = aux;
		}
	}

}