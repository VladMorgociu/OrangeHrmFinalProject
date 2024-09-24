package objectData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NegativeLogInObject extends GeneralObject{

    private String usernameValue;
    private String passwordValue;
    private String expectedAlertMessage;

    public NegativeLogInObject(String filePath){
        fromJsonToObject(filePath);
    }


}
