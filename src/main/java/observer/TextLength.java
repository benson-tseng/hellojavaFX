package observer;

import java.util.ArrayList;

public class TextLength implements Observable{
    private ArrayList<Observer> observerList = new ArrayList<Observer>();

    @Override
    public void register(Observer reader) {
        observerList.add(reader);
    }

    /**
     * 取消註冊Reader
     */
    @Override
    public void unregister(Observer reader) {
        observerList.remove(reader);
    }

    /**
     * 通知全部的Reader
     */
    @Override
    public void inform() {
        for(Observer reader : observerList){
            reader.update();
        }
    }
}
