package estimation.service;

import estimation.DAO.ProjectExperienceDAO;
import estimation.bean.ProjectExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wjq
 */
@Service
public class ProjectExperienceService {
    @Autowired
    private ProjectExperienceDAO projectExperienceDAO;

    public List<ProjectExperience> findAll(String userid){
        return projectExperienceDAO.getAll(userid);
    }

    public Boolean add(ProjectExperience projectExperience){
        try{
            projectExperienceDAO.add(projectExperience);
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public Boolean delete(String id){
        try{
            projectExperienceDAO.delete(id);
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public Boolean modify(ProjectExperience projectExperience){
        try{
            projectExperienceDAO.save(projectExperience);
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
