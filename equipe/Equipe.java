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

            System.out.println("\nSeu time Pokémon:\n");
            for (int i = 0; i < pokemons.size(); i++) {
                Pokemon pokemon = pokemons.get(i);
                System.out.println((i + 1) + " - " + pokemon.getNome().toUpperCase());
                System.out.println("--------------------------------\n");
                System.out.println("Nome:   " + pokemon.getNome());
                System.out.println("Tipo:   " + pokemon.getTipo());
                System.out.println("Vida:   " + pokemon.getVida() + "/" + pokemon.getVidaMaxima());
                System.out.println("Ataque: " + pokemon.getAtaque());
                System.out.println("Defesa: " + pokemon.getDefensa());
                System.out.println("Status: " + pokemon.getStatus());
                System.out.println("--------------------------------\n");
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
            System.out.println("Nome:   " + pokemon.getNome());
            System.out.println("Tipo:   " + pokemon.getTipo());
            System.out.println("Vida:   " + pokemon.getVida() + "/" + pokemon.getVidaMaxima());
            System.out.println("Ataque: " + pokemon.getAtaque());
            System.out.println("Defesa: " + pokemon.getDefensa());
            System.out.println("Status: " + pokemon.getStatus());
            System.out.println("--------------------------------\n");
        }else{
            System.out.println(pokemonEscolhido.getAtaque() + " não está no seu time.");
        }
    }

    public boolean isEquipeCompleta() {
        return pokemons.size() < totalPokemons;
    }

    public boolean temPokemonComVida() {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getVida() > 0) {
                return true;
            }
        }

        return false;
    }

    public Pokemon proximoPokemonComVida() {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getVida() > 0) {
                return pokemon;
            }
        }
        
        return null;
    }

    public Pokemon getPokemonPorIndice(int indice) {
        if (indice >= 0 && indice < pokemons.size()) {
            return pokemons.get(indice);
        }

        return null;
    }

}
