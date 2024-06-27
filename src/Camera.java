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
    public class Cliente {
        private String nome;
    
        public Cliente(String nome) {
            this.nome = nome;
        }
    
        public String getNome() {
            return nome;
        }
    public class Prenotazioni{
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
    throws CameraNonDisponibileException {
        if (!camera.isDisponibile()) {
            throw new CameraNonDisponibileException("La camera " + camera.getNumero() + " non è disponibile.");
        }

        Prenotazioni nuovaPrenotazione = new Prenotazioni(cliente, camera, dataInizio, dataFine);
        prenotazioni.put(cliente, nuovaPrenotazione);
        camera.setDisponibile(false); // Occupa la camera
        System.out.println("Prenotazione effettuata per " + cliente.getNome() + " - Camera " + camera.getNumero());
    }

    public void modificaPrenotazione(Cliente cliente, Camera nuovaCamera, LocalDate nuovaDataInizio, LocalDate nuovaDataFine)
            throws CameraNonDisponibileException {
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

    public static void main(String[] args) {
        SistemaPrenotazioni sistema = new SistemaPrenotazioni();

        Cliente cliente1 = new Cliente("Mario Rossi");
        Cliente cliente2 = new Cliente("Luigi Verdi");

        Camera camera1 = sistema.camereDisponibili.get(0);
        Camera camera2 = sistema.camereDisponibili.get(1);

        try {
            sistema.effettuaPrenotazione(cliente1, camera1, LocalDate.of(2024, 7, 1), LocalDate.of(2024, 7, 5));
            sistema.effettuaPrenotazione(cliente2, camera2, LocalDate.of(2024, 7, 3), LocalDate.of(2024, 7, 6));

            sistema.modificaPrenotazione(cliente1, camera2, LocalDate.of(2024, 7, 1), LocalDate.of(2024, 7, 4));

            sistema.cancellaPrenotazione(cliente2);
        } catch (CameraNonDisponibileException e) {
            System.out.println("Errore durante la prenotazione: " + e.getMessage());
        }
    }
}
    }
}
