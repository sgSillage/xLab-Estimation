package estimation.DAO;

import estimation.bean.ProjectExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wjq
 */
@Repository
public class ProjectExperienceDAO {
    @Autowired
    MongoTemplate mongoTemplate;

    public void add(ProjectExperience experience){ mongoTemplate.insert(experience,"experiences"); }

    public void delete(String id){
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.findAllAndRemove(query, ProjectExperience.class, "experiences");
    }

    public void save(ProjectExperience experience) { mongoTemplate.save(experience,"experiences"); }

    public List<ProjectExperience> getAll(String userid) {
        Query query = new Query(Criteria.where("userid").is(userid));
        return mongoTemplate.find(query,ProjectExperience.class,"experiences");
    }
}
