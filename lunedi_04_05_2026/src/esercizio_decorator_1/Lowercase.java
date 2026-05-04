package esercizio_decorator_1;

public class Lowercase extends MessageDecorator {

    public Lowercase(MessageInterface message) {
        super(message);
    }

    @Override
    public String getContent() {
        return message.getContent().toLowerCase();
    };

}
