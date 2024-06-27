
import java.util.ArrayList;

public class RegistroStudenti {
    private ArrayList<String> nome;
    private ArrayList<Integer> matricola;
    private ArrayList<Integer> voti;

    public RegistroStudenti (){
        this.nome=new ArrayList<>();
        this.matricola=new ArrayList<>();
        this.voti=new ArrayList<>();
    
        for (int i = 0; i < nome.size(); i++) {
            voti.add(0); // Assumo 0 come voto iniziale
        }
    }



    public void aggiungiVoto(int voto, int indice){
        if (voto <18 || voto>30){
            throw new IllegalArgumentException("Il voto deve essere compreso tra 18 e 30.");
        }
        if (indice < 0 || indice >= voti.size()) {
            throw new IllegalArgumentException("Indice studente non valido.");
        }
        voti.set(indice, voto);
        }

    public double calcolaMediaVoti() {
        int sum = 0;
        for (int voto : voti) {
            sum += voto;
        }
        return (double) sum / voti.size();
}
public void stampaDettagli() {
    if (nome.isEmpty() || matricola.isEmpty()) {
        System.out.println("Errore: nome o matricola non definiti.");
        return;
    }

    for (int i = 0; i < nome.size(); i++) {
        System.out.println("Nome studente: " + nome.get(i));
        if (i < matricola.size()) {
            System.out.println("Matricola: " + matricola.get(i));
        } else {
            System.out.println("Matricola: non disponibile");
        }
        if (voti.isEmpty()) {
            System.out.println("Nessun voto inserito.");
        } else {
            System.out.println("Voti:");
            for (int j = 0; j < voti.size(); j++) {
                System.out.println("Voto " + (j + 1) + ": " + voti.get(j));
            }
            System.out.println("Media dei voti: " + calcolaMediaVoti());
        }
        System.out.println();
    }
}
}
