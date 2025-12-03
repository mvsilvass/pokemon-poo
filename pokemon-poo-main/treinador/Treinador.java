package treinador;

import equipe.Equipe;
import mochila.Mochila;
import pokemon.Pokemon;

public class Treinador {
    private String nome;
    private Equipe equipe;
    private Mochila mochila;

    public Treinador(String nome){
        this.nome = nome;
        this.equipe = new Equipe();
        this.mochila = new Mochila();
    }

    public String getNome() {
        return nome;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public Mochila getMochila() {
        return mochila;
    }

    public void escolherPokemon(Pokemon pokemon) {
        this.equipe.adicionarPokemon(pokemon);
    }

}
