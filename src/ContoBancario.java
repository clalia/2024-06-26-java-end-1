public class ContoBancario {
    private double saldo;

    public ContoBancario(double saldoIniziale){
        if(saldoIniziale<0){
            throw new IllegalArgumentException("Il saldo non può essere negativo");
        }
        this.saldo=saldoIniziale;
    }
    public void deposita(double denaro){
        saldo+=denaro;
        System.out.println("Deposito effettuato: "+ denaro+ " euro");
    }
    public void preleva(double denaro){
        if(denaro> saldo){
            throw new IllegalArgumentException("Fondi insufficienti");
        }
        saldo-=denaro;
        System.out.println("Prelievo effettuato: " + denaro + " euro");
    }
    public double getSaldo(){
        return saldo;
    }



}
