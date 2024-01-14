public class Account {
    private int id;
    private double currenMoneyAmount;

    private String ownerName;

    private Card card;

    private Loans loans;
    private double salary;

    public Account(int id, double currenMoneyAmount, String ownerName, double salary) {
        this.id = id;
        this.currenMoneyAmount = currenMoneyAmount;
        this.ownerName = ownerName;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Loans getLoans() {
        return loans;
    }

    public void setLoans(Loans loans) {
        this.loans = loans;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void deposit(double amount){
        currenMoneyAmount += amount;
    }

    public void withdraw(double amount){
        if(!this.card.getTypeOfCard().equals(TypeOfCard.CREDIT)){
            currenMoneyAmount -= amount;
            return;
        }
        if(amount * 1.03 > currenMoneyAmount){
            System.out.println("The operation cannot be performed. There is not enough money in the account.");
            return;
        }
    }

    public void payChecks(double amount){
     double monthlyPayment = this.loans.getMonthlyPayment();
     if (amount <= monthlyPayment){
         System.out.println("The operation cannot be performed. There is not enough money to pay.");
         return;
     }
     if(amount > currenMoneyAmount){
            System.out.println("The operation cannot be performed. There is not enough money in the account.");
            return;
     }

     this.currenMoneyAmount -= amount;
     double newLoansAmount = loans.getAmount() - amount;
     loans.setAmount(newLoansAmount);
    }
    public void transfer(double amount, Account sendToAccount){
        if(amount > currenMoneyAmount){
            System.out.println("The operation cannot be performed. There is not enough money in the account.");
            return;
        }
        currenMoneyAmount -= amount;
        double finalSendingAccountAmount = sendToAccount.getCurrenMoneyAmount() + amount;
        sendToAccount.setCurrenMoneyAmount(finalSendingAccountAmount);
        System.out.println("Operation succeed. Total amount on account: " + currenMoneyAmount+"T");
    }

    public void checkBankToTransfer(double amount, Account accontToSend){
        if(this.card.getBank().equals(accontToSend.getCard().getBank())){
            transfer(amount, accontToSend);
            return;
        }
        System.out.printf("Preparing to send %.2f$ from %d to %d account%n", amount, this.id, accontToSend.getId());

        if(amount + 150 > currenMoneyAmount){
            System.out.println("The operation cannot be performed. There is not enough money in the account.");
            return;
        }
        this.currenMoneyAmount = this.currenMoneyAmount - amount - 150;
        double secondAccountMoney = accontToSend.currenMoneyAmount + 150;
        accontToSend.setCurrenMoneyAmount(secondAccountMoney);
        System.out.printf("%f$ successfully sent. Account balance: $%f.", amount, this.currenMoneyAmount);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCurrenMoneyAmount() {
        return currenMoneyAmount;
    }

    public void setCurrenMoneyAmount(double currenMoneyAmount) {
        this.currenMoneyAmount = currenMoneyAmount;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", currenMoneyAmount=" + currenMoneyAmount +
                ", ownerName='" + ownerName + '\'' +
                ", card=" + card +
                ", loanAmount=" + loans +
                ", salary=" + salary +
                '}';
    }
}
