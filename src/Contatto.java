public class Contatto {
        private String nome;
        private String numTel;
    
        public Contatto(String nome, String numTel) throws IllegalArgumentException{
            this.nome=nome;
            this.numTel=numTel;
        }
        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
    
            this.nome = nome;
        }
    
        public String getNumTel() {
            return numTel;
        }
        public void setNumTel() {
            for (Character c : numTel.toCharArray())
                
                if (c < '0' || c > '9')
                    throw new IllegalArgumentException("Il numero di telefono deve contenere solo cifre");
            this.numTel=numTel;
        }
        public String toString() {
    
            return getNome() + ": " + getNumTel();
        }
}
