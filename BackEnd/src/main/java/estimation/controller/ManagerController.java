package estimation.controller;

import estimation.bean.Manager;
import estimation.bean.User;
import estimation.service.ManagerService;
import estimation.service.RequirementService;
import estimation.service.UserService;
import estimation.Util.MD5Util;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : MianHong Li
 * @date : 2018/1/14
 */
@RestController
@RequestMapping(value = "/estimation")
public class ManagerController {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    ManagerService managerService;

    @Autowired
    RequirementService requirementService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/identity")
    public Object judgeIdentity(HttpServletRequest request){
        Map<String, Object> result = new HashMap<>();
        System.out.println(request);
        try{
            String username = requirementService.getAccount(request);
            if(username != null){
                if(managerService.judgeIdentity(username)){
                    result.put("code",0);
                }
                else if(userService.judgeIdentity(username)) {
                    result.put("code", 1);
                }
            }
            else {
                result.put("code", 200);
            }
        }
        catch(Exception e){
            result.put("code", 500);
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping(value = "/add")
    public Object addManager(@RequestBody JSONObject jsonObject){
        Map<String, Object> result = new HashMap<>();
        try{
            Manager manager = new Manager();
            manager.setUsername(jsonObject.getString("username"));
            manager.setPassword(jsonObject.getString("password"));
            if(managerService.add(manager)) {
                result.put("code", 0);
            }
            else {
                result.put("code", 200);
            }
        }
        catch(Exception e){
            result.put("code", 500);
        }
        return result;
    }

    @PostMapping(value = "/delete")
    public Object deleteManager(@RequestBody JSONObject jsonObject){
        Map<String, Object> result = new HashMap<>();
        try{
            String username = jsonObject.getString("username");
            if(managerService.delete(username)) {
                result.put("code", 0);
            }
            else {
                result.put("code", 200);
            }
        }
        catch(Exception e){
            result.put("code", 500);
        }
        return result;
    }

    @GetMapping(value = "/getAll")
    public Object getAll(){
        Map<String, Object> result = new HashMap<>();
        try{
            List<Manager> managers = managerService.getAll();
            if(managers != null) {
                List<String> names = new ArrayList<>();
                for(Manager manager : managers){
                    names.add(manager.getUsername());
                }
                result.put("list", names);
                result.put("code", 0);
            }
            else {
                result.put("code", 200);
            }
        }
        catch(Exception e){
            result.put("code", 500);
        }
        return result;
    }

    @PostMapping(value = "/login")
    public Object login(@RequestBody JSONObject jsonObject){
        Map<String, Object> result = new HashMap<>();
        try{
            String username = jsonObject.getString("username");
            String password = MD5Util.md5(jsonObject.getString("password"));
            Manager manager=managerService.findManager(username);
            User user = userService.findUser(username);
            String email,phone;
            //用户身份是管理员
            if(manager!=null){
                if(!(MD5Util.md5(manager.getPassword()).equals(password))){
                    result.put("status",1);
                    return result;
                }
                email=manager.getEmail();
                phone=manager.getPhone();
            }
            //用户身份是普通用户
            else if(user!=null){
                if(!(MD5Util.md5(user.getPassword()).equals(password))){
                    result.put("status",1);
                    return result;
                }
                email=user.getEmail();
                phone=user.getPhone();
            }
            else {
                result.put("status", 0);
                return result;
            }

            String tokenId = MD5Util.md5(password+username+System.currentTimeMillis());
            stringRedisTemplate.opsForValue().set(tokenId,username);
            result.put("status", 200);
            Map<String, Object> myMap = new HashMap<>();
            myMap.put("tokenid",tokenId);
            myMap.put("realname","");
            myMap.put("mobile",phone);
            myMap.put("email",email);
            result.put("result",myMap);
        }
        catch(Exception e){
            result.put("status", 500);
        }
        return result;
    }

    @PostMapping(value = "/logout")
    public Object login(HttpServletRequest httpServletRequest){
        Map<String,Object> result=new HashMap<>();
        try{
            Boolean s=requirementService.removeAccount(httpServletRequest);
            if(s){
                result.put("status",200);
            }
            else {
                result.put("status", 0);
            }
        }
        catch (Exception e){
            result.put("status",500);
        }
        return result;
    }

    @PostMapping("/update")
    public Object updateManager(@RequestBody JSONObject jsonObject) {
        Map<String, Object> result = new HashMap();
        try{
            String username = jsonObject.getString("name");
            Manager manager = managerService.findManager(username);
            String email = jsonObject.getString("email");
            String phone = jsonObject.getString("mobile");
            managerService.update(manager, phone, email);
            result.put("status",200);
        }
        catch (Exception e){
            result.put("status",500);
        }
        return result;
    }
}
