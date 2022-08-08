class Pilha {

	private int[] pilha;
    private int capacidade;
    private int topo;

    public Pilha(int capacidade) {
    	this.capacidade = capacidade;
        this.topo = -1;
        this.pilha = new int[capacidade];
    }
    
    public int[] getPilha() {
    	return this.pilha;
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
    
    public int getMax(int indice) {
    	Pilha pilhaAuxiliar = new Pilha(indice + 1);
		
		for (int i = 0; i <= indice; i++) {
			pilhaAuxiliar.push(this.pop());
		}
		
		int maiorElemento = 0;
		
		for (int i = 0; i <= indice; i++) {
			int elemento = pilhaAuxiliar.peek();
			
			if (elemento > maiorElemento) {
				maiorElemento = elemento;
			}
			
			this.push(pilhaAuxiliar.pop());
		}
		
		return maiorElemento;
    }
    
    public void inverte(int indice) {
    	Pilha pilhaAuxiliar1 = new Pilha(indice + 1);
		
		for (int i = 0; i <= indice; i++) {
			pilhaAuxiliar1.push(this.pop());
		}
		
		Pilha pilhaAuxiliar2 = new Pilha(indice + 1);
		
		for (int i = 0; i <= indice; i++) {
			pilhaAuxiliar2.push(pilhaAuxiliar1.pop());
		}
		
		for (int i = 0; i <= indice; i++) {
			this.push(pilhaAuxiliar2.pop());
		}
    }
    
}