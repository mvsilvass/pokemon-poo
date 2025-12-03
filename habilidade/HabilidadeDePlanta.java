package habilidade;

import pokemon.Pokemon;
import pokemon.Status;
import pokemon.Tipo;

public class HabilidadeDePlanta extends Habilidade{
    public HabilidadeDePlanta(String nome, String descricao, Pokemon pokemon) {
        super(nome, descricao, pokemon);
    }

    @Override
    public void usarHabilidade(Pokemon alvo) {
        int dano = getPokemon().getAtaque();

        if(alvo.getTipo() == Tipo.AGUA){
            dano *= 2;
        }
        
        int vida = alvo.getVida() - dano;

        if(vida >= alvo.getVida()){
            alvo.setStatus(Status.DESMAIADO);
            vida = 0;
        }

        alvo.setVida(vida);
    }   
}
