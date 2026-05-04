package esercizio_decorator_observer_singleton;

public class LowercaseDecorator extends AbstractNotifyDecorator {

    public LowercaseDecorator(NotifyInterface notify) {
        super(notify);
    }

    @Override
    public String getContent() {
        return notify.getContent().toLowerCase();
    }

}
