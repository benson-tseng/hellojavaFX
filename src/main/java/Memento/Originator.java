package Memento;

public class Originator {
    private String textstates;

    public Originator (String textstates){
        this.textstates = textstates;
    }

    //Set textstates from memento
    public void restore(Memento m){
        this.textstates = m.getText();
    }

    //Save Current Version to new Memento;
    public Memento snapshot() {
        return new Memento(textstates);
    }

    public String getTextStates(){
        return this.textstates;
    }

}
