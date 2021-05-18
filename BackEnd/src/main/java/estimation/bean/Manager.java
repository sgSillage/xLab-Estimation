package estimation.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author : MianHong Li
 * @date : 2018/1/14
 */
@Document(collection = "Manager")
public class Manager {
    @Id
    private String id;

    private String username;

    private String password;

    private String email;

    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email;}

    public void setEmail(String email) { this.email=email; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone=phone; }
}
