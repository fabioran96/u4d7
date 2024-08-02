package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Esercizio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il numero di interi casuali da generare:");
        int N = scanner.nextInt();
        List<Integer> listaCasuale = generaListaCasuale(N);
        System.out.println("Lista casuale generata:");
        System.out.println(listaCasuale);

        List<Integer> listaConInverso = aggiungiInverso(listaCasuale);
        System.out.println("Lista con inverso aggiunto:");
        System.out.println(listaConInverso);

        System.out.println("Vuoi stampare i valori in posizioni pari (true/false)?");
        boolean pari = scanner.nextBoolean();
        stampaValori(listaCasuale, pari);

        scanner.close();
    }

    // Funzione 1: Genera una lista di N interi casuali da 0 a 100
    public static List<Integer> generaListaCasuale(int N) {
        List<Integer> lista = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            lista.add(random.nextInt(101));
        }
        Collections.sort(lista);
        return lista;
    }

    // Funzione 2: Aggiunge l'inverso della lista alla lista originale
    public static List<Integer> aggiungiInverso(List<Integer> lista) {
        List<Integer> nuovaLista = new ArrayList<>(lista);
        List<Integer> inverso = new ArrayList<>(lista);
        Collections.reverse(inverso);
        nuovaLista.addAll(inverso);
        return nuovaLista;
    }

    // Funzione 3: Stampa i valori in posizioni pari o dispari
    public static void stampaValori(List<Integer> lista, boolean pari) {
        System.out.println(pari ? "Valori in posizioni pari:" : "Valori in posizioni dispari:");
        for (int i = 0; i < lista.size(); i++) {
            if (pari && i % 2 == 0) {
                System.out.println(lista.get(i));
            } else if (!pari && i % 2 != 0) {
                System.out.println(lista.get(i));
            }
        }
    }
}
