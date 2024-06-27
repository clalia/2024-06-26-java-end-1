
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
}