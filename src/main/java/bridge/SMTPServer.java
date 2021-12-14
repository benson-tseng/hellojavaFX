package bridge;

public interface SMTPServer {
    void setInfo(String from, String pass, String to, String msg);
    int send();
}
