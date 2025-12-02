package habilidade;

import pokemon.Pokemon;

public abstract class Habilidade {
    private final String nome;
    private final String descricao;
    private final Pokemon pokemon;

    public Habilidade(String nome, String descricao, Pokemon pokemon) {
        this.nome = nome;
        this.descricao = descricao;
        this.pokemon = pokemon;
    }

    public abstract void usarHabilidade(Pokemon alvo);

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

}
