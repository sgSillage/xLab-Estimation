package estimation.DAO;

import estimation.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {
    @Autowired
    MongoTemplate mongoTemplate;

    public void add(User user){
        mongoTemplate.insert(user,"user");
    }

    public boolean identify(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        Query query = new Query(Criteria.where("username").is(username));
        User queryResult = mongoTemplate.find(query, User.class, "user").get(0);
        return password.equals(queryResult.getPassword());
    }

}
