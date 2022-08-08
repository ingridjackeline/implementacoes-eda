import java.util.Scanner;


class ElementAtPilha {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sequencia = sc.nextLine().split(" ");
		int indiceProcurado = sc.nextInt();
		
		Pilha pilha = new Pilha(sequencia.length);
		
		for (String elemento : sequencia) {
			pilha.push(Integer.parseInt(elemento));
		}
		
		if (indiceProcurado >= 0 && indiceProcurado < sequencia.length) {
			Pilha pilhaAuxiliar = new Pilha(sequencia.length);
			
			for (int i = 0; i < sequencia.length; i++) {
				if (!pilha.isEmpty()) {
					pilhaAuxiliar.push(pilha.pop());
				}
			}
			
			int indice = -1;
			int elementoProcurado = 0;
			
			for (int i = 0; i < sequencia.length; i++) {
				if (!pilhaAuxiliar.isEmpty()) {
					indice += 1;
					
					if (indice == indiceProcurado) {
						elementoProcurado = pilhaAuxiliar.peek();
					}
					
					pilha.push(pilhaAuxiliar.pop());
				}
			}
			
			System.out.println(elementoProcurado);
		} else {
			System.out.println("indice invalido");
		}
	}

}