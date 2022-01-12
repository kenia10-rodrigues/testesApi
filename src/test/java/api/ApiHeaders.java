package api;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApiHeaders {


    Map<String, String> headers = new HashMap<>();

    public Map<String, String> gorestHearders (String token) {
        headers.put("Authorization", token);
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        return headers;
    }


    public Map<String, String> JsonPlaceHolderHeaders() {
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        return headers;
    }

    public Map<String, String> gorestHeaders(String token) {
        headers.put("Authorization", token);
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        return headers;
        }

    public Map<String, String> CatApi(String apiKey) {
        headers.put("Authorization", apiKey);
        headers.put("Content-Type", "application/json");
        headers.put("x-api-key", "{$$.env.x-api-key}");
        return headers;
    }

    public Map<String, String> CatApiDelete(String apiKey) {
        headers.put("Authorization", apiKey);
        headers.put("Content-Type", "application/json");
        headers.put("x-api-key", "DEMO-API-KEY");
    //    headers.put()
//        headers.put("image_id", "asf2");
        return headers;
    }
}
