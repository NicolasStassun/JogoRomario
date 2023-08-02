import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Jogadores> players = new ArrayList<>();

    public static Jogadores player1 = new Jogadores();
    public static Jogadores player2 = new Jogadores();

    public static void main(String[] args) {

        players.add(player1);
        players.add(player2);

        boolean equipeUmEscolhida = false;
        boolean equipeDoisEscolhida = false;

        int escolha;
        do {
            escolha = Integer.parseInt(JOptionPane.showInputDialog("""
                    Menu
                    1 - Jogar
                    2 - Definir equipe jogador 1
                    3 - Definir equipe jogador 2
                    4 - Ver equipe jogador 1
                    5 - Ver equipe jogador 2
                    """));
            switch (escolha) {

                case 1:
                    if (equipeUmEscolhida && equipeDoisEscolhida) {
                        jogar();
                    }
                    else {
                        escolha = 0;
                    }
                    break;
                case 2:

                    player1.setEquipe();
                    equipeUmEscolhida = true;
                    break;

                case 3:

                    player2.setEquipe();
                    equipeDoisEscolhida = true;
                    break;

                case 4:

                    player1.getEquipe().desenhaEquipe();

                    break;
                case 5:

                    player2.getEquipe().desenhaEquipe();

                    break;
                case 6:

                    System.exit(0);
            }
        }while (escolha != 1);


    }
    public static void jogar(){
        boolean derrota = false;
        do {

            player1.getEquipe().mostrarStatus();

            int opcaoAtacantePlayer1 = 0;
            int opcaoAtacadoPlayer1 = 0;
            for (int i = 0; i < 3; i++) {

                System.out.println((i+1)+" - "+player1.getEquipe().getPersonagens()[i].getNome());

            }
            opcaoAtacantePlayer1 = Integer.parseInt(JOptionPane.showInputDialog("Qual personagem você deseja escolher: "));

            System.out.println("Escolha qual personagem deseja atacar");

            for (int i = 0; i < 3; i++) {

                System.out.println((i+1)+" - "+player2.getEquipe().getPersonagens()[i].getNome());

            }

            opcaoAtacadoPlayer1 = Integer.parseInt(JOptionPane.showInputDialog("Qual personagem você deseja atacar: "));

            for (int i = 0; i < 3; i++) {

                if(i == (opcaoAtacantePlayer1-1) && !player1.getEquipe().getPersonagens()[opcaoAtacantePlayer1-1].getNome().equals("Samurai")){
                    player1.getEquipe().getPersonagens()[i].opcoesDeAcao(player2.getEquipe().getPersonagens()[opcaoAtacadoPlayer1-1]);
                    player2.getEquipe().vidaDaEquipe();
                }
                else if(i == (opcaoAtacantePlayer1-1) && player1.getEquipe().getPersonagens()[opcaoAtacantePlayer1-1].getNome().equals("Samurai")){
                    Samurai samurai = (Samurai) player1.getEquipe().getPersonagens()[i];
                    samurai.opcoesDeAcaoSamurai(player1,player2);
                    player2.getEquipe().vidaDaEquipe();
                }

            }
            derrota = analisaDerrota();

            //Player 2

            player2.getEquipe().mostrarStatus();

            int opcaoAtacantePlayer2 = 0;
            int opcaoAtacadoPlayer2 = 0;
            for (int i = 0; i < 3; i++) {

                System.out.println((i+1)+" - "+player2.getEquipe().getPersonagens()[i].getNome());

            }
            opcaoAtacantePlayer2 = Integer.parseInt(JOptionPane.showInputDialog("Qual personagem você deseja escolher: "));

            System.out.println("Escolha qual personagem deseja atacar");

            for (int i = 0; i < 3; i++) {

                System.out.println((i+1)+" - "+player1.getEquipe().getPersonagens()[i].getNome());

            }

            opcaoAtacadoPlayer2 = Integer.parseInt(JOptionPane.showInputDialog("Qual personagem você deseja atacar: "));

            for (int i = 0; i < 3; i++) {

                if(i == (opcaoAtacantePlayer2-1) && !player2.getEquipe().getPersonagens()[opcaoAtacantePlayer2-1].getNome().equals("Samurai")){
                    player2.getEquipe().getPersonagens()[i].opcoesDeAcao(player1.getEquipe().getPersonagens()[opcaoAtacadoPlayer2-1]);
                    player1.getEquipe().vidaDaEquipe();
                }
                else if(i == (opcaoAtacantePlayer2-1) && player2.getEquipe().getPersonagens()[opcaoAtacantePlayer2-1].getNome().equals("Samurai")){
                    Samurai samurai = (Samurai) player2.getEquipe().getPersonagens()[i];
                    samurai.opcoesDeAcaoSamurai(player2,player1);
                    player1.getEquipe().vidaDaEquipe();

                }

            }
            derrota = analisaDerrota();

        }while(!derrota);



    }
    public static boolean analisaDerrota(){
        if(player1.getEquipe().getVidaEquipe() == 0 || player2.getEquipe().getVidaEquipe() == 0){
            return true;
        }
        else {
            return false;
        }
    }
}