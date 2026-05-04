package esercizio_decorator_observer_singleton;

public abstract class AbstractNotifyDecorator implements NotifyInterface {
    protected NotifyInterface notify;

    public AbstractNotifyDecorator(NotifyInterface notify) {
        this.notify = notify;
    }
}
