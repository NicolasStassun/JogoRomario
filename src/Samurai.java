import javax.swing.*;

public class Samurai extends Unidades{

    public Samurai() {

        super();
        this.setNome("Samurai");
        this.setVida(150);
        this.setDano(80);
    }

    @Override
    public boolean opcoesDeAcaoSamurai(Jogadores atacante,Jogadores adversario){
        int opcao = 0;
        Integer.parseInt(JOptionPane.showInputDialog("""
                1 - Atacar
                2 - Sair
                """));
        if (opcao == 1){
            this.atacar(atacante,adversario);
        }

        if (opcao == 2){
            return false;
        }


        return false;
    }

    @Override
    public boolean opcoesDeAcao(Unidades personagemAtacado) {
        return false;
    }

    public void atacar(Jogadores jogadorNormal, Jogadores jogadorAdversario){

        int linhaDeAtaque = 0;

        for (int i = 0; i < jogadorNormal.getEquipe().getEquipe().length; i++) {
            for (int j = 0; j < jogadorNormal.getEquipe().getEquipe().length; j++) {
                if(jogadorNormal.getEquipe().getEquipe()[i][j].getNome() == "Samurai"){

                    linhaDeAtaque = i;

                }
            }
        }
        for (int i = 0; i < jogadorAdversario.getEquipe().getEquipe().length; i++) {
            for (int j = 0; j < jogadorAdversario.getEquipe().getEquipe().length; j++) {
                if (i == linhaDeAtaque){
                    jogadorAdversario.getEquipe().getEquipe()[i][j].setVida(-this.getDano());
                }
            }
        }

    }





}
