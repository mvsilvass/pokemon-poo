package habilidade;

import pokemon.Pokemon;
import pokemon.Tipo;

public class HabilidadeDeAgua extends Habilidade{
    public HabilidadeDeAgua(String nome, String descricao, Pokemon pokemon) {
        super(nome, descricao, pokemon);
    }
    
    @Override
    public void usarHabilidade(Pokemon alvo) {
        int dano = getPokemon().getAtaque() - alvo.getDefensa();

        if(alvo.getTipo() == Tipo.FOGO){
            dano *= 2;
        }

        int vida = alvo.getVida() - dano;

        if(vida <= 0){
            vida = 0;
        }

        alvo.setVida(vida);
    }

}
