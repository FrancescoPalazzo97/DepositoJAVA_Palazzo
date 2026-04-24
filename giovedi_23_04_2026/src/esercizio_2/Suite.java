package esercizio_2;

public class Suite extends Room {

    private String extraServices;

    public Suite() {
        super();
        this.extraServices = "No extra services available";
    }

    public Suite(String extraServices) {
        super();
        this.extraServices = extraServices;
    }

    public Suite(int number, float price) {
        super(number, price);
        this.extraServices = "No extra services available";
    }

    public Suite(int number, float price, String extraServices) {
        super(number, price);
        this.extraServices = extraServices;
    }

    public String getExtraServices() {
        return this.extraServices;
    }

    public void setExtraServices(String extraServices) {
        this.extraServices = extraServices;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Extra Services: " + getExtraServices());
    }

    @Override
    public void printDetails(boolean showPrice) {
        super.printDetails(showPrice);
        System.out.println("Extra Services: " + getExtraServices());
    }

}
