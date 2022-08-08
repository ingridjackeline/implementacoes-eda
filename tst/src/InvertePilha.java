import java.util.Scanner;


class InvertePilha {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tamanhoPilha = sc.nextInt();
		sc.nextLine();
		String[] sequencia = sc.nextLine().split(" ");
		
		Pilha pilha1 = new Pilha(tamanhoPilha);
		
		for (String numero : sequencia) {
			pilha1.push(Integer.parseInt(numero));
		}
		
		Pilha pilha2 = new Pilha(tamanhoPilha);
		
		for (int i = 0; i < tamanhoPilha; i++) {
			if (!pilha1.isEmpty()) {
				pilha2.push(pilha1.pop());
			}
		}
		
		for (int i = 0; i < tamanhoPilha; i++) {
			if (!pilha2.isEmpty()) {
				System.out.println(pilha2.pop());
			}
		}
	}

}