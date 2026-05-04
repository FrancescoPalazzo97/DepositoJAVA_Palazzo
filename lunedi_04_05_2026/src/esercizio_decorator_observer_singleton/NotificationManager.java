package esercizio_decorator_observer_singleton;

import java.util.ArrayList;

public class NotificationManager {
    private static NotificationManager istance;
    private ArrayList<User> users = new ArrayList<>();
    private String currentMessage;

    private NotificationManager() {
    }

    public static NotificationManager getIstance() {
        if (istance == null) {
            istance = new NotificationManager();
        }

        return istance;
    }

    public void newNotify(String notify) {
        this.currentMessage = notify;
        notifyUsers();
    }

    public String getCurrentMessage() {
        return currentMessage;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean removeUser(User user) {
        return users.remove(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void notifyUsers() {
        for (User user : users) {
            user.notifyUser();
        }
    }
}
