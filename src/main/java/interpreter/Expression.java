package interpreter;

public interface Expression {
    public boolean interpret(String expression,IContext context);
}
