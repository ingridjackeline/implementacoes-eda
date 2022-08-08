import java.util.Arrays;
import java.util.Scanner;


class OperacoesHashSet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tamanhoTabela = sc.nextInt();
		sc.nextLine();
		
		HashSet conjunto = new HashSet(tamanhoTabela);
		
		while (true) {
			String[] operacao = sc.nextLine().split(" ");
			String comando = operacao[0];
			
			if (comando.equals("end")) {
				break;
			} else {
				int valor = Integer.parseInt(operacao[1]);
				
				if (comando.equals("put")) {
					conjunto.put(valor);
					System.out.println(Arrays.toString(conjunto.getConjunto()));
				} else if (comando.equals("remove")) {
					conjunto.remove(valor);
					System.out.println(Arrays.toString(conjunto.getConjunto()));
				} else if (comando.equals("contains")) {
					System.out.println(conjunto.contains(valor));
				}
			}
		}
	}

}


class HashSet {
	
	private Integer[] conjunto;
	private int capacidade;
	
	public HashSet(int capacidade) {
		this.conjunto = new Integer[capacidade];
		this.capacidade = capacidade;
	}
	
	private int hash(int chave) {
		return chave % this.capacidade;
	}
	
	public Integer[] getConjunto() {
		return this.conjunto;
	}
	
	public void put(int valor) {
		if (!this.contains(valor)) {
			int sondagem = 0;
			int hash = 0;
			
			while (sondagem < this.capacidade) {
				hash = (this.hash(valor) + sondagem) % this.capacidade;
				
				if (this.conjunto[hash] == null) {
					this.conjunto[hash] = valor;
					return;
				}
				
				sondagem += 1;
			}
		}
	}
	
	public void remove(int valor) {
		if (this.contains(valor)) {
			for (int i = 0; i < this.capacidade; i++) {
				if (this.conjunto[i] != null && conjunto[i] == valor) {
					this.conjunto[i] = null;
					break;
				}
			}
		}
	}
	
	public boolean contains(int valor) {
		for (Integer numero : this.conjunto) {
			if (numero != null && numero == valor) {
				return true;
			}
		}
		
		return false;
	}
	
}