import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Camera {
    private int numero;
    private boolean disponibile;

    public Camera(int numero){
        this.numero = numero;
        this.disponibile = true; // Inizialmente la camera è disponibile
    }

    public int getNumero() {
        return numero;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }
    public class SistemaPrenotazioni {
    private Map<Cliente, Prenotazioni> prenotazioni;
    private List<Camera> camereDisponibili;
public SistemaPrenotazioni() {
        this.prenotazioni = new HashMap<>();
        this.camereDisponibili = new ArrayList<>();
        // Aggiungi le camere disponibili inizialmente
        for (int i = 1; i <= 10; i++) {
            camereDisponibili.add(new Camera(i));
        }
    }

    public void effettuaPrenotazione(Cliente cliente, Camera camera, LocalDate dataInizio, LocalDate dataFine) 
    throws Exception {
        if (!camera.isDisponibile()) {
            throw new Exception("La camera " + camera.getNumero() + " non è disponibile.");
        }

        Prenotazioni nuovaPrenotazione = new Prenotazioni(cliente, camera, dataInizio, dataFine);
        prenotazioni.put(cliente, nuovaPrenotazione);
        camera.setDisponibile(false); // Occupa la camera
        System.out.println("Prenotazione effettuata per " + cliente.getNome() + " - Camera " + camera.getNumero());
    }

    public void modificaPrenotazione(Cliente cliente, Camera nuovaCamera, LocalDate nuovaDataInizio, LocalDate nuovaDataFine)
            throws Exception {
        cancellaPrenotazione(cliente); 
        effettuaPrenotazione(cliente, nuovaCamera, nuovaDataInizio, nuovaDataFine);
    }

    public void cancellaPrenotazione(Cliente cliente) {
        Prenotazioni prenotazione = prenotazioni.get(cliente);
        if (prenotazione != null) {
            Camera cameraPrenotata = prenotazione.getCamera();
            cameraPrenotata.setDisponibile(true); // Rilascia la camera
            prenotazioni.remove(cliente);
            System.out.println("Prenotazione cancellata per " + cliente.getNome());
        } else {
            System.out.println("Nessuna prenotazione trovata per " + cliente.getNome());
        }
    }
}