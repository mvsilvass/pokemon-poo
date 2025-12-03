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
        int dano = this.getPokemon().getAtaque() - alvo.getDefensa();

        if(alvo.getTipo() == Tipo.AGUA){
            dano *= 1.5;
        }
        
        int vida = alvo.getVida() - dano;

        if(vida >= alvo.getVida()){
            alvo.setStatus(Status.DESMAIADO);
            vida = 0;
        }

        alvo.setVida(vida);
    }   
 
    @Override
    public void aplicarStatus(Pokemon alvo) {
        alvo.setStatus(Status.ENVENENADO);
    }
}
