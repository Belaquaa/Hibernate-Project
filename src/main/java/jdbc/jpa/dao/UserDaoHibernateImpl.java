package jdbc.jpa.dao;

import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jdbc.jpa.model.User;

public class UserDaoHibernateImpl implements UserDao {
    private final static Configuration configuration = new Configuration().configure();
    private final static SessionFactory sessionFactory = configuration.buildSessionFactory();

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String sql = "CREATE TABLE IF NOT EXISTS users (id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                         "name VARCHAR(255), lastName VARCHAR(255), age TINYINT)";
            session.createNativeQuery(sql, User.class).executeUpdate();
            transaction.commit();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery("DROP TABLE IF EXISTS users", User.class).executeUpdate();
            transaction.commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = sessionFactory.openSession()) {
            User user = new User(name, lastName, age);
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.remove(user);
            }
            transaction.commit();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM User", User.class).getResultList();
        }
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery("TRUNCATE TABLE users", User.class).executeUpdate();
            transaction.commit();
        }
    }
}