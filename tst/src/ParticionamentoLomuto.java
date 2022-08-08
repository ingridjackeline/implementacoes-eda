import java.util.Arrays;
import java.util.Scanner;


class ParticionamentoLomuto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] numeros = sc.nextLine().split(" ");
		int[] inteiros = new int[numeros.length];
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(numeros[i]);
		}
		
		particionamentoLomutoReverso(inteiros);
		System.out.println(Arrays.toString(inteiros));
	}

	public static void particionamentoLomutoReverso(int[] valores) {
		int esquerda = 0;
		int direita = valores.length - 1;
		int pivo = valores[direita];
		int i = direita;
		
		for (int j = direita - 1; j >= esquerda; j--) {
			if (valores[j] >= pivo) {
				i--;
				int auxiliarInterno = valores[i];
				valores[i] = valores[j];
				valores[j] = auxiliarInterno;
				System.out.println(Arrays.toString(valores));
			}
		}
		
		int auxiliarExterno = valores[i];
		valores[i] = valores[direita];
		valores[direita] = auxiliarExterno;
		System.out.println(Arrays.toString(valores));
	}
	
}