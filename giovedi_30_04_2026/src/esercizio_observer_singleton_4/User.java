package esercizio_observer_singleton_4;

public class User implements I_Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void notify(Post p) {
        System.out.println("[ " + name + " ]: Ha ricevuto una nuova notifica per il nuovo post");
        System.out.println(p.getContent());
        System.out.println(p.getDate());
    }

}
