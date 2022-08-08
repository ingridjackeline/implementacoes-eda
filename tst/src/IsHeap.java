import java.util.Scanner;


class IsHeap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] sequencia = sc.nextLine().split(" ");
		int[] inteiros = new int[sequencia.length];
		
		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(sequencia[i]);
		}
		
		Heap arvore = new Heap(inteiros);
		int[] arrayHeap = arvore.getHeap();
		boolean isHeap = true;
		
		for (int i = 0; i < sequencia.length; i++) {
			if (Integer.parseInt(sequencia[i]) != arrayHeap[i]) {
				isHeap = false;
				break;
			}
		}
		
		System.out.println(isHeap);
	}

}


class Heap {

	private int[] heap;
	private int tail;
	
	public Heap(int capacidade) {
		this.heap = new int[capacidade];
		this.tail = -1;
	}
	
	public Heap(int[] heap) {
		this.heap = heap;
		this.tail = this.heap.length - 1;
		
		this.buildHeap();
	}
	
	public int[] getHeap() {
		return this.heap;
	}
	
	public boolean isEmpty() {
		return this.tail == -1;
	}
	
	public int left(int index) {
		return 2 * index + 1;
	}
	
	public int right(int index) {
		return 2 * (index + 1);
	}
	
	public int parent(int index) {
		return (index - 1) / 2;
	}
	
	public void add(int n) {
		if (this.tail >= (this.heap.length - 1)) {
			this.resize();
		}
		
		this.tail += 1;
		this.heap[this.tail] = n;

		int i = this.tail;
		
		while (i > 0 && this.heap[this.parent(i)] < this.heap[i]) {
			int aux = this.heap[i];
			this.heap[i] = this.heap[this.parent(i)];
			this.heap[this.parent(i)] = aux;
			i = this.parent(i);
		}
	}
	
	public int remove() {
		if (this.isEmpty()) {
			throw new RuntimeException("Empty");
		}
		
		int element = this.heap[0];
		this.heap[0] = this.heap[tail];
		this.tail -= 1;
		
		this.heapify(0);
		
		return element;
	}
	
	private void heapify(int index) {
		if (this.isLeaf(index) || !this.isValidIndex(index)) {
			return;
		}
		
		int indexMax = this.maxIndex(index, this.left(index), this.right(index));
		
		if (indexMax != index) {
			this.swap(index, indexMax);
			this.heapify(indexMax);
		}
	}
	
	private int maxIndex(int index, int left, int right) {
		if (this.heap[index] > this.heap[left]) {
			if (this.isValidIndex(right)) {
				if (this.heap[index] < this.heap[right]) {
					return right;
				}
			}
			
			return index;
		} else {
			if (this.isValidIndex(right)) {
				if (this.heap[left] < this.heap[right]) {
					return right;
				}
			}
			
			return left;
		}
	}
	
	private boolean isValidIndex(int index) {
		return index >= 0 && index <= this.tail;
	}
	
	private boolean isLeaf(int index) {
		return index > this.parent(tail) && index <= this.tail;
	}
	
	private void swap(int i, int j) {
		int aux = this.heap[i];
		this.heap[i] = this.heap[j];
		this.heap[j] = aux;
	}
	
	private void resize() {
		int[] novoHeap = new int[this.heap.length * 2];
		
		for (int i = 0; i <= this.tail; i++) {
			novoHeap[i] = this.heap[i];
		}
		
		this.heap = novoHeap;
	}
	
	public int size() {
		return this.tail + 1;
	}
	
	private void buildHeap() {
		for (int i = this.parent(this.tail); i >= 0; i--) {
			this.heapify(i);
		}
	}
	
}