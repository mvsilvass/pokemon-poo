package pokemon;

import habilidade.Habilidade;
import habilidade.HabilidadeDePlanta;

public class PokemonPlanta extends Pokemon {

    public PokemonPlanta(String nome, int vida, int vidaMaxima, int ataque, int defensa, String nomeHabilidade, String descricaoHabilidade) {
        super(nome, Tipo.PLANTA, vida, vidaMaxima, ataque, defensa, new HabilidadeDePlanta(nomeHabilidade, descricaoHabilidade));
    }

    @Override
    public void atacar(Habilidade habilidade, Pokemon alvo) {
        System.out.println(getNome() + " atacou causando dano!");
        habilidade.usarHabilidade(this, alvo);
    }

}