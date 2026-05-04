package esercizio_decorator_1;

public class Message implements MessageInterface {
    String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
