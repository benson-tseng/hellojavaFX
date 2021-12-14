package bridge;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class GoogleSMTPServer implements SMTPServer {

    String user;
    String pass;
    String to;
    String msg;

    @Override
    public void setInfo(String from, String pass, String to, String msg) {
        setTo(to);
        setMsg(msg);
        setPass(pass);
        setUser(from);
    }

    @Override
    public int send() {

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, pass);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message.setSubject("Send by JavaFX");
            message.setText(msg);

            Transport.send(message);

            return 1;

        } catch (MessagingException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
