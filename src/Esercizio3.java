package src;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Esercizio3 {
    private Map<String, String> rubrica;

    public Esercizio3() {
        this.rubrica = new HashMap<>();
    }

    // Metodo per inserire una coppia <Nome, Telefono>
    public void inserisciContatto(String nome, String telefono) {
        rubrica.put(nome, telefono);
        System.out.println("Contatto inserito: " + nome + " -> " + telefono);
    }

    // Metodo per cancellare una coppia <Nome, Telefono> a partire dal nome
    public void cancellaContatto(String nome) {
        if (rubrica.containsKey(nome)) {
            rubrica.remove(nome);
            System.out.println("Contatto " + nome + " cancellato.");
        } else {
            System.out.println("Contatto " + nome + " non trovato.");
        }
    }

    // Metodo per la ricerca di una persona di cui si conosce il numero di telefono
    public String cercaPersonaPerNumero(String telefono) {
        for (Map.Entry<String, String> entry : rubrica.entrySet()) {
            if (entry.getValue().equals(telefono)) {
                return entry.getKey();
            }
        }
        return "Numero di telefono " + telefono + " non trovato.";
    }

    // Metodo per la ricerca del numero di telefono di una persona di cui si conosce il nome
    public String cercaNumeroPerNome(String nome) {
        return rubrica.getOrDefault(nome, "Nome " + nome + " non trovato.");
    }

    // Metodo per stampare tutti i contatti con nome e numero
    public void stampaContatti() {
        if (rubrica.isEmpty()) {
            System.out.println("La rubrica è vuota.");
        } else {
            System.out.println("Elenco dei contatti:");
            for (Map.Entry<String, String> entry : rubrica.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        Esercizio3 rubrica = new Esercizio3();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Rubrica Telefonica ---");
            System.out.println("1. Inserisci contatto");
            System.out.println("2. Cancella contatto");
            System.out.println("3. Cerca persona per numero");
            System.out.println("4. Cerca numero per nome");
            System.out.println("5. Stampa contatti");
            System.out.println("6. Esci");
            System.out.print("Scegli un'opzione: ");
            int scelta = scanner.nextInt();
            scanner.nextLine(); // consumare la newline

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Inserisci telefono: ");
                    String telefono = scanner.nextLine();
                    rubrica.inserisciContatto(nome, telefono);
                    break;
                case 2:
                    System.out.print("Inserisci nome del contatto da cancellare: ");
                    nome = scanner.nextLine();
                    rubrica.cancellaContatto(nome);
                    break;
                case 3:
                    System.out.print("Inserisci numero di telefono: ");
                    telefono = scanner.nextLine();
                    System.out.println("Persona trovata: " + rubrica.cercaPersonaPerNumero(telefono));
                    break;
                case 4:
                    System.out.print("Inserisci nome: ");
                    nome = scanner.nextLine();
                    System.out.println("Numero di telefono: " + rubrica.cercaNumeroPerNome(nome));
                    break;
                case 5:
                    rubrica.stampaContatti();
                    break;
                case 6:
                    System.out.println("Uscita...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
                    break;
            }
        }
    }

}
