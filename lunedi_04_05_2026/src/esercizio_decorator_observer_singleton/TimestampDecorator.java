package esercizio_decorator_observer_singleton;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampDecorator extends AbstractNotifyDecorator {

    public TimestampDecorator(NotifyInterface notify) {
        super(notify);
    }

    @Override
    public String getContent() {
        ZonedDateTime timestamp = ZonedDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss z");
        return "[ " + timestamp.format(fmt) + " ] " + notify.getContent();
    }

}
