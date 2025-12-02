package habilidade;

import pokemon.Pokemon;
import pokemon.Status;
import pokemon.Tipo;

public class HabilidadeDeFogo extends Habilidade implements EfeitoDeStatus{
    public HabilidadeDeFogo(String nome, String descricao, Pokemon pokemon) {
        super(nome, descricao, pokemon);
    }

    @Override
    public void usarHabilidade(Pokemon alvo) {
        int dano = getPokemon().getAtaque();

        if(alvo.getTipo() == Tipo.PLANTA){
            dano *= 2;
        }

        alvo.setVida(alvo.getVida() - dano);
    }

    @Override
    public void aplicarStatus(Pokemon alvo) {
        alvo.setStatus(Status.QUEIMANDO);
    }   
}
