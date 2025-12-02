package item;

import pokemon.Pokemon;

public class Reviver extends Item{

    public Reviver(String nome, int quantidade) {
        super(nome, "Restaura um Pokémon desmaiado e recupera 50% de seu HP máximo", quantidade);
    }

    @Override
    public void aplicarEfeito(Pokemon pokemon) {
        if(pokemon.getVida() == 0){
            int metadeDaVida = pokemon.getVidaMaxima() / 2;
            pokemon.setVida(metadeDaVida);

            System.out.println(this.getNome() + " foi usado em " + pokemon.getNome() + "!");
            System.out.println(pokemon.getNome() + " recuperou " + metadeDaVida + " de sua vida (HP)");
        }else{
            System.out.println(pokemon.getNome() + " não pode usar esse item!");
        }
    }
    
}
