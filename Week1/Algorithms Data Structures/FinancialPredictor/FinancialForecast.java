public class FinancialForecast {
    public static double futureValueRecursive(double v0, double r, int n) {
        if (n == 0) {
            return v0;  // Base case
        }
        return (1 + r) * futureValueRecursive(v0, r, n - 1);
    }

    // Iterative optimization
    public static double futureValueIterative(double v0, double r, int n) {
        for (int i = 0; i < n; i++) {
            v0 *= (1 + r);
        }
        return v0;
    }

    public static void main(String[] args) {
        double initialValue = 1000;
        double growthRate = 0.05;
        int years = 5;

        System.out.println("Future Value (Recursive): " +
                futureValueRecursive(initialValue, growthRate, years));
        System.out.println("Future Value (Iterative): " +
                futureValueIterative(initialValue, growthRate, years));
    }
}
