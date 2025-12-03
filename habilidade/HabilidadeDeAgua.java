package habilidade;

import pokemon.Pokemon;
import pokemon.Status;
import pokemon.Tipo;

public class HabilidadeDeAgua extends Habilidade{
    public HabilidadeDeAgua(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void usarHabilidade(Pokemon atacante, Pokemon alvo) {
        int dano = atacante.getAtaque() - alvo.getDefensa();

        if(alvo.getTipo() == Tipo.FOGO){
            dano *= 1.6;
        }

        int vidaRestante = alvo.getVida() - (int) Math.round(dano);

        if(vidaRestante <= 0){
            alvo.setStatus(Status.DESMAIADO);
            vidaRestante = 0;
        }

        alvo.setVida(vidaRestante);
    }   

}
