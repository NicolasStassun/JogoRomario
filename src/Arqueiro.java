import javax.swing.*;

public class Arqueiro extends Unidades{

    private boolean arcoCarregado = true;

    public Arqueiro() {

        super();
        this.setNome("Arqueiro");
        this.setVida(180);
        this.setDano(50);
    }



    @Override
    public boolean opcoesDeAcao(Unidades personagemAtacado){
        int opcao = 0;
        Integer.parseInt(JOptionPane.showInputDialog("""
                1 - Atacar
                2 - Carregar arco
                3 - Sair
                """));
        if(opcao == 1){
            if (arcoCarregado){
                this.atacar(personagemAtacado);
                return true;
            }
            else {
                JOptionPane.showMessageDialog(null, "Seu arco não está carregado");
            }
        }

        else if(opcao == 2){
            this.arcoCarregado = true;
            JOptionPane.showMessageDialog(null,"Você carregou seu arco");
        }

        else if (opcao == 3){
            return false;
        }


        return false;
    }

    public boolean isArcoCarregado() {
        return arcoCarregado;
    }

    public void setArcoCarregado(boolean arcoCarregado) {
        this.arcoCarregado = arcoCarregado;
    }
}
