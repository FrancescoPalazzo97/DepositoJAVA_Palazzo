package esercizio_decorator_1;

public class MessageDecorator implements MessageInterface {
    protected MessageInterface message;

    public MessageDecorator(MessageInterface message) {
        this.message = message;
    }

    @Override
    public String getContent() {
        return message.getContent();
    };
}
