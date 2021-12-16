package Prototype;

import java.util.HashMap;
import java.util.Map;

public class Emoji {
    private Map<String, EmojiPrototype> prototypes = new HashMap<String, EmojiPrototype>();
    public void addPrototype(String emoji, EmojiPrototype prototype){
        prototypes.put(emoji,prototype);
    }

    //Return the Prototype which the button click
    public EmojiPrototype getPrototype(String Emoji) throws CloneNotSupportedException {
        return (EmojiPrototype) prototypes.get(Emoji).clone();
    }
}
