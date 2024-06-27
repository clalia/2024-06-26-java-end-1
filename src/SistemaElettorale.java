import java.util.HashMap;
import java.util.Map;


public class SistemaElettorale {
    private Map<String, Candidato> candidati;
    private Map<String, Elettore> elettori;

    public SistemaElettorale() {
        this.candidati = new HashMap<>();
        this.elettori = new HashMap<>();
    }

    public void aggiungiCandidato(String nomeCandidato) {
        if (!candidati.containsKey(nomeCandidato)) {
            candidati.put(nomeCandidato, new Candidato(nomeCandidato));
        }
    }

    public void registraElettore(String nomeElettore) {
        if (!elettori.containsKey(nomeElettore)) {
            elettori.put(nomeElettore, new Elettore(nomeElettore));
        }
    }

    public void vota(String nomeElettore, String nomeCandidato) throws IllegalArgumentException {
        if (!elettori.containsKey(nomeElettore)) {
            throw new IllegalArgumentException("Elettore non registrato: " + nomeElettore);
        }

        if (elettori.get(nomeElettore).haVotato()) {
            throw new IllegalArgumentException("L'elettore ha già votato: " + nomeElettore);
        }

        if (!candidati.containsKey(nomeCandidato)) {
            throw new IllegalArgumentException("Candidato non esistente: " + nomeCandidato);
        }

        candidati.get(nomeCandidato).VotiRicevuti();
        elettori.get(nomeElettore).setHaVotato(true);
    }

    public void stampaRisultati() {
        System.out.println("Risultati delle elezioni:");
        for (Candidato candidato : candidati.values()) {
            System.out.println("Candidato: " + candidato.getNome() + ", Voti ricevuti: " + candidato.getVoti());
        }
    }
}

