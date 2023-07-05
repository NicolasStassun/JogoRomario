public class Jogadores {
    private Equipe equipe = new Equipe();

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe() {
        this.equipe.adicionarUnidades();
    }
}
