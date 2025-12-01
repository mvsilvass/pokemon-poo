package item;

import pokemon.Status;
import pokemon.Pokemon;

public class Medicamento extends Item{
    private Status statusTratado;

    public Medicamento(String nome, Status statusTratado, int quantidade){
        super(nome, "Esse medicamento é capaz de curar " + statusTratado, quantidade);
        this.statusTratado = statusTratado;
    }

    @Override
    public void aplicarEfeito(Pokemon pokemon) {
        if (pokemon.getStatus() == statusTratado) {
            System.out.println("Usando " + getNome() + " para curar " + statusTratado);
            pokemon.setStatus(Status.NORMAL);
        } else {
            System.out.println("O Pokémon não está com " + statusTratado);
        }
    }

}
