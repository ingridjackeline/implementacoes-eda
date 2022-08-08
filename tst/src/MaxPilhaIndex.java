import java.util.Scanner;


class MaxPilhaIndex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] sequencia = sc.nextLine().split(" ");
		int indiceLimite = sc.nextInt();
		
		Pilha pilha = new Pilha(sequencia.length);
		
		for (String elemento : sequencia) {
			pilha.push(Integer.parseInt(elemento));
		}
		
		Pilha pilhaAuxiliar = new Pilha(indiceLimite + 1);
		
		for (int i = 0; i <= indiceLimite; i++) {
			pilhaAuxiliar.push(pilha.pop());
		}
		
		int maiorElemento = 0;
		
		for (int i = 0; i <= indiceLimite; i++) {
			int elemento = pilhaAuxiliar.peek();
			
			if (elemento > maiorElemento) {
				maiorElemento = elemento;
			}
			
			pilha.push(pilhaAuxiliar.pop());
		}
		
		System.out.println(maiorElemento);
	}

}