package estimation.controller;

import estimation.bean.ProjectExperience;
import estimation.service.ProjectExperienceService;
import estimation.service.RequirementService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wjq
 */
@RestController
@RequestMapping(value = "/estimation")
public class ProjectExperienceController {
    @Autowired
    private ProjectExperienceService projectExperienceService;
    @Autowired
    private RequirementService requirementService;

    @GetMapping(value = "/user/projectexperience")
    public Object findAllExperiences(HttpServletRequest request){
        Map<String,Object> result=new HashMap<>();
        try{
            String userId = requirementService.getAccount(request);
            if(userId == null){
                HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
                return new ResponseEntity<Object>("",status);
            }
            List<ProjectExperience> list=projectExperienceService.findAll(userId);
            result.put("status",200);
            result.put("data",list);
        }
        catch (Exception e){
            result.put("status",500);
        }
        return result;
    }

    @GetMapping(value = "/user/projectexperience/delete")
    public Object deleteExperiences(HttpServletRequest request, @RequestParam(value = "id") String id){
        Map<String,Object> result=new HashMap<>();
        try{
            String userId = requirementService.getAccount(request);
            if(userId == null){
                HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
                return new ResponseEntity<Object>("",status);
            }
            Boolean res=projectExperienceService.delete(id);
            if(res){
                result.put("status",200);
            }
            else{
                result.put("status",0);
            }

        }
        catch (Exception e){
            result.put("status",500);
        }
        return result;
    }

    @PostMapping(value = "/user/projectexperience/add")
    public Object addExperiences(HttpServletRequest request, @RequestBody JSONObject jsonObject){
        Map<String,Object> result=new HashMap<>();
        try{
            String userId = requirementService.getAccount(request);
            if(userId == null) {
                HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
                return new ResponseEntity<Object>("", status);
            }
            String name=jsonObject.getString("project_name");
            String region=jsonObject.getString("project_region");
            String address=jsonObject.getString("project_address");
            String text=jsonObject.getString("project_text");

            ProjectExperience experience=new ProjectExperience();
            experience.setUserid(userId);
            experience.setProjectName(name);
            experience.setProjectRegion(region);
            experience.setProjectText(text);
            experience.setProjectAddress(address);

            Boolean res=projectExperienceService.add(experience);
            if(res){
                result.put("status",200);
            }
            else{
                result.put("status",0);
            }
        }
        catch (Exception e){
            result.put("status",500);
        }
        return result;
    }

    @PostMapping(value = "/user/projectexperience/change")
    public Object modifyExperiences(HttpServletRequest request, @RequestBody JSONObject jsonObject){
        Map<String,Object> result=new HashMap<>();
        try{
            String userId = requirementService.getAccount(request);
            if(userId == null){
                HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
                return new ResponseEntity<Object>("",status);
            }

            String id=jsonObject.getString("project_id");
            String name=jsonObject.getString("project_name");
            String region=jsonObject.getString("project_region");
            String address=jsonObject.getString("project_address");
            String text=jsonObject.getString("project_text");

            ProjectExperience experience=new ProjectExperience();
            experience.setId(id);
            experience.setUserid(userId);
            experience.setProjectName(name);
            experience.setProjectRegion(region);
            experience.setProjectText(text);
            experience.setProjectAddress(address);

            Boolean res=projectExperienceService.modify(experience);
            if(res){
                result.put("status",200);
            }
            else{
                result.put("status",0);
            }

        }
        catch (Exception e){
            result.put("status",500);
        }
        return result;
    }

}
