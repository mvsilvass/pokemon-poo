package pokemon;

import habilidade.Habilidade;
import habilidade.HabilidadeDeAgua;

public class PokemonAgua extends Pokemon {

    private HabilidadeDeAgua habilidade;

    public PokemonAgua(String nome, int vida, int vidaMaxima, int ataque, int defensa, String nomeHabilidade, String descricaoHabilidade) {
        super(nome, Tipo.AGUA, vida, vidaMaxima, ataque, defensa);

        this.habilidade = new HabilidadeDeAgua( nomeHabilidade, descricaoHabilidade, this);
    }

    public HabilidadeDeAgua getHabilidade() {
        return habilidade;
    }

    @Override
    public void atacar(Habilidade habilidade, Pokemon alvo) {
        System.out.println(getNome() + " atacou causando dano!");
        habilidade.usarHabilidade(alvo);
    }
        
}
