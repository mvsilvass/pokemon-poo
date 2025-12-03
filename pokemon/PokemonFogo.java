package pokemon;

import habilidade.Habilidade;
import habilidade.HabilidadeDeFogo;

public class PokemonFogo extends Pokemon {

    public PokemonFogo(String nome, int vida, int vidaMaxima, int ataque, int defensa, String nomeHabilidade, String descricaoHabilidade) {
        super(nome, Tipo.FOGO, vida, vidaMaxima, ataque, defensa, new HabilidadeDeFogo( nomeHabilidade, descricaoHabilidade ));
    }

    @Override
    public void atacar(Habilidade habilidade, Pokemon alvo) {
        System.out.println(getNome() + " atacou causando dano!");
        habilidade.usarHabilidade(this, alvo);
    }

}
