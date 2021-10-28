package State;

public class Context {

    private State state;

    public Context() {
        this.state = new EditState();
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }


}
