import java.util.Arrays;
import java.util.Scanner;


class MoveTres {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] numeros = sc.nextLine().split(" ");
		int[] inteiros = new int[numeros.length];
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(numeros[i]);
		}
		
		for (int i = 1; i < inteiros.length; i++) {
			for (int j = i; j > 0; j--) {
				if (inteiros[j] < inteiros[j - 1]) {
					int inteiroAuxiliar = inteiros[j - 1];
					inteiros[j - 1] = inteiros[j];
					inteiros[j] = inteiroAuxiliar;
					System.out.println(Arrays.toString(inteiros));
				} else {
					break;
				}
			}
		}
	}

}