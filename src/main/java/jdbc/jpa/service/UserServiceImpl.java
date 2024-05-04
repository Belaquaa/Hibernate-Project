package jdbc.jpa.service;

import jdbc.jpa.dao.UserDao;
import jdbc.jpa.dao.UserDaoJDBCImpl;
import jdbc.jpa.dao.UserDaoHibernateImpl;
import jdbc.jpa.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoHibernateImpl();

    //UserDao userDao = new UserDaoJDBCImpl();
    public void createUsersTable() {
        userDao.createUsersTable();
    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
        System.out.println("User saved " + name + " " + lastName + " " + age);
    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        List<User> users = userDao.getAllUsers();
        for (User user : users) System.out.println(user);
        return users;
    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}
