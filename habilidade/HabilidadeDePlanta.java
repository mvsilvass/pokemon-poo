package habilidade;

import pokemon.Pokemon;
import pokemon.Status;
import pokemon.Tipo;

public class HabilidadeDePlanta extends Habilidade implements EfeitoDeStatus{
    public HabilidadeDePlanta(String nome, String descricao, Pokemon pokemon) {
        super(nome, descricao, pokemon);
    }

    @Override
    public void aplicarStatus(Pokemon alvo) {
        if(alvo.getStatus() != Status.NORMAL){
            alvo.setStatus(Status.ENVENENADO);
        }
    }

    @Override
    public void usarHabilidade(Pokemon alvo) {
        int dano = this.getPokemon().getAtaque() - alvo.getDefensa();

        if(alvo.getTipo() == Tipo.AGUA){
            dano *= 1.5;
        }
        
        int vidaRestante = alvo.getVida() - dano;

        if(vidaRestante <= alvo.getVida()){
            alvo.setStatus(Status.DESMAIADO);
            vidaRestante = 0;
        }

        alvo.setVida(vidaRestante);
        aplicarStatus(alvo);
    }   

}
