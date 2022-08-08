import java.util.Scanner;


class InvertePilhaIndex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tamanhoPilha = sc.nextInt();
		sc.nextLine();
		String[] sequencia = sc.nextLine().split(" ");
		int indiceInversao = sc.nextInt();
		
		Pilha pilha = new Pilha(tamanhoPilha);
		
		for (String numero : sequencia) {
			pilha.push(Integer.parseInt(numero));
		}
		
		Pilha pilhaAuxiliar1 = new Pilha(indiceInversao + 1);
		
		for (int i = 0; i <= indiceInversao; i++) {
			pilhaAuxiliar1.push(pilha.pop());
		}
		
		Pilha pilhaAuxiliar2 = new Pilha(indiceInversao + 1);
		
		for (int i = 0; i <= indiceInversao; i++) {
			pilhaAuxiliar2.push(pilhaAuxiliar1.pop());
		}
		
		for (int i = 0; i <= indiceInversao; i++) {
			pilha.push(pilhaAuxiliar2.pop());
		}
		
		System.out.println("-");
		
		for (int i = 0; i < sequencia.length; i++) {
			System.out.println(pilha.pop());
		}
	}

}