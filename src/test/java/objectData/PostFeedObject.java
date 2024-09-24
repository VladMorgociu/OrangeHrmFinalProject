package objectData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostFeedObject extends GeneralObject{

    private String textToPostValue;
    private String expectedPostText;

    public PostFeedObject(String filePath){
        fromJsonToObject(filePath);}
}
