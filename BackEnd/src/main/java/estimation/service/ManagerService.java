package estimation.service;

import estimation.DAO.ManagerDAO;
import estimation.bean.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author : MianHong Li
 * @date : 2018/1/14
 */
@Service
public class ManagerService {
    @Autowired
    ManagerDAO managerDAO;

    public Boolean judgeIdentity(String username){
        List<Manager> managers = managerDAO.getAll();
        for(Manager manager : managers){
            if(manager.getUsername().equals(username)){
                return true;
            }
        }

        return false;
    }

    public Manager findManager(String username){
        List<Manager> managers = managerDAO.getAll();
        for(Manager manager : managers){
            if(manager.getUsername().equals(username)){
                return manager;
            }
        }

        return null;
    }

    public Boolean add(Manager manager){
        String id = String.valueOf(System.currentTimeMillis());
        manager.setId(id);
        try {
            managerDAO.add(manager);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public Boolean delete(String username){
        try {
            managerDAO.delete(username);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public List<Manager> getAll(){
        try {
            return managerDAO.getAll();
        }
        catch (Exception e){
            return null;
        }
    }

    public Boolean update(Manager manager, String phone, String email){
        try{
            manager.setPhone(phone);
            manager.setEmail(email);
            managerDAO.save(manager);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
