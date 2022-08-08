package estruturas;


public class Fila {

	private int[] fila;
    private int capacidade, head, tail;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.head = -1;
        this.tail = -1;
        this.fila = new int[capacidade];
    }

    public boolean isEmpty() {
        return (this.head == -1 && this.tail == -1);
    }

    public boolean isFull() {
        return ((this.tail + 1) % capacidade) == this.head; 
    }

    public void add(int n) {
        if (isFull()) {
        	throw new RuntimeException("Is Full");
        }
        
        if (isEmpty()) {
            this.head = 0;
            this.tail = 0;
            this.fila[0] = n;
        } else {
        	tail = (tail + 1) % capacidade;
        	this.fila[tail] = n;
        }
    }

    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("QueuIsEmptyException");
        }
        
        int value = fila[head];
        
        if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = ((this.head + 1) % capacidade);
        }
        
        return value; 
    }

    public int head() {
        if (this.isEmpty()) {
            throw new RuntimeException("QueuIsEmptyException");
        }
        
        return this.fila[head];
    }    
    
}