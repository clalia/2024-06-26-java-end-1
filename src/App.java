import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        //es1();
        //es2();
        //es3();
        //es4();
    }
    public static void es1(){
        Prenotazioni teatro = new Prenotazioni(100);

        
        System.out.println("Prenotazione posto 10: " + teatro.Prenota(10)); 
        
        System.out.println("Posto 10 disponibile: " + teatro.isDisponibile(10)); 
        
        System.out.println("Annullamento prenotazione posto 10: " + teatro.annullaPrenotazione(10)); 
        
        System.out.println("Posto 10 disponibile: " + teatro.isDisponibile(10)); 

        
        int[] postiDaVerificare = {30, 31, 32};
        System.out.println("Posti 30, 31, 32 disponibili: " + teatro.sonoPostiDisponibili(postiDaVerificare));
        for (int posto : postiDaVerificare) {
            teatro.Prenota(posto);
        }
        
        System.out.println("Posti 30, 31, 32 disponibili: " + teatro.sonoPostiDisponibili(postiDaVerificare));
    }
    public static void es2() {
        
        ArrayList<String> nome = new ArrayList<>();
        nome.add("Cla Lia");
        nome.add("Anna G");

        ArrayList<String> matricola = new ArrayList<>();
        matricola.add("237018");
        matricola.add("237019");

        RegistroStudenti registro = new RegistroStudenti();
        
        try {
            registro.aggiungiVoto(25,0);
            registro.aggiungiVoto(28,1);
            registro.aggiungiVoto(30,0);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
        
        registro.stampaDettagli();
    }
    public static void es3() {
        ContoBancario conto = new ContoBancario(1000);

        System.out.println("Saldo iniziale: " + conto.getSaldo() + " euro");

        try {
            conto.deposita(500);
            System.out.println("Nuovo saldo dopo deposito: " + conto.getSaldo() + " euro");

            conto.preleva(200);
            System.out.println("Nuovo saldo dopo prelievo: " + conto.getSaldo() + " euro");

            conto.preleva(2000);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }

        System.out.println("Saldo finale: " + conto.getSaldo() + " euro");
    }
    public static void es4(){
        ElencoTelefonico elenco = new ElencoTelefonico();

        
        elenco.aggiungiContatto("Chiara Rossi", "+39324567890");
        elenco.aggiungiContatto("Luigi Giallo", "+39334536789");

        
        Contatto contatto = elenco.cercaContatto("Chiara Rossi");
        if (contatto != null) {
            System.out.println("Contatto trovato: " + contatto.getNome() + " - " + contatto.getNumeroTelefono());
        }

        
        elenco.rimuoviContatto("Luigi Giallo");


        elenco.stampaElenco();
    }
}

