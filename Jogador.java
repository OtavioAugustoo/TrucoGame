import java.util.ArrayList;

public class Jogador {
    private ArrayList<Carta> mao; 
    private String nome;
    private int pontos;
    private int pontosRodada;
    public int getPontosRodada() {
        return pontosRodada;
    }
    public void resetPontosRodada() {
        this.pontosRodada = 0;
    }
    public void adicionarPontosRodada() {
        this.pontosRodada++;
    }
    public String getNome() {
        return nome;
    }
    public int getPontos() {
        return pontos;
    }
    
    public Jogador(String nome) {
        this.pontos =0;
        this.nome =nome;
        this.mao = new ArrayList<>();

    }
    public void receberCarta(Carta carta) {
        if (mao.size() < 3) {
            mao.add(carta);
        }
    }
    
    public ArrayList<Carta> getMao() {
        return mao;
    }

    
    public void limparMao() {
        mao.clear();
    }

    public Carta jogarCarta(int indice) {
        if (indice >= 0 && indice < mao.size()) {
            return mao.remove(indice);
        }
        return null;
    }

    public void adicionarPonto() {
        pontos++;
    }

    
    @Override
    public String toString() {
        return "Mão do jogador: " + mao;
    }
}
