package user;

import com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;
import org.json.JSONObject;
import org.json.XML;

@Data
@Builder
public class UsersLombok {

        private String email;
        private String gender;
        private String name;
        private String status;


        public JSONObject getJson(){ //método para gerar Json
            return new JSONObject((new Gson().toJson(this)));
        }

        public String getxml(){  //método para gerar XML
            return XML.toString(getJson());
        }
    }

