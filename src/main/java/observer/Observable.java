package observer;

public interface Observable {
    public void register(Observer reader);
    public void unregister(Observer reader);
    public void inform();
}
