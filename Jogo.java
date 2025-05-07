import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    private int PONTOS_PARA_VENCER = 12;
    private List<Jogador> jogadores;
    private Baralho baralho;
    private int rodadaAtual;
    public Jogo(){
        jogadores = new ArrayList<>();
        this.baralho = new Baralho();
        rodadaAtual=1;
    }
    public void adicionarJogador(String nome) {
        jogadores.add(new Jogador(nome));
    }
    public void iniciaJogo(){
        Scanner scanner = new Scanner(System.in);
        while (!alguemVenceu()) {
            System.out.println("\n=== Rodada " + rodadaAtual + " ===");
            baralho = new Baralho();
            baralho.embaralhar();            
            for (Jogador jogador : jogadores) {
                jogador.limparMao();
                for (int i = 0; i < 3; i++) {
                    jogador.getMao().add(baralho.darCarta());
                }
            }
            jogarRodada(scanner);
            rodadaAtual++;
        }
        scanner.close();
    }

    private void jogarRodada(Scanner scanner) {
        List<Carta> cartasJogadas = new ArrayList<>();
        int[] indicesJogadores = {0, 1}; 
    
        for (int turno = 0; turno < 3; turno++) {
            System.out.println("\n=== Turno " + (turno + 1) + " ===");
            cartasJogadas.clear();
    
            
            for (int i : indicesJogadores) {
                Jogador jogador = jogadores.get(i);
                System.out.println("\n" + jogador.getNome() + ", é sua vez!");
                mostrarMao(jogador);
    
                
                int escolha;
                do {
                    System.out.print("Escolha uma carta para jogar (1-" + jogador.getMao().size() + "): ");
                    escolha = scanner.nextInt() - 1;
    
                    if (escolha < 0 || escolha >= jogador.getMao().size()) {
                        System.out.println("Escolha inválida. Tente novamente.");
                    }
                } while (escolha < 0 || escolha >= jogador.getMao().size());
    
                
                Carta cartaJogada = jogador.jogarCarta(escolha);
                if (cartaJogada != null) {
                    cartasJogadas.add(cartaJogada);
                    System.out.println(jogador.getNome() + " jogou: " + cartaJogada);
                }
            }
    
            
            determinarVencedorTurno(cartasJogadas);
        }
    
        determinarVencedorRodada();
        
    }

    private void determinarVencedorTurno(List<Carta> cartasJogadas) {
        Carta cartaJogador1 = cartasJogadas.get(0);
        Carta cartaJogador2 = cartasJogadas.get(1);
        
        if (cartaJogador1.getForca() > cartaJogador2.getForca())  {
            System.out.println(jogadores.get(0).getNome() + " venceu o turno!");
            jogadores.get(0).adicionarPontosRodada();
        } else if (cartaJogador1.getForca() < cartaJogador2.getForca()) {
            System.out.println(jogadores.get(1).getNome() + " venceu o turno!");
            jogadores.get(1).adicionarPontosRodada();
        } else {
            System.out.println("Empate no turno! Ninguém pontua.");
        }
    }

    private void determinarVencedorRodada() {
        int pontosJogador1 = jogadores.get(0).getPontosRodada();
        int pontosJogador2 = jogadores.get(1).getPontosRodada();

        System.out.println("\n=== Resultado da Rodada ===");
        System.out.println(jogadores.get(0).getNome() + ": " + pontosJogador1 + " pontos");
        System.out.println(jogadores.get(1).getNome() + ": " + pontosJogador2 + " pontos");
        
        if (pontosJogador1 > pontosJogador2) {
            System.out.println(jogadores.get(0).getNome() + " venceu a rodada!");
            jogadores.get(0).adicionarPonto();
        } else if (pontosJogador1 < pontosJogador2) {
            System.out.println(jogadores.get(1).getNome() + " venceu a rodada!");
            jogadores.get(1).adicionarPonto();
        } else {
            System.out.println("Rodada empatada!");
        }
        jogadores.get(0).resetPontosRodada();
        jogadores.get(1).resetPontosRodada();
        System.out.println("\n=== Placar Atual ===");
        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getNome() + ": " + jogador.getPontos() + " pontos");
        }
    }



    private boolean alguemVenceu() {
        for (Jogador jogador : jogadores) {
            if (jogador.getPontos() >= PONTOS_PARA_VENCER) {
                System.out.println("\n" + jogador.getNome() + " venceu o jogo!");
                return true;
            }
        }
        return false;
    }

    private void mostrarMao(Jogador jogador) {
        System.out.println("Sua mão:");
        List<Carta> mao = jogador.getMao();
        for (int i = 0; i < mao.size(); i++) {
            System.out.println((i + 1) + ") " + mao.get(i));
        }
    }
    
    

}

