package hibernate.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "bank_card")
    private int bankCard;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BankCard> bankCards;

    public void addBankCard(BankCard bankCard){
        bankCard.setUser(this);
        bankCards.add(bankCard);
    }
    public void removeBankCard(BankCard bankCard){
        bankCards.remove(bankCard);
    }

    public User() {
    }

    public User(String name, int bankCard) {
        this.name = name;
        this.bankCard = bankCard;
        bankCards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBankCard() {
        return bankCard;
    }

    public void setBankCard(int bankCard) {
        this.bankCard = bankCard;
    }

    public List<BankCard> getBankCards() {
        return bankCards;
    }

    public void setBankCards(List<BankCard> bankCards) {
        this.bankCards = bankCards;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bankCard=" + bankCard +
                ", bankCards=" + bankCards +
                '}';
    }
}
