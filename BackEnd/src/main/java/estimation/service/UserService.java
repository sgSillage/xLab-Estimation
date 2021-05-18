package estimation.service;

import estimation.DAO.UserDAO;
import estimation.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public Boolean judgeIdentity(String username){
        List<User> users = userDAO.getAll();
        for(User user : users){
            if(user.getUsername().equals(username)){
                return true;
            }
        }

        return false;
    }

    public User findUser(String username){
        List<User> users = userDAO.getAll();
        for(User user : users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }

        return null;
    }

    public Boolean add(User user){
        String id = String.valueOf(System.currentTimeMillis());
        user.setUserId(id);
        try {
            userDAO.add(user);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public Boolean delete(String username){
        try {
            userDAO.delete(username);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public List<User> getAll(){
        try {
            return userDAO.getAll();
        }
        catch (Exception e){
            return null;
        }
    }

    public Boolean update(User user, String phone, String email){
        try{
            user.setPhone(phone);
            user.setEmail(email);
            userDAO.save(user);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
