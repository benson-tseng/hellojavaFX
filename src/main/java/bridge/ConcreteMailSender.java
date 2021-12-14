package bridge;

public class ConcreteMailSender extends MailSender{

    SMTPServer smtp;

    public ConcreteMailSender(SMTPServer m){
        smtp = m;
    }

    @Override
    public int sendMail(String from, String pass, String to, String msg) {
        smtp.setInfo(from,pass,to,msg);
        return smtp.send();
    }
}
