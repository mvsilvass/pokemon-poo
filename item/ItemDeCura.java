package item;

import pokemon.Pokemon;

public class ItemDeCura extends Item{
    private final int cura;

    public ItemDeCura(String nome, int cura, int quantidade){
        super(nome, "Esta poção pode ser usada para restaurar " + cura + " da vida de seu pokemon", quantidade);
            this.cura = cura;
    }

    @Override   
    public void aplicarEfeito(Pokemon pokemon) {
        System.out.println(this.getNome() + " foi usado em " + pokemon.getNome() + "!");
        System.out.println(pokemon.getNome() + " recuperou " + this.cura + " de sua vida (HP)");
        pokemon.setVida(pokemon.getVida() + this.cura);
    }                        
    
}