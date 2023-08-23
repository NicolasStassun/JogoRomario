import javax.swing.*;

public class Equipe {

    private Unidades[][] equipe = new Unidades[3][3];
    private Unidades[] personagens = new Unidades[3];
    private int vidaEquipe = 0;

    public int getVidaEquipe() {
        return vidaEquipe;
    }

    public void setVidaEquipe(int vidaEquipe) {
        this.vidaEquipe = vidaEquipe;
    }

    public void vidaDaEquipe(){
        int vidaTotal = 0;

        for (Unidades personagem:
             personagens) {
            vidaTotal += personagem.getVida();
        }
        System.out.println(vidaTotal);
        setVidaEquipe(vidaTotal);
    }

    public boolean equipeEstaVazia(){
        if (this.equipe[0][0] == null && this.equipe[0][1] == null && this.equipe[0][2] == null && this.equipe[1][0] == null && this.equipe[1][1] == null && this.equipe[1][2] == null && this.equipe[2][0] == null && this.equipe[2][1] == null && this.equipe[2][2] == null){
           return true;
        }
        else{
            return false;
        }
    }

    public void resetaEquipe(){
        for (int i = 0; i < this.equipe.length ; i++) {
            for (int j = 0; j < this.equipe.length; j++) {
                this.equipe[i][j] = null;
            }
        }
    }

    public void mostrarStatus(){
        vidaDaEquipe();
        for (Unidades personagem:
             personagens) {

            System.out.println(indexOf(personagens, personagem)+1+" - [");
            System.out.println("Nome: "+personagem.getNome());
            System.out.println("Vida: "+personagem.getVida());
            System.out.println("]");
            if (personagem instanceof Arqueiro){
                if (((Arqueiro) personagem).isArcoCarregado()){
                    System.out.println("O arco está carregado");
                }
                else{
                    System.out.println("O arco está descarregado");
                }
            }
            if(personagem instanceof  Escudeiro){
                if (((Escudeiro) personagem).isEscudoQuebrado()){
                    System.out.println("O escudeiro está com o escudo quebrado");
                }
                else{
                    System.out.println("O escudeiro possui um escudo");
                }
            }

        }

    }

    public void desenhaEquipe(){

        System.out.println("\n-----------------------------");

        for (int i = 0; i < this.equipe.length ; i++) {

                System.out.println("");

            for (int j = 0; j < this.equipe.length; j++) {
                if (equipe[i][j] == null){
                    System.out.print("[ ]");
                }
                else if (equipe[i][j].getNome() == "Arqueiro"){
                    System.out.print("[🏹]");
                }
                else if (equipe[i][j].getNome() == "Escudeiro"){
                    System.out.print("[🛡]");
                }
                else if (equipe[i][j].getNome() == "Samurai"){
                    System.out.print("[⚔]");
                }
            }
            System.out.println("");
        }

    }

    //fazer uma funcao no futura para pegar as posicoes, pq vc ficou com preguica de fazer na hora.
    public void adicionarUnidades(){

        for (int i = 0; i < 3; i++) {
            int qualPersonagem = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    Escolha um personagem:
                    1 - Samurai
                    2 - Escudeiro
                    3 - Arqueiro
                    """));

            if (qualPersonagem >= 1 && qualPersonagem <= 3){
                this.desenhaEquipe();

                switch (qualPersonagem) {

                    case 1:

                        Samurai samurai = new Samurai();

                        int posicaoXsamurai = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a posicao X de 1 - 3"));

                        int posicaoYsamurai = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a posicao Y de 1 - 3"));

                        if((posicaoYsamurai <=3 && posicaoYsamurai >=1) && (posicaoXsamurai <=3 && posicaoXsamurai >=1)){
                            if (equipe[posicaoYsamurai-1][posicaoXsamurai-1] == null){

                                equipe[posicaoYsamurai-1][posicaoXsamurai-1] = samurai;
                                personagens[i] = samurai;

                                this.desenhaEquipe();

                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Posição já ocupada");
                                i -= 1;
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Posição inválida");
                            i -= 1;
                        }


                        break;

                    case 2:

                        Escudeiro escudeiro = new Escudeiro();

                        int posicaoXescudeiro = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a posicao X de 1 - 3"));

                        int posicaoYescudeiro = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a posicao Y de 1 - 3"));

                        if((posicaoYescudeiro <=3 && posicaoYescudeiro >=1) && (posicaoXescudeiro <=3 && posicaoXescudeiro >=1)){
                            if (equipe[posicaoYescudeiro-1][posicaoXescudeiro-1] == null){

                                equipe[posicaoYescudeiro-1][posicaoXescudeiro-1] = escudeiro;
                                personagens[i] = escudeiro;

                                this.desenhaEquipe();

                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Posição já ocupada");
                                i -= 1;
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Posição inválida");
                            i -= 1;
                        }

                        break;

                    case 3:

                        Arqueiro arqueiro = new Arqueiro();

                        int posicaoXarqueiro = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a posicao X de 1 - 3"));

                        int posicaoYarqueiro = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a posicao Y de 1 - 3"));

                        if ((posicaoYarqueiro <=3 && posicaoYarqueiro >=1) && (posicaoXarqueiro <=3 && posicaoXarqueiro >=1)){
                            if (equipe[posicaoYarqueiro-1][posicaoXarqueiro-1] == null){

                                equipe[posicaoYarqueiro-1][posicaoXarqueiro-1] = arqueiro;
                                personagens[i] = arqueiro;

                                this.desenhaEquipe();

                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Posição já ocupada");
                                i -= 1;
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Posição inválida");
                            i -= 1;
                        }



                        break;

                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Opção inválida, escolha um persomnage válido");
                i -= 1;
            }


        }
        vidaDaEquipe();

    }

    public static int indexOf(Unidades arr[], Unidades personagem)
    {

        // if array is Null
        if (arr == null) {
            return -1;
        }

        // find length of array
        int len = arr.length;

        int i = 0;

        // traverse in the array
        while (i < len) {

            // if the i-th element is t
            // then return the index
            if (arr[i] == personagem) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }

    public Unidades[] getPersonagens() {
        return personagens;
    }

    public void setPersonagens(Unidades[] personagens) {
        this.personagens = personagens;
    }

    public Unidades[][] getEquipe() {
        return equipe;
    }

    public void setEquipe(Unidades[][] equipe) {
        this.equipe = equipe;
    }
}
