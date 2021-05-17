package estimation.service;

import estimation.DAO.UserDAO;
import estimation.bean.User;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean add(JSONObject user){
        User user1 = new User();
        user1.setId(String.valueOf(System.currentTimeMillis()));
        user1.setUsername(user.getString("username"));
        user1.setPassword(user.getString("password"));
        user1.setEmail(user.getString("email"));
        try
        {
            userDAO.add(user1);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
