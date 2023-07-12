public abstract class Unidades {

    private String nome = " ";
    private int vida;
    private int dano;

    public Unidades() {
    }

    public void atacar(Unidades personagem){

        if (((Escudeiro) personagem).isDefendendo()){
            ((Escudeiro) personagem).setEscudoQuebrado(true);
        }
        else{
            personagem.setVida(personagem.getVida()-this.getDano());
        }
    }
    public abstract boolean opcoesDeAcaoSamurai(Jogadores atacante,Jogadores adversario);
    public abstract boolean opcoesDeAcao(Unidades personagemAtacado);

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
