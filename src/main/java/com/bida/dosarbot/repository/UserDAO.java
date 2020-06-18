package com.bida.dosarbot.repository;

import com.bida.dosarbot.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserDAO {

    private EntityManager entityManager;

    public UserDAO(){
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-test");
            entityManager = entityManagerFactory.createEntityManager();
        } catch (Exception e){
            System.out.println("ERROR with DB(PASSWORD, USERNAME)");
            System.exit(1);
        }
    }

    public void save(User user) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println("ERROR with Write User!");
        }
    }

    public List<User> selectAllEntity(){
        List<User> users = null;
        try {
            EntityManager entityManager = getEntityManager();
            users = (List<User>) entityManager.createQuery("select t from " + User.class.getSimpleName() + " t").getResultList();
            entityManager.close();
        } catch (Exception e) {
            System.out.println("ERROR with read all Users!");
        }
        return users;
    }

    public User selectUserByYearAndDosarNumber(int year, int dosarNumber){
        User user = null;
        try {
            EntityManager entityManager = getEntityManager();
            user = (User) entityManager.createNativeQuery(selectByYearAndDosarNumber, User.class)
                    .setParameter("year", year)
                    .setParameter("dosarNumber", dosarNumber)
                    .getSingleResult();
            entityManager.close();
        }catch (Exception e){
            System.out.println("ERROR with select user by id and number of dosar!");
        }
        return user;
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }

    private String selectByYearAndDosarNumber = "select * from users " +
            "where year = :year and dosar_number = :dosarNumber";
}
