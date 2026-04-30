package esempio_observer_1;

import java.util.ArrayList;
import java.util.List;

public class Subject implements I_Subject {
    private List<I_Observer> observers = new ArrayList<>();
    private String state;

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    public void registerObserver(I_Observer a) {
        observers.add(a);
    }

    public void removeObserver(I_Observer a) {
        observers.remove(a);
    }

    @Override
    public void notifyObservers() {
        for (I_Observer o : observers) {
            o.update(state);
        }
    }
}
