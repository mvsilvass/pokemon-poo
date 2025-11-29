package pokemon;

public abstract class Pokemon {
    private String nome;
    private Tipo tipo;
    private int vida;
    private final int vidaMaxima;
    private int ataque;
    private int defensa;
    private int velocidade;
    private Status status;

    public Pokemon(String nome, Tipo tipo, int vida,int vidaMaxima, int ataque, int defensa, int velocidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.vida = vida;
        this.vidaMaxima = vidaMaxima;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidade = velocidade;
    }
    
    /* gets */
    public String getNome() { return nome; }
    public Tipo getTipo() { return tipo; }
    public int getVida() { return vida; }
    public int getVidaMaxima() { return vidaMaxima; }    
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getVelocidade() { return velocidade; }
    public Status getStatus() { return status; }


    /* sets */
    public void setVida(int vida) { this.vida = vida; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public void setDefensa(int defensa) { this.defensa = defensa; }
    public void setVelocidade(int velocidade) { this.velocidade = velocidade; }
    public void setStatus(Status status) { this.status = status; }

    public abstract void imprimirStatus();

    public abstract void atacar(int dano);

    public abstract void defender(int defesa);
    
    public abstract void esquivar(int velocidade);
}