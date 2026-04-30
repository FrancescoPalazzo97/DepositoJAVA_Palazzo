package esempio_observer_1;

public class Observer implements I_Observer {
    private String name;

    public Observer(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println(name + " ha ricevuto aggiornamento: " + msg);
    }

}
