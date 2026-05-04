package esercizio_decorator_observer_singleton;

public class UppercaseDecorator extends AbstractNotifyDecorator {

    public UppercaseDecorator(NotifyInterface notify) {
        super(notify);
    }

    @Override
    public String getContent() {
        return notify.getContent().toUpperCase();
    }

}
