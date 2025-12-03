package pokemon;

import habilidade.Habilidade;

public abstract class Pokemon {
    private String nome;
    private Tipo tipo;
    private int vida;
    private final int vidaMaxima;
    private int ataque;
    private int defensa;
    private Status status;
    private Habilidade habilidade;

    public Pokemon(String nome, Tipo tipo, int vida, int vidaMaxima, int ataque, int defensa, Habilidade habilidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.vida = vida;
        this.vidaMaxima = vidaMaxima;
        this.ataque = ataque;
        this.defensa = defensa;
        this.status = Status.NORMAL;
        this.habilidade = habilidade;
    }
    
    /* gets */
    public String getNome() { return nome; }
    public Tipo getTipo() { return tipo; }
    public int getVida() { return vida; }
    public int getVidaMaxima() { return vidaMaxima; }    
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public Status getStatus() { return status; }
    public Habilidade getHabilidade() { return habilidade; }

    /* sets */
    public void setVida(int vida) { this.vida = vida; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public void setDefensa(int defensa) { this.defensa = defensa; }
    public void setStatus(Status status) { this.status = status; }
    

    public abstract void atacar(Habilidade habilidade, Pokemon alvo);

}