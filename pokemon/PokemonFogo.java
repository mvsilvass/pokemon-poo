package pokemon;

import habilidade.Habilidade;
import habilidade.HabilidadeDeFogo;

public class PokemonFogo extends Pokemon {

    private HabilidadeDeFogo habilidade;

    public PokemonFogo(String nome, int vida, int vidaMaxima, int ataque, int defensa, int velocidade, String nomeHabilidade, String descricaoHabilidade) {
        super(nome, Tipo.FOGO, vida, vidaMaxima, ataque, defensa, velocidade);

        this.habilidade = new HabilidadeDeFogo( nomeHabilidade, descricaoHabilidade, this);
    }

    public HabilidadeDeFogo getHabilidade() {
        return habilidade;
    }

    @Override
    public void atacar(Habilidade habilidade, Pokemon alvo) {
        System.out.println(getNome() + " atacou causando dano!");
        habilidade.usarHabilidade(alvo);
    }

}
