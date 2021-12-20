package bridge;

public abstract class MailSender {

    SMTPServer smtp;

    public MailSender(SMTPServer smpt){
        this.smtp = smpt;
    }

    abstract public int sendMail(String from, String pass, String to, String msg);
}
