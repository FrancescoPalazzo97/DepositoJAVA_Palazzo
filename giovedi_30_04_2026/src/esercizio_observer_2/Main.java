package esercizio_observer_2;

public class Main {
    public static void main(String[] args) {
        Agency agency = new Agency("UBD", 100);

        Investor i1 = new Investor("Francesco");
        Investor i2 = new Investor("Daniele");

        agency.addInvestor(i2);
        agency.updateStockAction("ASD", 54.44);

        agency.addInvestor(i1);
        agency.updateStockAction("ASD", 32.45);
    }
}
