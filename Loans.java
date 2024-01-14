public class Loans {
    private int years;
    private double amount;

    private double monthlyPayment;

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Loans{" +
                "years=" + years +
                ", amount=" + amount +
                ", monthlyPayment=" +  String.format("%.4f", monthlyPayment) +
                '}';
    }
}
