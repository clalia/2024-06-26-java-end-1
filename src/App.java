public class App {
    public static void main(String[] args) {
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
}
