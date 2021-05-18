package estimation.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author wjq
 */
@Data
@ToString
@Document(collection = "user")
public class User {
    @Id
    private String userId;

    private String username;

    private String password;

    private String email;

    private String phone;

}
