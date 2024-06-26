import java.util.ArrayList;
import java.util.List;

public class Contatto {
    private String nome;
    private String numTel;

    public Contatto(String nome, String numTel){
        this.nome=nome;
        this.numTel=numTel;
    }
    public String getNome() {
        return nome;
    }

    public String getNumeroTelefono() {
        return numTel;
    }
    
    public class ElencoTelefonico {
    private List<Contatto> elenco;

    public ElencoTelefonico() {
        this.elenco = new ArrayList<>();
    }

    public void aggiungiContatto(String nome, String numeroTelefono) throws IllegalArgumentException {
        try {
            Contatto nuovoContatto = new Contatto(nome, numeroTelefono);
            elenco.add(nuovoContatto);
            System.out.println("Contatto aggiunto: " + nome + " - " + numeroTelefono);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }


    public Contatto cercaContatto(String nome) {
        for (Contatto contatto : elenco) {
            if (contatto.getNome().equals(nome)) {
                return contatto;
            }
        }
        System.out.println("Contatto non trovato: " + nome);
        return null;
    }

    public void stampaElenco() {
        System.out.println("Elenco Telefonico:");
        for (Contatto contatto : elenco) {
            System.out.println(contatto.getNome() + " - " + contatto.getNumeroTelefono());
        }
        System.out.println("Fine dell'elenco.");
    }
}
}
