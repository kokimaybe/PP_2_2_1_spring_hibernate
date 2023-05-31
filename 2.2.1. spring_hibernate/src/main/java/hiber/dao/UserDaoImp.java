package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

//   @Override
//   public User findOwner(String car_model, int car_series) {
////      String HQL = "FROM User addr WHERE addr.car.model = :car_model and addr.car.series = :car_series";
////      User user = sessionFactory.getCurrentSession().createQuery(HQL, User.class).setParameter(car_model, 1).setParameter(car_series, 2).uniqueResult();
////      return user;
//        return null;
//   }

}
