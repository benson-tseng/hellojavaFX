package bridge;

public abstract class MailSender {
    abstract public int sendMail(String from, String pass, String to, String msg);
}
