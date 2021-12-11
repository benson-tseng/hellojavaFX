package Prototype;

public class EmojiPrototype implements Cloneable{

    private String emoji;

    public String getEmoji(){
        return emoji;
    }

    public void setEmoji(String emoji) {this.emoji = emoji;}

    public Object clone() throws CloneNotSupportedException{

        EmojiPrototype clone = (EmojiPrototype) super.clone();

        return clone;
    }
}

