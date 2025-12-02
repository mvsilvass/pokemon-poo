package habilidade;

import pokemon.Pokemon;
import pokemon.Tipo;

public class HabilidadeDeAgua extends Habilidade{
    public HabilidadeDeAgua(String nome, String descricao, Pokemon pokemon) {
        super(nome, descricao, pokemon);
    }

    @Override
    public void usarHabilidade(Pokemon alvo) {
        int dano = getPokemon().getAtaque();

        if(alvo.getTipo() == Tipo.FOGO){
            dano *= 2;
        }

        alvo.setVida(alvo.getVida() - dano);
    }   

}
