public abstract class Pokemon {
    private String nome;
    private String tipo;
    private int vida;
    private int ataque;
    private int defensa;
    private int velocidade;

    public Pokemon(String nome, String tipo, int vida, int ataque, int defensa, int velocidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidade = velocidade;
    }
    
    /* gets */
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getVelocidade() { return velocidade; }
    public String getTipo() { return tipo; }

    /* sets */
    public void setVida(int vida) { this.vida = vida; }
    public void setDefensa(int defensa) { this.defensa = defensa; }
    public void setVelocidade(int velocidade) { this.velocidade = velocidade; }
    public void setAtaque(int ataque) { this.ataque = ataque; }

    //talvez fique como um @Override na classe batalha
    public abstract void imprimirStatus();

    public abstract void ataqueBasico(int dano, int velocidade);
}