package estimation.controller;

import estimation.bean.Manager;
import estimation.bean.User;
import estimation.service.ManagerService;
import estimation.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/estimation")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ManagerService managerService;

    @PostMapping(value = "/account/register")
    public Object register(@RequestBody JSONObject jsonObject){
        Map<String, Object> result = new HashMap<>();
        try{
            String username = jsonObject.getString("username");
            String email = jsonObject.getString("email");
            String password = jsonObject.getString("password");
            if(userService.judgeIdentity(username)){
                result.put("status",0);
                return result;
            }
            User user=new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            userService.add(user);
            result.put("status",200);
        }
        catch(Exception e){
            result.put("status", 500);
        }
        return result;
    }

    @PostMapping("/account/update")
    public Object updateUser(@RequestBody JSONObject jsonObject) {
        Map<String, Object> result = new HashMap();
        try{
            String username = jsonObject.getString("name");
            User user = userService.findUser(username);
            Manager manager = managerService.findManager(username);
            String email = jsonObject.getString("email");
            String phone = jsonObject.getString("mobile");
            if(user!=null){
                userService.update(user, phone, email);
            }
            else{
                managerService.update(manager, phone, email);
            }
            result.put("status",200);
        }
        catch (Exception e){
            result.put("status",500);
        }
        return result;
    }
}
