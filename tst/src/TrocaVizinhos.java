import java.util.Arrays;
import java.util.Scanner;


class TrocaVizinhos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] numeros = sc.nextLine().split(" ");
		int[] inteiros = new int[numeros.length];
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(numeros[i]);
		}
		
		for (int i = 0; i < inteiros.length; i++) {
			if (i % 2 == 0 && i < inteiros.length - 1) {
				int inteiroTrocado = inteiros[i];
				inteiros[i] = inteiros[i + 1];
				inteiros[i + 1] = inteiroTrocado;
			}
		}
		
		System.out.println(Arrays.toString(inteiros));
	}

}