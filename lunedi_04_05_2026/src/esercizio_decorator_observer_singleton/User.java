package esercizio_decorator_observer_singleton;

import java.util.List;

public class User implements ObserverInterface {
    private String name;
    private List<String> decoratorPreferences;

    public User(String name, List<String> decoratorPreferences) {
        this.name = name;
        this.decoratorPreferences = decoratorPreferences;
    }

    public String getName() {
        return name;
    }

    public List<String> getDecoratorPreferences() {
        return decoratorPreferences;
    }

    @Override
    public void notifyUser() {
        String message = NotificationManager.getIstance().getCurrentMessage();
        NotifyInterface notify = new Notify(message);

        for (String pref : decoratorPreferences) {
            switch (pref) {
                case "uppercase":
                    notify = new UppercaseDecorator(notify);
                    break;
                case "lowercase":
                    notify = new LowercaseDecorator(notify);
                    break;
                case "timestamp":
                    notify = new TimestampDecorator(notify);
                    break;
            }
        }

        System.out.println(name + ": " + notify.getContent());
    }

}
