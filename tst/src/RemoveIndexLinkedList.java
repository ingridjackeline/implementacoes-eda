import java.util.Scanner;


class RemoveIndexLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] sequencia = sc.nextLine().split(" ");
		int indice = sc.nextInt();
		
		LinkedList lista = new LinkedList();
		
		for (String elemento : sequencia) {
			lista.addLast(Integer.parseInt(elemento));
		}
		
		lista.removeByIndex(indice);
		
		String novaSequencia = "";
		
		for (int i = 0; i < lista.size(); i++) {
			novaSequencia += lista.get(i) + " ";
		}
		
		System.out.println(novaSequencia.trim());
	}

}