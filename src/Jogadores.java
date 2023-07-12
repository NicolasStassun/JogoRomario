public class Jogadores {
    private Equipe equipe = new Equipe();

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe() {
        this.equipe.adicionarUnidades();
    }
    public void getPosicoesDosPersonagens(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (equipe.getEquipe()[i][j]!= null){
                    System.out.println();
                }
            }
        }
    }
}
