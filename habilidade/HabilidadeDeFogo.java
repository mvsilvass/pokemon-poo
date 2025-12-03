package habilidade;

import pokemon.Pokemon;
import pokemon.Status;
import pokemon.Tipo;

public class HabilidadeDeFogo extends Habilidade implements EfeitoDeStatus{
    public HabilidadeDeFogo(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void aplicarStatus(Pokemon alvo) {

        if(alvo.getStatus() != Status.DESMAIADO){
            alvo.setStatus(Status.QUEIMANDO);
        }
        
    }  

    @Override
    public void usarHabilidade(Pokemon atacante, Pokemon alvo) {
        int dano = atacante.getAtaque() - alvo.getDefensa();

        if(alvo.getTipo() == Tipo.PLANTA){
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
