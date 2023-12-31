import javax.swing.*;

public class Escudeiro extends Unidades{

    private boolean escudoQuebrado = false;
    private boolean defendendo = false;

    public Escudeiro() {

        super();
        this.setNome("Escudeiro");
        this.setVida(200);
        this.setDano(30);

    }



    @Override
    public boolean opcoesDeAcao(Unidades personagemAtacado){
        int opcao = 0;
        opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                1 - Atacar
                2 - Defender
                3 - Sair
                """));

        if (opcao == 1){
            this.atacar(personagemAtacado);
        }
        else if (opcao == 2){
            this.defender();
        }
        else if (opcao == 3){
            return false;
        }
        return false;
    }

    public void defender(){

        this.defendendo = true;

    }

    public boolean isEscudoQuebrado() {
        return escudoQuebrado;
    }

    public void setEscudoQuebrado(boolean escudoQuebrado) {
        this.escudoQuebrado = escudoQuebrado;
    }

    public boolean isDefendendo() {
        return defendendo;
    }
}
