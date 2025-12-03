package batalha;

import java.util.Scanner;
import mochila.Mochila;
import pokemon.Pokemon;
import pokemon.Status;
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
        System.out.println("\n--------------------------------");
        System.out.println("\nA BATALHA COMEÇOU! " + jogador1.getNome().toUpperCase() + " VS " + jogador2.getNome().toUpperCase());
        System.out.println("\n--------------------------------");

        while (true) {
            Treinador jogadorAtual = verificarTurno();
            Treinador adversario = getAdversario(jogadorAtual);
            Pokemon pokemonAtual = getPokemonAtivo(jogadorAtual);
            Pokemon pokemonAdversario = getPokemonAtivo(adversario);

            // Verifica se algum Pokémon desmaiou
            if (pokemonAtual.getStatus() == Status.DESMAIADO) {
                System.out.println(jogadorAtual.getNome() + " perdeu seu Pokémon!");

                if (!jogadorAtual.getEquipe().temPokemonComVida()) {
                    System.out.println("\n" + jogadorAtual.getNome() + " ficou sem Pokémon!");
                    System.out.println(adversario.getNome().toUpperCase() + " VENCEU A BATALHA!");
                    break;
                }

                trocarPokemonForcado(jogadorAtual);
                pokemonAtual = getPokemonAtivo(jogadorAtual);
            }

            if (pokemonAdversario.getStatus() == Status.DESMAIADO) {
                System.out.println(pokemonAdversario.getNome() + " foi derrotado!");

                if (!adversario.getEquipe().temPokemonComVida()) {
                    System.out.println("\n" + adversario.getNome() + " ficou sem Pokémon!");
                    System.out.println(jogadorAtual.getNome().toUpperCase() + " VENCEU A BATALHA!");
                    break;
                }

                trocarPokemonForcado(adversario);
                pokemonAdversario = getPokemonAtivo(adversario);
            }

            // Menu do jogador atual
            System.out.println("\n----------  TURNO " + (turno + 1) + " ----------\n");
            System.out.println(jogadorAtual.getNome() + ", é sua vez!");
            exibirStatusBatalha(pokemonAtual, pokemonAdversario, jogadorAtual, adversario);

            boolean acaoValida = false;
            while (!acaoValida) {
                System.out.println("Escolha uma ação:");
                System.out.println("1 - Atacar");
                System.out.println("2 - Mochila");
                System.out.println("3 - Trocar Pokémon");
                System.out.println("4 - Verificar Pokémons");
                System.out.println("5 - Desistir");

                int escolha = teclado.nextInt();
                teclado.nextLine();

                if (escolha == 5) {
                    System.out.println("\n" + jogadorAtual.getNome() + " desistiu :(");
                    System.out.println(adversario.getNome().toUpperCase() + " VENCEU A BATALHA!");
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

                } else if (escolha == 4) {
                    jogadorAtual.getEquipe().listarPokemonos();
                } else {
                    System.out.println("Opção inválida! Tente novamente.");
                }
            }
        }
    }

    private void realizarAtaque(Pokemon atacante, Pokemon defensor) {
        System.out.println("\n----------  ATAQUE ----------\n");
        System.out.println(atacante.getNome() + " está atacando " + defensor.getNome() + "!");
        System.out.println(atacante.getNome() + " sou a habilidade " + atacante.getHabilidade().getNome() + "!");

        atacante.atacar(atacante.getHabilidade(), defensor);

        System.out.println("\n" + defensor.getNome() + " agora tem " + defensor.getVida() + " de vida!");

        if (defensor.getStatus() != Status.NORMAL && defensor.getStatus() != Status.DESMAIADO) {
            System.out.println(defensor.getNome() + " está " + defensor.getStatus().name().toLowerCase() + "!");
        }
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

        System.out.println("\n------ TROCAR POKÉMON ------");
        jogador.getEquipe().listarPokemonos();

        System.out.println("\nDigite o número do Pokémon ( 0 para cancelar):");

        int escolha = teclado.nextInt();
        teclado.nextLine();

        if (escolha == 0) {
            System.out.println("\nCancelando...");
            return false;
        }

        Pokemon novoPokemon = jogador.getEquipe().getPokemonPorIndice(escolha - 1);

        if (novoPokemon == null) {
            System.out.println("\nNúmero inválido! Tente novamente.");
        } else {
            if (novoPokemon.getStatus() == Status.DESMAIADO) {
                System.out.println("\nEste Pokémon está desmaiado!");
            } else {
                if (novoPokemon == getPokemonAtivo(jogador)) {
                    System.out.println("\nEste Pokémon já está em batalha!");
                } else {
                    System.out.println("\n" + jogador.getNome() + " enviou " + novoPokemon.getNome() + "!");
                    setPokemonAtivo(jogador, novoPokemon);
                    return true;
                }

            }
        }

        return false;
    }

    private void trocarPokemonForcado(Treinador jogador) {
        Pokemon pokemonVivo = jogador.getEquipe().proximoPokemonComVida();

        if (pokemonVivo != null) {
            System.out.println(jogador.getNome() + " enviou " + pokemonVivo.getNome() + "!");
            setPokemonAtivo(jogador, pokemonVivo);
        }
    }

    private void exibirStatusBatalha(Pokemon pokemonAtual, Pokemon pokemonAdversario, Treinador jogadorAtual,
            Treinador jogadorAdversario) {
        System.out.println("\n------ STATUS DA BATALHA ------\n");

        System.out.println("Treinador: " + jogadorAtual.getNome());
        jogadorAtual.getEquipe().verificarPokemon(pokemonAtual);

        System.out.println("Treinador: " + jogadorAdversario.getNome());
        jogadorAdversario.getEquipe().verificarPokemon(pokemonAdversario);
    }

}