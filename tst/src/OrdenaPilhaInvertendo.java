import java.util.Scanner;


class OrdenaPilhaInvertendo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tamanhoPilha = sc.nextInt();
		sc.nextLine();
		String[] sequencia = sc.nextLine().split(" ");
		
		Pilha pilha = new Pilha(tamanhoPilha);
		
		for (String elemento : sequencia) {
			pilha.push(Integer.parseInt(elemento));
		}
		
		for (int i = tamanhoPilha - 1; i >= 0; i--) {
			int maiorElemento = pilha.getMax(i);
			
			Pilha pilhaAuxiliar = new Pilha(i + 1);
			
			int indiceMaiorElemento = 0;
			
			for (int j = 0; j <= i; j++) {
				int elemento = pilha.peek();
				
				if (elemento == maiorElemento) {
					indiceMaiorElemento = j;
					break;
				} else {
					pilhaAuxiliar.push(pilha.pop());
				}
			}
			
			for (int k = 0; k < pilhaAuxiliar.size(); k++) {
				pilha.push(pilhaAuxiliar.pop());
			}
			
			pilha.inverte(indiceMaiorElemento);
			pilha.inverte(i);
		}
		
		System.out.println("-");
		
		for (int i = 0; i < tamanhoPilha; i++) {
			System.out.println(pilha.pop());
		}
	}

}