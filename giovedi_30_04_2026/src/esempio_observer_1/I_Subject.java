package esempio_observer_1;

public interface I_Subject {
    void registerObserver(I_Observer a);

    void removeObserver(I_Observer a);

    void notifyObservers();
}
