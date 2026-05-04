package esercizio_decorator_observer_singleton;

public class Notify implements NotifyInterface {
    private String content;

    public Notify(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return this.content;
    }

}
