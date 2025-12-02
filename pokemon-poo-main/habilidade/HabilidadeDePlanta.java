package habilidade;

import pokemon.Pokemon;
import pokemon.Status;
import pokemon.Tipo;

public class HabilidadeDePlanta extends Habilidade implements EfeitoDeStatus{
    public HabilidadeDePlanta(String nome, String descricao, Pokemon pokemon) {
        super(nome, descricao, pokemon);
    }

    @Override
    public void usarHabilidade(Pokemon alvo) {
        int dano = getPokemon().getAtaque() - alvo.getDefensa();

        if(alvo.getTipo() == Tipo.AGUA){
            dano *= 2;
        }
        
        int vida = alvo.getVida() - dano;

        if(vida <= 0){
            vida = 0;
        }

        alvo.setVida(vida);
    }
    
    @Override
    public void aplicarStatus(Pokemon alvo) {
        alvo.setStatus(Status.ENVENENADO);
    }
}
