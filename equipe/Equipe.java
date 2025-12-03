package equipe;

import java.util.ArrayList;
import java.util.List;

import pokemon.Pokemon;

public class Equipe {
    private final int totalPokemons = 3;
    private List<Pokemon> pokemons;

    public Equipe(){
        this.pokemons = new ArrayList<>();
    }

    public int getTotalPokemons() {
        return totalPokemons;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void listarPokemonos(){
        if (!pokemons.isEmpty()) {

            System.out.println("Seu time Pokémon:");
            for (Pokemon pokemon: pokemons) {
                System.out.println(
                    "- " + pokemon.getNome() +
                    " | Tipo: " + pokemon.getTipo() +
                    " | Vida: " + pokemon.getVida() + "/" + pokemon.getVidaMaxima() +
                    " | Atq: " + pokemon.getAtaque() +
                    " | Def: " + pokemon.getDefensa() +
                    " | Vel: " + pokemon.getVelocidade() +
                    " | Status: " + pokemon.getStatus()
                );
            }
        
        }else{
            System.out.println("Você não tem pokemons");
        }
    }

    public void adicionarPokemon(Pokemon pokemon){
        if(pokemons.size() <= totalPokemons){
            pokemons.add(pokemon);
        }else{
            System.out.println("Seu time está cheio! Você só pode ter " + totalPokemons + " Pokémon(s).");
        }
    }

    public Pokemon buscarPokemon(Pokemon pokemonBuscado){
        for (Pokemon pokemon: pokemons) {
            if(pokemonBuscado.getNome().equalsIgnoreCase(pokemon.getNome())){
                return pokemon;
            }
        }

        return null;
    }

    public void verificarPokemon(Pokemon pokemonEscolhido){
        Pokemon pokemon = buscarPokemon(pokemonEscolhido);

        if(pokemon != null){
            System.out.println(
                "- " + pokemon.getNome() +
                " | Tipo: " + pokemon.getTipo() +
                " | Vida: " + pokemon.getVida() + "/" + pokemon.getVidaMaxima() +
                " | Atq: " + pokemon.getAtaque() +
                " | Def: " + pokemon.getDefensa() +
                " | Vel: " + pokemon.getVelocidade() +
                " | Status: " + pokemon.getStatus()
            );
        }else{
            System.out.println(pokemonEscolhido.getAtaque() + " não está no seu time.");
        }
    }

}
