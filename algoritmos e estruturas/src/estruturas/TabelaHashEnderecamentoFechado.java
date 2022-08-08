package estruturas;


import java.util.ArrayList;
import java.util.Iterator;


public class TabelaHashEnderecamentoFechado {

	private ArrayList<ArrayList<Aluno>> tabela;
    private static final int CAPACIDADE_DEFAULT = 20;
    private int capacidade;

    public TabelaHashEnderecamentoFechado() {
        this.tabela = new ArrayList<ArrayList<Aluno>>(CAPACIDADE_DEFAULT);
        this.capacidade = 20;
    }
    
    public TabelaHashEnderecamentoFechado(int capacidade) {
        this.tabela = new ArrayList<ArrayList<Aluno>>(capacidade);
        this.capacidade = capacidade;
    }
    
    private int hash(int chave) {
        return chave % this.capacidade;
    }
    
    private int hashMultiplicacao(int chave) {
        double a = 0.617648934;
        double hash = chave * a;
        hash = (hash % 1) * this.capacidade;
        return (int) hash;        
    }
    
    public void put(int chave, Aluno valor) {
        int hash = hash(chave);
        ArrayList<Aluno> alunos = this.tabela.get(hash);
        
        if (alunos == null) {
            alunos = new ArrayList<Aluno>();
            alunos.add(valor);
            this.tabela.add(hash, alunos);
        } else {
            for (int i = 0; i < alunos.size(); i++) {
                if (alunos.get(i).getMatricula() == chave) {
                    alunos.set(i, valor);
                    this.tabela.set(hash, alunos);
                    return;
                }
            }
            alunos.add(valor);
            this.tabela.set(hash, alunos);
        }    
    }

    public Aluno get(int chave) {
        int hash = hash(chave);
        ArrayList<Aluno> alunos = this.tabela.get(hash);
        
        if (alunos == null) {
        	return null;
        }
               
        for (Aluno aluno : alunos) {
        	if (aluno.getMatricula() == chave) {
        		return aluno;
        	}
        }
        
        return null;
    }  

    public Aluno remove(int chave) {
        int hash = hash(chave);
        ArrayList<Aluno> alunos = this.tabela.get(hash);
        
        Iterator<Aluno> it = alunos.iterator();
        Aluno atual = null;
        
        while (it.hasNext()) {
        	atual = it.next();
            if (atual.getMatricula() == chave) {
            	it.remove();
                return atual;
            }
        }
        
        return atual;
    }  

}


class Aluno {

	private int matricula;
	private String nome;
	
	public Aluno(int matricula, String nome) {
		this.matricula = matricula;
		this.nome = nome;
	}
	
	public int getMatricula() {
		return this.matricula;
	}
	
	public String getNome() {
		return this.nome;
	}
	
}