import java.time.LocalDate;

public class Prenotazioni {
    private Cliente cliente;
    private Camera camera;
    private LocalDate dataInizio;
    private LocalDate dataFine;

    public Prenotazioni (Cliente cliente, Camera camera, LocalDate dataInizio, LocalDate dataFine) {
        this.cliente = cliente;
        this.camera = camera;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Camera getCamera() {
        return camera;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    private boolean[] posti;

    public Prenotazioni (int numPosti){
        this.posti= new boolean[numPosti];
    }
    

    public boolean Prenota(int posto){
        if(posto<0 || posto>= posti.length){
            throw new IllegalArgumentException("Posti non validi");
        }
        if(!posti[posto]){
            posti[posto]=true;
            return true;
        }else{
            return false;
        }
    }

    public boolean annullaPrenotazione (int posto){
        if(posto<0 || posto>= posti.length){
            throw new IllegalArgumentException("Posti non validi");
        }
        if(posti[posto]){
           posti[posto]=false;
           return true;
        }else{
            return false;
        }
    }
    public boolean isDisponibile(int posto){
        if(posto<0 || posto>= posti.length){
            throw new IllegalArgumentException("Posti non validi");
        }
        return !posti[posto];
    }
    public boolean sonoPostiDisponibili(int[] postiDaVerificare) {
        for (int posto : postiDaVerificare) {
            if (posto < 0 || posto >= posti.length) {
                throw new IllegalArgumentException("Numero di posto non valido: " + posto);
            }
            if (posti[posto]) {
                return false;
            }
        }
        return true;
    }
}



  
