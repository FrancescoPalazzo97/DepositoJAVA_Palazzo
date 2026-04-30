package esercizio_observer_2;

public class Investor implements I_Investor {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void notifyInvestor(String stockAction, double value) {
        System.out.println("[ Investore " + name + " ]: l'azione " + stockAction + " ha il seguente valore: " + value);
    }

}
