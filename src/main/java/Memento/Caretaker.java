package Memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    private List<Memento> m = new ArrayList<Memento>();
    private int curPos = 0; //k

    //Save Memento To List.
    public void addMemento(Memento memento){
       if (curPos != m.size() && curPos > 0){m = m.subList(0, curPos);}
       m.add(memento);
       curPos = m.size();
    }

    //Choose Version
    public Memento getMemento(){
        return m.get(curPos);
    }

    //Back To Previous Version
    public Memento undo(){
        curPos = Math.max(0,curPos - 2) + 1;
        Memento undoMemento = m.get(curPos - 1);
        return undoMemento;
    }

    //Cancel Back To Previous Version
    public Memento redo(){
        curPos = Math.min(m.size(), curPos + 1);
        Memento redoMemento = m.get(curPos - 1);
        return redoMemento;
    }
}
