package user;

import io.cucumber.messages.internal.com.google.gson.Gson;
import org.json.JSONObject;
import org.json.XML;

public class GetCatApi {

    public String image_id;
    public String sub_id;
    public int value;

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public JSONObject getJson(){
        return new JSONObject((new Gson().toJson(this)));//para transformar o objeto do tipo classe em json
    }

    public String getXml(){//para transformar xml em json
        return XML.toString(getJson());
    }



}
