import java.util.Arrays;
import java.util.Scanner;


class MergeSortPassoAPasso {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] numeros = sc.nextLine().split(" ");
		int[] inteiros = new int[numeros.length];
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(numeros[i]);
		}
		
		mergeSort(inteiros, 0, inteiros.length - 1);
	}
	
	public static void mergeSort(int[] v, int left, int right) {
		imprimeValores(v, left, right);
		
		if (left < right) {
			int middle = (left + right) / 2;
			mergeSort(v, left, middle);
			mergeSort(v, middle + 1, right);
			merge(v, left, middle, right);
		}
	}

	public static void merge(int[] v, int left, int middle, int right) {
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
		
		imprimeValores(v, left, right);
	}
	
	public static void imprimeValores(int[] v, int left, int right) {
		int[] valores = new int[right - left + 1];
		int j = left;
		
		for (int i = 0; i < valores.length; i++) {
			valores[i] = v[j];
			j++;
		}
		
		System.out.println(Arrays.toString(valores));
	}
	
}