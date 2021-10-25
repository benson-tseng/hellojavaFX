package observer;

public interface Observer {
    void subscribe(Observable news);
    void unsubscribe();
    void update();
}
