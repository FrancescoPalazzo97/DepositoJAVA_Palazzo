package esercizio_observer_singleton_4;

import java.util.ArrayList;

public class NotificationManager {
    private static NotificationManager istance;
    ArrayList<User> users = new ArrayList<>();
    private Post post;

    private NotificationManager() {
    }

    public static NotificationManager getIstance() {
        if (istance == null) {
            istance = new NotificationManager();
        }

        return istance;
    }

    public void addNewPost(Post p) {
        this.post = p;
        notifyUsers();
    }

    public void addUser(User u) {
        users.add(u);
    }

    public boolean removeUser(String name) {
        return users.removeIf(u -> u.getName().equals(name));
    }

    public void notifyUsers() {
        for (User u : users) {
            u.notify(post);
        }
    }
}
