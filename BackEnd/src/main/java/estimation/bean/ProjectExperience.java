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
@Document(collection = "experiences")
public class ProjectExperience {
    @Id
    private String id;

    private String userid;

    private String projectName;

    private String projectRegion;

    private String projectAddress;

    private String projectText;
}
