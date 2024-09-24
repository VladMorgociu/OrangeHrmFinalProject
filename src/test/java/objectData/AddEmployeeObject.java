package objectData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddEmployeeObject extends GeneralObject{

    private String firstNameValue;
    private String lastNameValue;
    private String idValue;
    private String expectedMessage;
    private String employeeFullName;
    private String employeeFirstname;
    private String employeeLastname;

    public AddEmployeeObject (String filePath) {
        fromJsonToObject(filePath);
    }
}
