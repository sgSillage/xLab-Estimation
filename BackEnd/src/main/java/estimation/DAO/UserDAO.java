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
        mongoTemplate.insert(user, "user");
    }

    public void delete(String username){
        Query query = new Query(Criteria.where("username").is(username));
        mongoTemplate.findAllAndRemove(query, User.class, "user");
    }

    public void save(User user) { mongoTemplate.save(user,"user"); }

    public List<User> getAll(){
        return mongoTemplate.findAll(User.class, "user");
    }
}
