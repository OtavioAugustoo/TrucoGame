import java.util.ArrayList;
import java.util.Collections;

public class Baralho  {
    
    private ArrayList<Carta> baralho;
    private Carta manilha;
    
    Baralho(){
        this.baralho = new ArrayList<>();
        this.montaBaralho();
        Collections.shuffle(this.baralho);
        this.manilha = this.darCarta();
        System.out.println("Manilha:"+this.manilha.getValor()+" Naipe: "+this.manilha.getNaipe()+" Forca:"+this.manilha.getForca());
        this.setManilha();
    }

    private void setManilha(){
        if (this.manilha.getForca()!=10) {
            for (Carta c:this.baralho){
                if (this.manilha.getForca()+1== c.getForca()){
                    c.setManilha(c);
                } 
            }
        }else {
            for (Carta c:this.baralho){
                if(1==c.getForca()){
                    c.setManilha(c);
                }
            }
        }
    }
    private void montaBaralho(){
        String [] valor = {"4","5","6","7","Q","J","K","A","2","3"};
        String [] naipe = {"ouros","espada","copa","paus"};
        int forca = 1;
        for(String v:valor){
            for(String n:naipe){
                this.baralho.add(new Carta(v,n,forca));
            }
            forca++;
        }
     } 
     public Carta darCarta() {
        verificaBaralho(); 
        return this.baralho.remove(0);
    }

    public void verificaBaralho() {
        if (this.baralho.isEmpty()) {
            System.out.println("O baralho está vazio. Remontando...");
            this.montaBaralho();
            Collections.shuffle(this.baralho); 
        }
    }
    public ArrayList<Carta> getBaralho(){
        return this.baralho;
    }
    
    public void embaralhar() {
        Collections.shuffle(baralho);
    }
}
