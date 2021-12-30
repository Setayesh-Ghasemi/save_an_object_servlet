package ir.maktab58.session.service;

import ir.maktab58.session.dao.UserDao;
import ir.maktab58.session.entity.User;
import ir.maktab58.session.service.validator.UserAndPassValidator;

public class UserService {
    private final UserDao userDao = new UserDao();

    public int saveNewUser(String username, String password) {
        UserAndPassValidator instance = UserAndPassValidator.getInstance();
        boolean userAndPassValid = instance.isUserAndPassValid(username, password);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (userAndPassValid)
            return userDao.save(user);
        return 0;
    }
}
