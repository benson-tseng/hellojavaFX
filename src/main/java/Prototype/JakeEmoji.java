package Prototype;

public class JakeEmoji extends Prototype {

    private String emoji;

    public JakeEmoji(){}
    public JakeEmoji(JakeEmoji jakeEmoji){
        super(jakeEmoji);
        this.setEmoji();
    }

    public void setEmoji() {
        this.emoji ="＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　１１１１１１１１１１１１１１１１１１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　１１１　　　１１１１１　　　　　　　　　　１１１１１　　　１１１　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　　１１　　　１１　　　　　　　　１１　　　１１　　　　１１１　　　　　　　１１　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　１１　　　　　１１　１１１１　１１　　　　　１１　　　１１１　　　　　　１１　１１　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　　１１　　　１１１１　　　　１１１１　　　１１　　　　１１１　　　　　　１１　　　１１　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　　　１１１１１　　　１１１１　　　１１１１１　　　　１１１　　　　　　１１　　　　１１　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　１１１　　　　　　１１　　１１　１１　１１　　１１　　　　　　１１１　　　　１１　　　　　　１１　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　１１１　　　　　１１　　１１１１　　１１１１　　１１　　　　　１１１　　１１　　　　１１１１　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　１１１１１　　　　１１　　１１　　　１１　　　１１　　１１　　　　１１１１１　　　　１１　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　１１　　　　　　　　　　１１１　　　　　　　　　　　　１１１　　　　　　　　　　　　１１　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　１１　　　　１１１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１１１　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　１１　　　　１１　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　１１　　　１１　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　１１　　　１１　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　１１　　　１１１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　１１　　　１１１１　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　１１　　１１１１　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１　　１１１　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　１１１　　　　　　　１１１１１１　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　１１１　　　１１　　　　　　１１　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　　１１　　　　　１１　　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　　１１　　　　　１１　　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　　１１１１１　　　　　　　　１１１１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊\n" ;

    }

    public String getEmoji() {
        return this.emoji;
    }

    @Override
    public Prototype clone() {
        return new JakeEmoji(this);
    }
}