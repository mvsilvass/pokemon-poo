package habilidade;

import pokemon.Pokemon;
import pokemon.Status;
import pokemon.Tipo;

public class HabilidadeDePlanta extends Habilidade implements EfeitoDeStatus{
    public HabilidadeDePlanta(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void aplicarStatus(Pokemon alvo) {
        if(alvo.getStatus() != Status.DESMAIADO){
            alvo.setStatus(Status.ENVENENADO);
        }
    }

    @Override
    public void usarHabilidade(Pokemon atacante, Pokemon alvo) {
        int dano = atacante.getAtaque() - alvo.getDefensa();

        if(alvo.getTipo() == Tipo.AGUA){
            dano *= 1.5;
        }
        
        int vidaRestante = alvo.getVida() - (int) Math.round(dano);

        if(vidaRestante <= 0){
            alvo.setStatus(Status.DESMAIADO);
            vidaRestante = 0;
        }

        alvo.setVida(vidaRestante);
        aplicarStatus(alvo);
    }   

}
