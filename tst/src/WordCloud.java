import java.util.Scanner;


class WordCloud {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] texto = sc.nextLine().split(" ");
		
		TabelaHashEnderecamentoAberto tabelaHash = new TabelaHashEnderecamentoAberto(texto.length);
		
		for (String palavra : texto) {
			tabelaHash.put(palavra, new Palavra(palavra));
		}
		
		while (true) {
			String termo = sc.next();
			
			if (termo.equals("fim")) {
				break;
			} else {
				int frequencia = tabelaHash.get(termo);
				System.out.println(frequencia);
			}
		}
	}

}


class TabelaHashEnderecamentoAberto {

	private Palavra[] tabela;
    private int size;
    private int capacidade;
    private static final int CAPACIDADE_DEFAULT = 20;

    public TabelaHashEnderecamentoAberto() {
        this(CAPACIDADE_DEFAULT);
    }

    public TabelaHashEnderecamentoAberto(int capacidade) {
        this.tabela = new Palavra[capacidade];
        this.capacidade = capacidade;
        this.size = 0;
    }

    private int hash(String chave) {
        return Math.abs(chave.hashCode()) % this.capacidade;
    }

    public Integer get(String chave) {
        int sondagem = 0;
        int hash;
        
        while (sondagem < this.capacidade) {
            hash = (this.hash(chave) + sondagem) % this.capacidade;
            if (this.tabela[hash] == null) {
                return null;
            }
            if (this.tabela[hash].getPalavra().equals(chave)) {
                return this.tabela[hash].getFrequencia();
            }
            sondagem += 1;
        }

        return null;
    }

    public void put(String chave, Palavra palavra) {
        int sondagem = 0;
        int hash;
        
        while (sondagem < this.capacidade) {
            hash = (this.hash(chave) + sondagem) % this.capacidade;
            if (this.tabela[hash] == null) {
                this.tabela[hash] = palavra;
                this.size += 1;
                return;
            } else if (this.tabela[hash].getPalavra().equals(chave)) {
            	this.tabela[hash].adicionaFrequencia();
            	return;
            }
            sondagem += 1;
        }
    }

    public Integer remove(String chave) {
        int sondagem = 0;
        int hash;
        
        while (sondagem < this.capacidade) {
        	hash = (this.hash(chave) + sondagem) % this.capacidade;
            if (this.tabela[hash] != null && this.tabela[hash].getPalavra().equals(chave)) {
            	int frequencia = this.tabela[hash].getFrequencia();  
                this.tabela[hash] = null;
                this.size -= 1;
                return frequencia;
            } 
            sondagem += 1;
        }

        return null;
    }

}


class Palavra {
	
	private String palavra;
	private int frequencia;
	
	public Palavra(String palavra) {
		this.palavra = palavra;
		this.frequencia = 1;
	}
	
	public String getPalavra() {
		return this.palavra;
	}
	
	public int getFrequencia() {
		return this.frequencia;
	}
	
	public void adicionaFrequencia() {
		this.frequencia += 1;
	}
	
}