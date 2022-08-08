import java.util.Scanner;


class Parenteses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String parenteses = sc.next();
		
		Stack pilha = new Stack(parenteses.length());
		
		for (int i = 0; i < parenteses.length(); i++) {
			String p = Character.toString(parenteses.charAt(i));
			
			if (p.equals("(")) {
				pilha.push(p);
			} else if (p.equals(")")) {
				if (!pilha.isEmpty()) {
					pilha.pop();
				} else {
					System.out.println("N");
					return;
				}
			}
		}
		
		if (pilha.isEmpty()) {
			System.out.println("S");
		} else {
			System.out.println("N");
		}
	}

}


class Stack {

	private String[] pilha;
    private int capacidade;
    private int topo;

    public Stack(int capacidade) {
    	this.capacidade = capacidade;
        this.topo = -1;
        this.pilha = new String[capacidade];
    }
    
    public String[] getPilha() {
    	return this.pilha;
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo == (capacidade - 1);
    }

    public void push(String n) {
        if (this.isFull()) {
            throw new RuntimeException("FullStackException");
        }
        
        this.topo += 1;
        this.pilha[topo] = n;
    }
    
    public String pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("EmptyStackException");
        }
        
        String valor_topo = this.pilha[topo];
        topo -= 1;
        
        return valor_topo; 
    }

    public String peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("EmptyStackException");
        }
        
        return this.pilha[topo];
    }

    public int size() {
        return this.topo + 1;
    }
    
}