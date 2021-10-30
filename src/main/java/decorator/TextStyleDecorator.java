package decorator;

public abstract class TextStyleDecorator implements TextStyle{
    protected TextStyle decoratedText;

    public TextStyleDecorator(TextStyle ts){
        this.decoratedText = ts;
    }

    @Override
    public void setTextStyle(){
        decoratedText.setTextStyle();
    }
}
