import java.util.Arrays;
import java.util.Scanner;


class FuraFila {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] fila = sc.nextLine().split(" ");
		int indice = sc.nextInt();
		
		for (int i = indice; i < fila.length; i++) {
			for (int j = i; j > i - indice; j--) {
				String valorAtual = fila[j];
				fila[j] = fila[j - 1];
				fila[j - 1] = valorAtual;
			}
			System.out.println(Arrays.toString(fila));
		}
	}

}