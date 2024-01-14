public class Main {
    public static void main(String[] args) {
        Bank kaspi = new Bank("Kaspi",0.2d,0.5d);
        Bank jusan = new Bank("Jusan",0.17d,0.5d);

        Card card1 = new Card(kaspi, TypeOfCard.DEBIT);
        Card card2 = new Card(jusan, TypeOfCard.CREDIT);

        Account account1 = new Account(1,5000 ,"Dilnaz", 20000);
        Account account2 = new Account(2,5000 ,"Lilya", 14000);

        account1.setCard(card1);
        account2.setCard(card2);

        kaspi.checkForPaymentAbilityAndGiveLoan(140000,3, account1);
        account1.payChecks(7000);
        System.out.println(account1);
        System.out.println(account2);
    }
}
