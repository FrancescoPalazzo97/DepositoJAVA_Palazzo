package esercizio_observer_1;

import java.util.ArrayList;

public class WeatherStation {
    private ArrayList<I_Display> displays = new ArrayList<>();
    private float state;

    public void setState(float state) {
        this.state = state;
        notifyDisplays();
    }

    public void addDisplay(I_Display d) {
        displays.add(d);
    }

    public void removeDisplay(I_Display d) {
        displays.remove(d);
    }

    public void notifyDisplays() {
        for (I_Display d : displays) {
            d.update(state);
        }
    }
}
