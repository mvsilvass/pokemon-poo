public abstract class Item {
    private String nome;
    private int potencia;

    public Item(String nome, int potencia) {
        this.nome = nome;
        this.potencia = potencia;
    }

    public String getNome() {
        return nome;
    }

    public int getPotencia() {
        return potencia;
    }
    
    public abstract void UsarItem();
}
