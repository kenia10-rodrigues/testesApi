package steps;

import api.ApiHeaders;
import api.ApiParams;
import api.ApiRequests;
import com.github.javafaker.Faker;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.hamcrest.Matchers;
import org.junit.Assert;
import user.GetCatApi;
import user.UsersLombok;
import utils.JsonUtils;
import utils.PropertiesUtils;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;

public class CatApiSteps extends ApiRequests {

    PropertiesUtils prop = new PropertiesUtils();
    JsonUtils jsonUtils = new JsonUtils();
    ApiHeaders apiHeaders = new ApiHeaders();
    Faker faker = new Faker();
    GetCatApi getCatApi = new GetCatApi();
    private java.lang.Object Object;
    ApiParams apiParams = new ApiParams();


    @Dado("que possuo api key")
    public void quePossuoApiKey() throws IOException{
        key = (prop.getProp("apikey"));

    }

     @Quando("envio uma requisição para a api")
    public void envioUmaRequisiçãoParaAApi() throws IOException {
         super.url = prop.getProp("url_catapi");
        super.headers = apiHeaders.CatApi(key);

      getCatApi.setImage_id("asf2");
      getCatApi.setSub_id("my-user-1234");
      getCatApi.setValue(1);
        super.body = getCatApi.getJson();

         super.POST();
    }

    @Então("deve ser criado o voto")
    public void deveSerCriadoOVoto() {
       assertEquals("SUCCESS", response.jsonPath().getString("message"));


    }

    @E("o status da requisição deve ser {int}")
    public void oStatusDaRequisiçãoDeveSer(Integer statusEsperado) {
        assertEquals(statusEsperado, response.statusCode(), "Status code diferente do esperado!!");
    }

    @Então("deve ser excluído o voto")
    public void deveSerExcluídoOVoto() {
        assertEquals("INVALID_DATA", response.jsonPath().getString("message"));
    }

    @Quando("envio a requisição para excluir")
    public void envioARequisiçãoParaExcluir() throws IOException {

       super.url = prop.getProp("url_deletar");
        super.headers = apiHeaders.CatApiDelete(key);

        super.DELETE();
    }
}
