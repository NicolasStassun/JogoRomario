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

    public int vidaDaEquipe(){
        int vidaTotal = 0;

        for (Unidades personagem:
             personagens) {
            vidaTotal += personagem.getVida();
        }

        return vidaTotal;
    }

    public void mostrarStatus(){

        for (Unidades personagem:
             personagens) {

            System.out.println(indexOf(personagens, personagem));
            System.out.println(personagem.getNome());
            System.out.println(personagem.getVida());
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

            this.desenhaEquipe();


            switch (qualPersonagem) {

                case 1:

                    Samurai samurai = new Samurai();

                    int posicaoXsamurai = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a posicao X"));

                    int posicaoYsamurai = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a posicao Y"));

                    if (equipe[posicaoXsamurai][posicaoYsamurai] == null){

                        equipe[posicaoXsamurai][posicaoYsamurai] = samurai;
                        personagens[i] = samurai;

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
                        personagens[i] = escudeiro;

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
                        personagens[i] = arqueiro;

                    }
                    else {
                        i -= 1;
                    }

                    break;

            }
        }
        this.vidaEquipe = vidaDaEquipe();

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
