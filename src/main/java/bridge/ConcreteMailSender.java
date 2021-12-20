package bridge;

public class ConcreteMailSender extends MailSender{

    public ConcreteMailSender(SMTPServer m){
        super(m);
    }

    @Override
    public int sendMail(String from, String pass, String to, String msg) {
        smtp.setInfo(from,pass,to,msg);
        return smtp.send();
    }
}
