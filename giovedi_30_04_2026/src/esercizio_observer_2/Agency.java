package esercizio_observer_2;

import java.util.ArrayList;

public class Agency {
    ArrayList<I_Investor> investors = new ArrayList<>();

    private String stockActionName;
    private double stockActionValue;

    public Agency(String stockActionName, double stockActionValue) {
        this.stockActionName = stockActionName;
        this.stockActionValue = stockActionValue;
    }

    public void updateStockAction(String newName, double newValue) {
        stockActionName = newName;
        stockActionValue = newValue;
        notifyInvestors();
    }

    public void addInvestor(I_Investor inv) {
        investors.add(inv);
    }

    public void removeInvestor(I_Investor inv) {
        investors.remove(inv);
    }

    public void notifyInvestors() {
        for (I_Investor inv : investors) {
            inv.notifyInvestor(stockActionName, stockActionValue);
        }
    }
}
