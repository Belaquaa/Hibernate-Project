package jdbc.jpa.service;

import jdbc.jpa.dao.UserDao;
import jdbc.jpa.dao.UserDaoJDBCImpl;
import jdbc.jpa.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoJDBCImpl();

    public void createUsersTable() {
        userDao.createUsersTable();
    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        System.out.println("User saved " + name + " " + lastName + " " + age);
        userDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        for (User user : userDao.getAllUsers()) {
            System.out.println(user);
        }
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}
