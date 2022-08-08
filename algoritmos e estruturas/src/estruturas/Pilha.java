package estruturas;


public class Pilha {

	private int[] pilha;
    private int capacidade;
    private int topo;

    public Pilha(int capacidade) {
    	this.capacidade = capacidade;
        this.topo = -1;
        this.pilha = new int[capacidade];
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo == (capacidade - 1);
    }

    public void push(int n) {
        if (this.isFull()) {
            throw new RuntimeException("FullStackException");
        }
        
        this.topo += 1;
        this.pilha[topo] = n;
    }
    
    public int pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("EmptyStackException");
        }
        
        int valor_topo = this.pilha[topo];
        topo -= 1;
        
        return valor_topo; 
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("EmptyStackException");
        }
        
        return this.pilha[topo];
    }

    public int size() {
        return this.topo + 1;
    }
    
}