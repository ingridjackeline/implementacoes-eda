package algoritmos;


import java.util.Arrays;
import java.util.Scanner;


public class BubbleSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] numeros = sc.nextLine().split(" ");
		int[] inteiros = new int[numeros.length];
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(numeros[i]);
		}
		
		bubbleSort(inteiros);
		System.out.println(Arrays.toString(inteiros));
	}

	private static void bubbleSort(int[] v) {
		for (int i = 0; i < v.length; i++) {
			boolean trocou = false;
			
			for (int j = 0; j < v.length - i - 1; j++) {
				if (v[j] > v[j + 1]) {
					int aux = v[j];
					v[j] = v[j + 1];
					v[j + 1] = aux;
					trocou = true;
				}
			}
			
			if (!trocou) {return;}
		}
	}

}