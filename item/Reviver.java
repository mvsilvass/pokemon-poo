package item;

import pokemon.Pokemon;

public class Reviver extends Item{

    public Reviver(String nome, String descricao, int quantidade) {
        super(nome, descricao, quantidade);
    }

    @Override
    public void aplicarEfeito(Pokemon pokemon) {
        if(pokemon.getVida() == 0){
            int cura = pokemon.getVidaMaxima() / 2;
            pokemon.setVida(cura);

            System.out.println(this.getNome() + " foi usado em " + pokemon.getNome() + "!");
            System.out.println(pokemon.getNome() + " recuperou " + cura + " de sua vida (HP)");
        }else{
            System.out.println(pokemon.getNome() + " não pode usar esse item!");
        }
    }
    
}
