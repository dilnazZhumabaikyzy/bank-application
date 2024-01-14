public class Card {
    private Bank bank;
    private TypeOfCard typeOfCard;

    public Card(Bank bank, TypeOfCard typeOfCard) {
        this.bank = bank;
        this.typeOfCard = typeOfCard;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public TypeOfCard getTypeOfCard() {
        return typeOfCard;
    }

    public void setTypeOfCard(TypeOfCard typeOfCard) {
        this.typeOfCard = typeOfCard;
    }

}
