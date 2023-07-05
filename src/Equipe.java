import javax.swing.*;
import java.util.Scanner;

public class Equipe {

    Scanner sc = new Scanner(System.in);

    private Unidades[][] equipe = new Unidades[3][3];

    //fazer uma funcao no futura para pegar as posicoes, pq vc ficou com preguica de fazer na hora.
    public void adicionarUnidades(){

        for (int i = 0; i < 3; i++) {

            int qualPersonagem = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    Escolha um personagem:
                    1 - Samurai
                    2 - Escudeiro
                    3 - Arqueiro
                    """));


            switch (qualPersonagem) {

                case 1:

                    Samurai samurai = new Samurai();

                    int posicaoXsamurai = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a posicao X"));

                    int posicaoYsamurai = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a posicao Y"));

                    if (equipe[posicaoXsamurai][posicaoYsamurai] == null){

                        equipe[posicaoXsamurai][posicaoYsamurai] = samurai;


                    }
                    else {
                        i -= 1;
                    }

                    break;

                case 2:

                    Escudeiro escudeiro = new Escudeiro();

                    int posicaoXescudeiro = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a posicao X"));

                    int posicaoYescudeiro = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a posicao Y"));

                    if (equipe[posicaoXescudeiro][posicaoYescudeiro] == null){

                        equipe[posicaoXescudeiro][posicaoYescudeiro] = escudeiro;


                    }
                    else {
                        i -= 1;
                    }

                    break;

                case 3:

                    Arqueiro arqueiro = new Arqueiro();

                    int posicaoXarqueiro = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a posicao X"));

                    int posicaoYarqueiro = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a posicao Y"));

                    if (equipe[posicaoXarqueiro][posicaoYarqueiro] == null){

                        equipe[posicaoXarqueiro][posicaoYarqueiro] = arqueiro;


                    }
                    else {
                        i -= 1;
                    }

                    break;

            }
        }

    }

}
