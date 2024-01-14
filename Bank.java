public class Bank {
    private String name;
    private double acceptanceRate;
    private double interestRate;

    public Bank(String name, double interestRate, double acceptanceRate) {
        this.name = name;
        this.acceptanceRate = acceptanceRate;
        this.interestRate = interestRate;
    }

    public void giveLoan (double amount, int years, Account account){
        double accountMoney = account.getCurrenMoneyAmount() + amount;
        account.setCurrenMoneyAmount(accountMoney);
        double loanAmount = amount + amount * interestRate * years;
        Loans loans = new Loans();
        loans.setAmount(loanAmount);
        loans.setYears(years);
        loans.setMonthlyPayment((amount + amount * interestRate * years) / (years * 12));
        account.setLoans(loans);
    }

    public void checkForPaymentAbilityAndGiveLoan(double amount, int years, Account account){
        double monthlyPayment = (amount + amount * interestRate * years) / (years * 12);
        if(monthlyPayment > account.getSalary() * acceptanceRate){
            System.out.println("Salary is not enough for loan amount.");
            return;
        }
        giveLoan(amount, years,account);
    }

}
