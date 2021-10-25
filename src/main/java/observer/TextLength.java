package observer;

import java.util.ArrayList;

public class TextLength implements Observable{
    private ArrayList<Observer> observerList = new ArrayList<Observer>();

    // add a observer
    @Override
    public void register(Observer reader) {
        observerList.add(reader);
    }

    // remove a observer
    @Override
    public void unregister(Observer reader) {
        observerList.remove(reader);
    }

    // notify all the observer
    @Override
    public void inform() {
        for(Observer reader : observerList){
            reader.update();
        }
    }
}
