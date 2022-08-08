import java.util.Scanner;


class MaxPilha {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sequencia = sc.nextLine().split(" ");
		
		Pilha pilha = new Pilha(sequencia.length);
		
		for (String elemento : sequencia) {
			pilha.push(Integer.parseInt(elemento));
		}
		
		Pilha pilhaAuxiliar = new Pilha(sequencia.length);
		
		for (int i = 0; i < sequencia.length; i++) {
			if (!pilha.isEmpty()) {
				pilhaAuxiliar.push(pilha.pop());
			}
		}
		
		int maiorElemento = 0;
		
		for (int i = 0; i < sequencia.length; i++) {
			if (!pilhaAuxiliar.isEmpty()) {
				int elemento = pilhaAuxiliar.peek();
				
				if (elemento > maiorElemento) {
					maiorElemento = elemento;
				}
				
				pilha.push(pilhaAuxiliar.pop());
			}
		}
		
		System.out.println(maiorElemento);
	}

}