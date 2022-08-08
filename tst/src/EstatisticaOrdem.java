import java.util.Scanner;


class EstatisticaOrdem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] numeros = sc.nextLine().split(" ");
		int[] inteiros = new int[numeros.length];
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(numeros[i]);
		}
		
		System.out.println(calculaEstatisticaOrdem(inteiros));
	}
	
	public static int calculaEstatisticaOrdem(int[] valores) {
		int pivo = valores[0];
		int i = 0;
		
		for (int j = 1; j <= valores.length - 1; j++) {
			if (valores[j] <= pivo) {
				i++;
				int auxiliarInterno = valores[i];
				valores[i] = valores[j];
				valores[j] = auxiliarInterno;
			}
		}
		
		int auxiliarExterno = valores[i];
		valores[i] = valores[0];
		valores[0] = auxiliarExterno;
		
		return i + 1;
	}

}