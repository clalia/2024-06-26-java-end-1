public class Elettore {
        private String nome;
        private boolean haVotato;

        public Elettore(String nome) {
            this.nome = nome;
            this.haVotato = false;
        }
    
        public String getNome() {
            return nome;
        }
        public void setNome(String nome){
            this.nome=nome;
        }
    
        public boolean haVotato() {
            return haVotato;
        }
    
        public void setHaVotato(boolean haVotato) {
            this.haVotato = haVotato;
        }
    }


