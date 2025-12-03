package habilidade;

import pokemon.Pokemon;

public abstract class Habilidade {
    private String nome;
    private String descricao;

    public Habilidade(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public abstract void usarHabilidade(Pokemon atacante, Pokemon alvo);

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

}
