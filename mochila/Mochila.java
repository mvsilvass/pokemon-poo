package mochila;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import item.Item;
import item.ItemDeCura;
import item.Medicamento;
import item.Reviver;
import pokemon.Pokemon;
import pokemon.Status;

public class Mochila {
    private List<Item> itens = new ArrayList<>(); 

    public Mochila() {
        this.gerarItensIniciais();
    }

    private void gerarItensIniciais() {
        Random random = new Random();

        // Cria itens com quantidade aleatória de 1 a 2
        itens.add(new ItemDeCura("Poção", 20, random.nextInt(2) + 1));
        itens.add(new ItemDeCura("Super Poção", 50, random.nextInt(2) + 1));
        itens.add(new ItemDeCura("Refrigerante", 30, random.nextInt(2) + 1));

        itens.add(new Medicamento("Antídoto", Status.ENVENENADO, random.nextInt(2) + 1));
        itens.add(new Medicamento("Antiqueimadura", Status.QUEIMANDO, random.nextInt(2) + 1));
        itens.add(new Medicamento("Despertar", Status.DORMINDO, random.nextInt(2) + 1));
        itens.add(new Medicamento("Despertar", Status.DORMINDO, random.nextInt(2) + 1));
        itens.add(new Reviver("Reviver", random.nextInt(2) + 1));
    }

    public void usarItem(Item itemEscolhido, Pokemon pokemon) {
        Item item = buscarItem(itemEscolhido.getNome());

        if(item != null){
            item.aplicarEfeito(pokemon);
            atualizarQuantidade(item);
        }else{
            System.out.println("Você não possui " + itemEscolhido.getNome() + " na mochila!");
        }

    }

    private Item buscarItem(String nome) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        
        return null;
    }

    public void atualizarQuantidade(Item item){
        if (item.getQuantidade() > 0) {  
            item.setQuantidade(item.getQuantidade() - 1);
            System.out.println("Quantidade restante de " + item.getNome() + ": " + item.getQuantidade());
        }else{ 
            itens.remove(item);
            System.out.println("Todos os " + item.getNome() + " da sua mochila foram usados!");
        }
    }

    public void listarItens(){
        if (!itens.isEmpty()) {
            System.out.println("Itens na mochila:");

            for (Item item : itens) {
                System.out.println("- " + item.getNome() + " x" + item.getQuantidade());
            }
           
        }else{
            System.out.println("Sua mochila está vazia!");
        }
    
    }

    public void mostrarItem(Item itemEscolhido){
        Item item = buscarItem(itemEscolhido.getNome());

        if(item != null){
            System.out.println("-------------------------------------");
            System.out.println("- Nome: " + item.getNome());
            System.out.println("  Descrição: " + item.getDescricao());
            System.out.println("  Quantidade: " + item.getQuantidade());
            System.out.println("--------------------------------------");
        }else{
            System.out.println("Você não possui " + itemEscolhido.getNome() + " na mochila!");
        }
    }
}
