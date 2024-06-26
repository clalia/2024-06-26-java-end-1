import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        //es1();
        es2();
    }
    public static void es1(){
        Prenotazioni teatro = new Prenotazioni(100);

        // Prenotare il posto 10
        System.out.println("Prenotazione posto 10: " + teatro.Prenota(10)); 
        // Verificare se il posto 10 è disponibile
        System.out.println("Posto 10 disponibile: " + teatro.isDisponibile(10)); 
        // Annullare la prenotazione del posto 10
        System.out.println("Annullamento prenotazione posto 10: " + teatro.annullaPrenotazione(10)); 
        // Verificare se il posto 10 è disponibile dopo l'annullamento
        System.out.println("Posto 10 disponibile: " + teatro.isDisponibile(10)); 

        // Verificare la disponibilità di una serie di posti
        int[] postiDaVerificare = {30, 31, 32};
        System.out.println("Posti 30, 31, 32 disponibili: " + teatro.sonoPostiDisponibili(postiDaVerificare));
        for (int posto : postiDaVerificare) {
            teatro.Prenota(posto);
        }
        // Verificare di nuovo la disponibilità di una serie di posti
        System.out.println("Posti 30, 31, 32 disponibili: " + teatro.sonoPostiDisponibili(postiDaVerificare));
    }
    public static void es2() {
        // Esempio di utilizzo della classe Studente con ArrayList per nome e matricola
        ArrayList<String> nome = new ArrayList<>();
        nome.add("Cla Lia");
        nome.add("Anna G");

        ArrayList<String> matricola = new ArrayList<>();
        matricola.add("237018");
        matricola.add("237019");

        RegistroStudenti registro = new RegistroStudenti(nome, matricola);
        
        try {
            registro.aggiungiVoto(25,0);
            registro.aggiungiVoto(28,1);
            registro.aggiungiVoto(30,0);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
        
        registro.stampaDettagli();
    }
}
