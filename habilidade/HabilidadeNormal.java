package habilidade;

import pokemon.Pokemon;

public class HabilidadeNormal extends Habilidade{

    public HabilidadeNormal(String nome, String descricao, Pokemon pokemon) {
        super(nome, descricao, pokemon);
    }

    @Override
    public void usarHabilidade(Pokemon alvo) {
        int dano = getPokemon().getAtaque();
        alvo.setVida(alvo.getVida() - dano);
    }

    
}
