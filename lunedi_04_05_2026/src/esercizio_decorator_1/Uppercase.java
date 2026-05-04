package esercizio_decorator_1;

public class Uppercase extends MessageDecorator {

    public Uppercase(MessageInterface message) {
        super(message);
    }

    @Override
    public String getContent() {
        return message.getContent().toUpperCase();
    };

}
