package src;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Esercizio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> parole = new HashSet<>();
        Set<String> duplicati = new HashSet<>();

        System.out.println("Inserisci il numero di parole da inserire:");
        int N = scanner.nextInt();
        scanner.nextLine(); // consumare la newline

        for (int i = 0; i < N; i++) {
            System.out.println("Inserisci una parola:");
            String parola = scanner.nextLine();
            if (!parole.add(parola)) {
                duplicati.add(parola);
            }
        }

        // Stampa parole duplicate
        if (!duplicati.isEmpty()) {
            System.out.println("Parole duplicate:");
            for (String parola : duplicati) {
                System.out.println(parola);
            }
        } else {
            System.out.println("Non ci sono parole duplicate.");
        }

        // Stampa numero di parole distinte
        System.out.println("Numero di parole distinte: " + parole.size());

        // Stampa elenco delle parole distinte
        System.out.println("Elenco delle parole distinte:");
        for (String parola : parole) {
            System.out.println(parola);
        }

        scanner.close();
    }
}
