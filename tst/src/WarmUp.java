import java.util.Scanner;


class WarmUp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		String[] numeros = sc.nextLine().split(" ");
		String resultados = "";
		
		for (String numero : numeros) {
			int resultado = Integer.parseInt(numero) * n;
			resultados += Integer.toString(resultado) + " ";
		}
		
		System.out.println(resultados.trim());
	}

}