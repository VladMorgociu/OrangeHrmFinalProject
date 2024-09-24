package objectData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserManagementObject extends GeneralObject{

    private String usernameValue;
    private String passwordValue;
    private String confirmPWValue;
    private String expectedMessage;
    private String employeeName;


    public UserManagementObject  (String filePath){
        fromJsonToObject(filePath);
    }

}
