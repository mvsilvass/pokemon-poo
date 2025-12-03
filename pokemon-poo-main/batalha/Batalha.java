package batalha;

import java.util.Scanner;
import mochila.Mochila;
import pokemon.Pokemon;
import treinador.Treinador;

public class Batalha {
    private Treinador jogador1;
    private Treinador jogador2;
    private int turno = 0;
    private Scanner teclado = new Scanner(System.in);
    private Pokemon pokemonAtivo1;
    private Pokemon pokemonAtivo2;

    public Batalha(Treinador jogador1, Treinador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.pokemonAtivo1 = jogador1.getEquipe().getPokemons().get(0);
        this.pokemonAtivo2 = jogador2.getEquipe().getPokemons().get(0);
    }
    
    public Treinador verificarTurno() {
        if (this.turno % 2 == 0) {
            return jogador1;
        } else {
            return jogador2; 
        }
    }

    private Treinador getAdversario(Treinador jogador) {
        return jogador == jogador1 ? jogador2 : jogador1;
    }

    private Pokemon getPokemonAtivo(Treinador jogador) {
        return jogador == jogador1 ? pokemonAtivo1 : pokemonAtivo2;
    }

    private void setPokemonAtivo(Treinador jogador, Pokemon pokemon) {
        if (jogador == jogador1) {
            pokemonAtivo1 = pokemon;
        } else {
            pokemonAtivo2 = pokemon;
        }
    }

    public void iniciarBatalha() {
        System.out.println("\n==============================");
        System.out.println("A BATALHA COMEÇOU!");
        System.out.println(jogador1.getNome() + " VS " + jogador2.getNome());
        System.out.println("==============================\n");

        System.out.println("===Status Pokemon jogador1===");
        jogador1.getEquipe().listarPokemons();
        System.out.println("===Status Pokemon jogador2===");
        jogador2.getEquipe().listarPokemons();
        
        while (true) {
            Treinador jogadorAtual = verificarTurno();
            Treinador adversario = getAdversario(jogadorAtual);
            Pokemon pokemonAtual = getPokemonAtivo(jogadorAtual);
            Pokemon pokemonAdversario = getPokemonAtivo(adversario);

            // Verifica se algum Pokémon desmaiou
            if (pokemonAtual.getVida() <= 0) {
                System.out.println(jogadorAtual.getNome() + " perdeu seu Pokémon!");
                if (!temPokemonDisponivel(jogadorAtual)) {
                    System.out.println("\n" + jogadorAtual.getNome() + " ficou sem Pokémon!");
                    System.out.println(adversario.getNome() + " VENCEU A BATALHA!");
                    break;
                }
                
                trocarPokemonForcado(jogadorAtual);
                pokemonAtual = getPokemonAtivo(jogadorAtual);
            }

            if (pokemonAdversario.getVida() <= 0) {
                System.out.println(pokemonAdversario.getNome() + " foi derrotado!");

                if (!temPokemonDisponivel(adversario)) {
                    System.out.println("\n" + adversario.getNome() + " ficou sem Pokémon!");
                    System.out.println(jogadorAtual.getNome() + " VENCEU A BATALHA!");
                    break;
                }

                System.out.println(adversario.getNome() + " deve escolher um novo Pokémon!");
                trocarPokemonForcado(adversario);
                pokemonAdversario = getPokemonAtivo(adversario);
            }

            // Menu do jogador atual
            System.out.println("\n--- TURNO " + (turno + 1) + " ---");
            System.out.println(jogadorAtual.getNome() + ", é sua vez!");
            System.out.println("\nStatus:");
            exibirStatusBatalha(pokemonAtual, pokemonAdversario);
            
            boolean acaoValida = false;
            while (!acaoValida) {
                System.out.println("\nEscolha uma ação:");
                System.out.println("1 - Atacar");
                System.out.println("2 - Mochila");
                System.out.println("3 - Trocar Pokémon");
                System.out.println("4 - Desistir");

                int escolha = teclado.nextInt();
                teclado.nextLine(); // Consome a quebra de linha
                
                if(escolha == 4){
                    System.out.println(jogadorAtual.getNome() + " desistiu :(");
                    System.out.println(adversario.getNome() + " VENCEU A BATALHA!");
                    return;
                }
                
                if (escolha == 1) {
                    realizarAtaque(pokemonAtual, pokemonAdversario);
                    acaoValida = true;
                    turno++;

                } else if (escolha == 2) {
                    usarMochila(jogadorAtual, pokemonAtual);
                    acaoValida = true;

                } else if (escolha == 3) {
                    if (trocarPokemon(jogadorAtual)) {
                        setPokemonAtivo(jogadorAtual, getPokemonAtivo(jogadorAtual));
                        acaoValida = true;
                        turno++;
                    } else {
                        System.out.println("Ação cancelada. Escolha novamente.");
                    }

                } else {
                    System.out.println("Opção inválida! Tente novamente.");
                }
            }
        }
    }

