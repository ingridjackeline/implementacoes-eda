import java.util.Scanner;


class MelhorPivot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] numeros = sc.nextLine().split(" ");
		int i = sc.nextInt();
		int j = sc.nextInt();
		int[] inteiros = new int[numeros.length];
		
		for (int k = 0; k < inteiros.length; k++) {
			inteiros[k] = Integer.parseInt(numeros[k]);
		}
		
		System.out.println(escolheIndiceMelhorPivot(inteiros, i, j));
	}
	
	public static int escolheIndiceMelhorPivot(int[] valores, int i, int j) {
		int esquerda = 0;
		int direita = valores.length - 1;
		int meio = (esquerda + direita) / 2;
		
		int[] valoresChave = {valores[esquerda], valores[meio], valores[direita]};
		particiona(valoresChave);
		
		int mediana = valoresChave[1];
		if (Math.abs(mediana - valores[i]) <= Math.abs(mediana - valores[j])) {
			return i;
		} else {
			return j;
		}
	}
	
	public static void particiona(int[] sequencia) {
		int pivo = sequencia[0];
		int i = 0;
		
		for (int j = 1; j <= sequencia.length - 1; j++) {
			if (sequencia[j] <= pivo) {
				i++;
				int auxiliarInterno = sequencia[i];
				sequencia[i] = sequencia[j];
				sequencia[j] = auxiliarInterno;
			}
		}
		
		int auxiliarExterno = sequencia[i];
		sequencia[i] = sequencia[0];
		sequencia[0] = auxiliarExterno;
	}

}