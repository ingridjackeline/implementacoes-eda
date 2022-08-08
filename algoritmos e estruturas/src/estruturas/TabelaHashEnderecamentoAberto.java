package estruturas;


public class TabelaHashEnderecamentoAberto {

	private Aluno[] tabela;
    private int size;
    private double fatorDeCarga;
    private static final int CAPACIDADE_DEFAULT = 20;
    private static final double FATOR_DE_CARGA_DEFAULT = 0.75;
    private static final Aluno APAGADO = new Aluno(Integer.MIN_VALUE, "APAGADO");

    public TabelaHashEnderecamentoAberto() {
        this(CAPACIDADE_DEFAULT, FATOR_DE_CARGA_DEFAULT);
    }

    public TabelaHashEnderecamentoAberto(int capacidade, double fatorDeCarga) {
        this.tabela = new Aluno[capacidade];
        this.fatorDeCarga = fatorDeCarga;
        this.size = 0;
    }

    private int hash(int chave) {
        return chave % this.tabela.length;
    }

    private int hashMultiplicacao(int chave) {
        double a = 0.617648934;
        double hash = chave * a;
        hash = (hash % 1) * this.tabela.length;
        return (int) hash;        
    }

    public Aluno get(int chave) {
        int sondagem = 0;
        int hash;
        
        while (sondagem < this.tabela.length) {
            hash = (this.hash(chave) + sondagem) % this.tabela.length;
            if (this.tabela[hash] == null) {
                return null;
            }
            if (this.tabela[hash].getMatricula() == chave) {
                return this.tabela[hash];
            }
            sondagem += 1;
        }

        return null;
    }

    public void put(int chave, Aluno valor) {
        int sondagem = 0;
        int hash;
        
        while (sondagem < this.tabela.length) {
            hash = (this.hash(chave) + sondagem) % this.tabela.length;
            if (this.tabela[hash] == null || this.tabela[hash].getMatricula() == chave || this.tabela[hash].equals(APAGADO)) {
                this.tabela[hash] = valor;
                this.size += 1;
                return;
            }
            sondagem += 1;
        }
    }

    public Aluno remove(int chave) {
        int sondagem = 0;
        int hash;
        
        while (sondagem < this.tabela.length) {
        	hash = (this.hash(chave) + sondagem) % this.tabela.length;
            if (this.tabela[hash] != null && this.tabela[hash].getMatricula() == chave) {
            	Aluno aluno = this.tabela[hash];  
                this.tabela[hash] = APAGADO;
                this.size -= 1;
                return aluno;
            } 
            sondagem += 1;
        }

        return null;
    }

}