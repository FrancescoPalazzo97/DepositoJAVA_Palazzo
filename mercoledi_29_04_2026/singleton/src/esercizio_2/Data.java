package esercizio_2;

public class Data {

    private int id;
    private String content;
    private String userName;

    public Data(int id, String content, String userName) {
        this.id = id;
        this.content = content;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "[id=" + id + "] " + content + " (utente: " + userName + ")";
    }

}
