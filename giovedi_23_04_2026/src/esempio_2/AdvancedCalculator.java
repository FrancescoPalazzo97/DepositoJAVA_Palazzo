package esempio_2;

public class AdvancedCalculator extends Calculator {

    @Override
    public int add(int a, int b) {
        int sum = a + b;
        System.out.println(sum);
        return sum;
    }

    @Override
    public double add(double a, double b) {
        double sum = a + b;
        System.out.println(sum);
        return sum;
    }

}
