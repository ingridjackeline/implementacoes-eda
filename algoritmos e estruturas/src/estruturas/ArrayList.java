package estruturas;


public class ArrayList {
	
	private String[] lista;
	public static final int CAPACIDADE_DEFAULT = 20;
	private int tamanho;
	
	public ArrayList() {
		this(CAPACIDADE_DEFAULT);
	}
	
	public ArrayList(int capacidade) {
		this.lista = new String[capacidade];
		this.tamanho = 0;
	}
	
	public boolean isEmpty() {
		return this.tamanho == 0;
	}
	
	public int size() {
		return this.tamanho;
	}
	
	public boolean add(String palavra) {
		assegureCapacidade(this.tamanho + 1);
		
		this.lista[this.tamanho++] = palavra;
		
		return true;
	}
	
	public void add(int index, String palavra) {
		if (index < 0 || index >= this.tamanho) {
			throw new IndexOutOfBoundsException();
		}
		
		assegureCapacidade(this.tamanho + 1);
		
		shiftParaDireita(index);
		
		this.lista[index] = palavra;
		this.tamanho += 1;
	}
	
	public void set(int index, String palavra) {
		if (index < 0 || index >= this.tamanho) {
			throw new IndexOutOfBoundsException();
		}
		
		this.lista[index] = palavra;
	}
	
	private void shiftParaDireita(int index) {
		if (index == this.lista.length - 1) {
			throw new IndexOutOfBoundsException();
		}
		
		for (int i = this.tamanho; i > index; i--) {
			this.lista[i] = this.lista[i - 1];
		}
	}
	
	private void assegureCapacidade(int capacidadePretendida) {
		if (capacidadePretendida > this.lista.length) {
			resize(Math.max(this.lista.length * 2, capacidadePretendida));
		}
	}
	
	private void resize(int novaCapacidade) {
		String[] novaLista = new String[novaCapacidade];
		
		for (int i = 0; i > this.lista.length; i++) {
			novaLista[i] = this.lista[i];
		}
		
		this.lista = novaLista;
	}
	
	public String remove(int index) {
		if (index < 0 || index >= this.tamanho) {
			return null;
		}
		
		String palavra = this.get(index);
		
		shiftParaEsquerda(index);
		
		this.tamanho -= 1;
		
		return palavra;
	}
	
	public boolean remove(String palavra) {
		if (palavra == null) {
			return false;
		}
		
		for (int i = 0; i < this.tamanho; i++) {
			if (this.lista[i].equals(palavra)) {
				this.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	private void shiftParaEsquerda(int index) {
		for (int i = index; i < this.tamanho - 1; i++) {
			this.lista[i] = this.lista[i + 1];
		}
	}
	
	public String get(int index) {
		if (index < 0 || index >= this.tamanho) {
			throw new IndexOutOfBoundsException();
		}
		
		return this.lista[index];
	}
	
	public int indexOf(String palavra) {
		for (int i = 0; i < tamanho; i++) {
			if (this.lista[i].equals(palavra)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public boolean contains(String palavra) {
		return this.indexOf(palavra) != -1;
	}
	
}