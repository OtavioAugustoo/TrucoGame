

public class Carta {
    private String valor;
    private String naipe;
    private int forca;
    Carta (String valor, String naipe, int forca){
        this.valor= valor;
        this.naipe= naipe;
        this.forca= forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getForca() {
        return forca;
    }

    public String getValor() {
        return valor;
    }
    
    public String getNaipe() {
        return naipe;
    }
    public void setManilha(Carta c){
        switch (naipe) {
            case "ouros":
                this.setForca(11);
                break;
            case"espada":
                this.setForca(12);
                break;
            case "copa":
                this.setForca(13);
                break;
            case "paus":
                this.setForca(14);
                break;
            default:
                break;
        }
    }
    
   

    @Override  
    public String toString(){
        return "Valor: " + this.getValor() + " || Naipe: " + this.getNaipe() + " || Força: " + this.forca;
    }
}
