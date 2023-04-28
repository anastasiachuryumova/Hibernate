package hibernate.controller;

import hibernate.dao.UserDao;
import hibernate.model.BankCard;
import hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/findUserById/{id}")
    public User findById (int id){
        return userDao.findById(id);
    }

    @PostMapping("/saveUser")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user){
        userDao.save(user);
    }

    @PutMapping ("/updateUser")
    public void update(@RequestBody User user){
        userDao.update(user);
    }

    @DeleteMapping("/deleteUser")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody User user){
        userDao.delete(user);
    }

    @GetMapping("/findCardById/{cardId}")
    public BankCard findBankCardById(int id){
        return userDao.findBankCardById(id);
    }
    @GetMapping("/findAllUsers")
    public java.util.List<User> findAll(){
        return userDao.findAll();
    }
}
