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
        int vidaAntesCura = pokemon.getVida();
        int vidaRecuperada = pokemon.getVida() + this.cura;

        if(vidaRecuperada >= pokemon.getVidaMaxima()){
            pokemon.setVida(pokemon.getVidaMaxima());
        }else{  
            pokemon.setVida(vidaRecuperada);
        }

        System.out.println("\n"+ this.getNome() + " foi usado em " + pokemon.getNome() + "!");
        System.out.println(pokemon.getNome() + " recuperou " + (pokemon.getVida() - vidaAntesCura) + " de sua vida (HP)");
  
    }                        
    
}