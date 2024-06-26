public class Prenotazioni {
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



  
