package hibernate.dao;

import hibernate.model.BankCard;
import hibernate.model.User;
import hibernate.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class UserDao {
    public User findById (int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }
    public void save(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        session.evict(user);
        tx1.commit();
        session.close();
    }
    public void update(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        session.evict(user);
        tx1.commit();
        session.close();
    }
    public void delete(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        session.delete(user);
        tx1.commit();
        session.close();
    }
    public BankCard findBankCardById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(BankCard.class, id);
    }
    public List<User> findAll(){
        List<User> users = (List<User>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }
}
