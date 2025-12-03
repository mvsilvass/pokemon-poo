import batalha.Batalha;
import java.util.Scanner;
import pokemon.PokemonAgua;
import pokemon.PokemonFogo;
import pokemon.PokemonPlanta;
import treinador.Treinador;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        System.out.println("\nInforme o nome do jogador 1:");
        String nome1 = teclado.nextLine();
        
        System.out.println("\nInforme o nome do jogador 2:");
        String nome2 = teclado.nextLine();

        Treinador jogador1 = new Treinador(nome1);
        Treinador jogador2 = new Treinador(nome2);


        int opcao;
        while (jogador1.getEquipe().getPokemons().size() < jogador1.getEquipe().getTotalPokemons()) {
            System.out.println("\nJogador 1, escolha seu Pokemons:");
            System.out.println("\n==============================");
            System.out.println("Tipo planta:\n");
            System.out.println("1 - Bulbassauro");
            System.out.println("2 - Chikorita");
            System.out.println("3 - Tangela");
            System.out.println("\n==============================");
            System.out.println("Tipo fogo:\n");
            System.out.println("4 - Charmander");
            System.out.println("5 - Vulpix");
            System.out.println("6 - Ponyta");
            System.out.println("\n==============================");
            System.out.println("Tipo agua:\n");
            System.out.println("7 - Squirtle");
            System.out.println("8 - Psyduck");
            System.out.println("9 - Poliwag");
            System.out.println("\n==============================");
            opcao = teclado.nextInt();

            if (opcao == 1){
                jogador1.getEquipe().adicionarPokemon(new PokemonPlanta("Bulbasaur", 90, 90, 37, 22, "Folha Navalha", "Corta o inimigo com folhas afiadas"));
            } else if (opcao == 2){
                jogador1.getEquipe().adicionarPokemon(new PokemonPlanta("Chikorita", 90, 90, 38, 22, "Folha Navalha", "Corta o inimigo com folhas afiadas"));
            } else if (opcao == 3){
                jogador1.getEquipe().adicionarPokemon(new PokemonPlanta("Tangela", 110, 110, 42, 21, "Vinhaço", "Ataca o inimigo com vinhas"));
            } else if (opcao == 4){
                jogador1.getEquipe().adicionarPokemon(new PokemonFogo("Charmander", 78, 78, 40, 26, "Lanca Chamas", "Um poderoso ataque de fogo"));
            } else if (opcao == 5){
                jogador1.getEquipe().adicionarPokemon(new PokemonFogo("Vulpix", 76, 76, 49, 27, "Bola de Fogo", "Uma bola de fogo incandescente"));
            } else if (opcao == 6){
                jogador1.getEquipe().adicionarPokemon(new PokemonFogo("Ponyta", 100, 100, 51, 19, "Chamas Ardentes", "Chamas que queimam intensamente"));
            } else if (opcao == 7){
                jogador1.getEquipe().adicionarPokemon(new PokemonAgua("Squirtle", 88, 88, 48, 21, "Jato de Agua", "Um jato de agua pressurizada"));
            } else if (opcao == 8){
                jogador1.getEquipe().adicionarPokemon(new PokemonAgua("Psyduck", 97, 97, 38, 24, "Onda de Agua", "Uma onda poderosa de agua"));
            } else if (opcao == 9){
                jogador1.getEquipe().adicionarPokemon(new PokemonAgua("Poliwag", 80, 80, 41, 20, "Redemoinho", "Cria um redemoinho para atacar o inimigo"));
            } else {
                System.out.println("\nOpção invalida. Tente novamente.");
            }
        }   

        while (jogador2.getEquipe().getPokemons().size() < jogador2.getEquipe().getTotalPokemons()) {
            System.out.println("\nJogador 2, escolha seu Pokemons:");
            System.out.println("\n==============================");
            System.out.println("Tipo planta:\n");
            System.out.println("1 - Bulbassauro");
            System.out.println("2 - Chikorita");
            System.out.println("3 - Tangela");
            System.out.println("\n==============================");
            System.out.println("Tipo fogo:\n");
            System.out.println("4 - Charmander");
            System.out.println("5 - Vulpix");
            System.out.println("6 - Ponyta");
            System.out.println("\n==============================");
            System.out.println("Tipo agua:\n");
            System.out.println("7 - Squirtle");
            System.out.println("8 - Psyduck");
            System.out.println("9 - Poliwag");
            System.out.println("\n==============================");
            opcao = teclado.nextInt();

            if (opcao == 1){
                jogador2.getEquipe().adicionarPokemon(new PokemonPlanta("Bulbasaur", 90, 90, 37, 22, "Folha Navalha", "Corta o inimigo com folhas afiadas"));
            } else if (opcao == 2){
                jogador2.getEquipe().adicionarPokemon(new PokemonPlanta("Chikorita", 90, 90, 38, 22, "Folha Navalha", "Corta o inimigo com folhas afiadas"));
            } else if (opcao == 3){
                jogador2.getEquipe().adicionarPokemon(new PokemonPlanta("Tangela", 110, 110, 42, 21, "Vinhaço", "Ataca o inimigo com vinhas"));
            } else if (opcao == 4){
                jogador2.getEquipe().adicionarPokemon(new PokemonFogo("Charmander", 78, 78, 40, 26, "Lanca Chamas", "Um poderoso ataque de fogo"));
            } else if (opcao == 5){
                jogador2.getEquipe().adicionarPokemon(new PokemonFogo("Vulpix", 76, 76, 49, 27, "Bola de Fogo", "Uma bola de fogo incandescente"));
            } else if (opcao == 6){
                jogador2.getEquipe().adicionarPokemon(new PokemonFogo("Ponyta", 100, 100, 51, 19, "Chamas Ardentes", "Chamas que queimam intensamente"));
            } else if (opcao == 7){
                jogador2.getEquipe().adicionarPokemon(new PokemonAgua("Squirtle", 88, 88, 48, 21, "Jato de Agua", "Um jato de agua pressurizada"));
            } else if (opcao == 8){
                jogador2.getEquipe().adicionarPokemon(new PokemonAgua("Psyduck", 97, 97, 38, 24, "Onda de Agua", "Uma onda poderosa de agua"));
            } else if (opcao == 9){
                jogador2.getEquipe().adicionarPokemon(new PokemonAgua("Poliwag", 80, 80, 41, 20, "Redemoinho", "Cria um redemoinho para atacar o inimigo"));
            } else {
                System.out.println("\nOpção invalida. Tente novamente.");
            }
        }
        
        Batalha batalha = new Batalha(jogador1, jogador2);
        batalha.iniciarBatalha();
        teclado.close();
    }
}
