import java.util.ArrayList;
import java.util.List;


public class ElencoTelefonico {

    List<Contatto> elenco = null;

    public ElencoTelefonico() {

        elenco = new ArrayList<>();
    }

    public void aggiungiContatto(Contatto c) {

        elenco.add(c);
    }

    public void rimuoviContatto(Contatto c) {

        elenco.remove(c);
    }

    public List<Contatto> findContact(String data) {

        data = data.toLowerCase();

        List<Contatto> res = new ArrayList<>();
        for (Contatto c : elenco)
            if (c.getNome().toLowerCase().contains(data)
                    || c.getNumTel().contains(data))
                res.add(c);

        return res;
    }

    @Override
    public String toString() {

        return elenco.toString();
    }
}

