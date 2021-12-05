package Prototype;

public abstract class Prototype {

    private String emoji;
    private Prototype prototype;
    public Prototype (){}
    public Prototype (Prototype prototype) {

        this.prototype = prototype;

    }
    public abstract void setEmoji();
    public abstract String getEmoji();
    public abstract Prototype clone();

}
