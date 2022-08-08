import java.util.Scanner;


class VetorCircular {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] valores = sc.nextLine().split(" ");
		int n = sc.nextInt();
		String novaSequencia = "";
		int contador = 0;
		int i = 0;
		
		while (contador < n) {
			if (i == valores.length) {
				i = 0;
			}
			
			novaSequencia += valores[i] + " ";
			contador += 1;
			i += 1;
		}
		
		System.out.println(novaSequencia.trim());
	}

}