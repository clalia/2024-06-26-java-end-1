import java.util.HashMap;
import java.util.Map;

public class Candidato {
    private String nome;
    private int voti;

    public Candidato(String nome){
        this.nome=nome;
        this.voti=0;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public int getVoti(){
        return voti;
    }
    public void setVoti(int voti){
        this.voti=voti;
    }
    public void VotiRicevuti(){
        voti++;
    }
    public class Elettore{
        private String nome;
        private boolean haVotato;

        public Elettore(String nome) {
            this.nome = nome;
            this.haVotato = false;
        }
    
        public String getNome() {
            return nome;
        }
    
        public boolean haVotato() {
            return haVotato;
        }
    
        public void setHaVotato(boolean haVotato) {
            this.haVotato = haVotato;
        }
    }
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
}
