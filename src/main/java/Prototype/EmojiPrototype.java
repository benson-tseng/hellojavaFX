package Prototype;

public class EmojiPrototype implements Cloneable{

    private String emoji;

    public String getEmoji(){
        return emoji;
    }

    public void setEmoji(String emoji) {this.emoji = emoji;}

    //Clone the Prototype and return clone;
    public Object clone() throws CloneNotSupportedException{

        EmojiPrototype clone = (EmojiPrototype) super.clone();

        return clone;
    }
}

