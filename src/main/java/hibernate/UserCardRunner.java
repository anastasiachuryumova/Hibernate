package hibernate;

import hibernate.model.BankCard;
import hibernate.model.User;
import hibernate.services.UserService;

import java.sql.SQLException;

public class UserCardRunner {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();
        User user = new User("John Doe", 834392639);
        userService.saveUser(user);
        userService.updateUser(user);
        User userTwo = new User("Ann Smith", 726395863);
        userService.saveUser(userTwo);
        User userThree = new User("Michael Faraday", 842746308);
        userService.saveUser(userTwo);
        BankCard oneCard = new BankCard(1, 313529575);
        oneCard.setUser(user);
        user.addBankCard(oneCard);
        BankCard twoCard = new BankCard(2, 491284684);
        twoCard.setUser(userTwo);
        userTwo.addBankCard(twoCard);
        BankCard threeCard = new BankCard(9, 774622539);
        threeCard.setUser(userTwo);
        userThree.addBankCard(threeCard);
        userService.updateUser(userTwo);
        userService.updateUser(userThree);
        User userFour = new User("James Black", 301927486);
        userService.saveUser(userFour);
        userService.updateUser(userFour);
        User userFive = new User("Selene Simon", 601298456);
        userService.saveUser(userFive);
        userService.updateUser(userFive);
    }
}
