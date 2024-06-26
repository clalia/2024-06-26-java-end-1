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

    public void aggiungiContatto(String nome, String numTel) throws IllegalArgumentException {
        try {
            Contatto nuovoContatto = new Contatto(nome, numTel);
            elenco.add(nuovoContatto);
            System.out.println("Contatto aggiunto: " + nome + " - " + numTel);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
    public void rimuoviContatto(String nome){
        for (int i = 0; i < elenco.size(); i++) {
            Contatto contatto = elenco.get(i);
            if (contatto.getNome().equals(nome)) {
                elenco.remove(i);
                System.out.println("Contatto rimosso: " + nome);
                return;
            }
        }
        System.out.println("Contatto non trovato: " + nome);
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
}

