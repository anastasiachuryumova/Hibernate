package hibernate.services;

import hibernate.dao.UserDao;
import hibernate.model.BankCard;
import hibernate.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private UserDao usersDao = new UserDao();
    public UserService(){
    }
    public User findUser(int id){
        return usersDao.findById(id);
    }
    public void saveUser(User user){
        usersDao.save(user);
    }
    public void deleteUser(User user){
        usersDao.delete(user);
    }
    public void updateUser(User user){
        usersDao.update(user);
    }
    public List<User> findAllUsers(){
        return usersDao.findAll();
    }
    public BankCard findBankCardById(int id){
        return usersDao.findBankCardById(id);
    }
}