    private void realizarAtaque(Pokemon atacante, Pokemon defensor) {
        System.out.println("\n--- ATAQUE ---");
        System.out.println(atacante.getNome() + " está atacando " + defensor.getNome() + "!");
        System.out.println(atacante.getNome() + " usa a habilidade " + atacante.getHabilidade().getNome() + "!");
       
        atacante.atacar(atacante.getHabilidade(), defensor);

        if (defensor.getVida() < 0) {
            defensor.setVida(0);
        }
        
        System.out.println(defensor.getNome() + " agora tem " + defensor.getVida() + " de vida!");
    }

    private void usarMochila(Treinador jogador, Pokemon pokemonAtual) { 
        Mochila mochila = jogador.getMochila();
        mochila.listarItens();

        System.out.println("\nDigite o nome do item que deseja usar (ou 'cancelar'):");
        String nomeItem = teclado.nextLine().trim();

        if (nomeItem.equalsIgnoreCase("cancelar")) {
            System.out.println("Ação cancelada.");
            return;
        }
        
        mochila.usarItem(nomeItem, pokemonAtual);
        turno++;
    }

    private boolean trocarPokemon(Treinador jogador) {
        System.out.println("\n--- TROCAR POKÉMON ---");
        
        java.util.List<Pokemon> pokemons = jogador.getEquipe().getPokemons();
        
        System.out.println("Pokémon disponíveis:");
        for (int i = 0; i < pokemons.size(); i++) {
            Pokemon p = pokemons.get(i);
            String status = p.getVida() <= 0 ? " (Desmaiado)" : " (Vida: " + p.getVida() + ")";
            System.out.println((i + 1) + " - " + p.getNome() + status);
        }
        System.out.println("0 - Cancelar");

        int escolha = teclado.nextInt();
        teclado.nextLine();

        if (escolha == 0) {
            return false;
        }

        if (escolha > 0 && escolha <= pokemons.size()) {
            Pokemon novoPokemon = pokemons.get(escolha - 1);
            if (novoPokemon.getVida() <= 0) {
                System.out.println("Este Pokémon está desmaiado!");
                return false;
            }
            System.out.println(jogador.getNome() + " enviou " + novoPokemon.getNome() + "!");
            setPokemonAtivo(jogador, novoPokemon);
            return true;
        }

        System.out.println("Opção inválida!");
        return false;
    }

    private boolean temPokemonDisponivel(Treinador jogador) {
        for (Pokemon p : jogador.getEquipe().getPokemons()) {
            if (p.getVida() > 0) {
                return true;
            }
        }
        return false;
    }

    private void trocarPokemonForcado(Treinador jogador) {
        java.util.List<Pokemon> pokemons = jogador.getEquipe().getPokemons();
        for (Pokemon p : pokemons) {
            if (p.getVida() > 0) {
                System.out.println(jogador.getNome() + " enviou " + p.getNome() + "!");
                setPokemonAtivo(jogador, p);
                return;
            }
        }
    }

    private void exibirStatusBatalha(Pokemon pokemonAtual, Pokemon pokemonAdversario) {
        System.out.println(pokemonAtual.getNome() + " | Vida: " + pokemonAtual.getVida() + "/" + pokemonAtual.getVidaMaxima());
        System.out.println(pokemonAdversario.getNome() + " | Vida: " + pokemonAdversario.getVida() + "/" + pokemonAdversario.getVidaMaxima());
    }
    
    
}