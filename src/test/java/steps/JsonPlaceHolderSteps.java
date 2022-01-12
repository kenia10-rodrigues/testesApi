package steps;

import api.ApiHeaders;
import api.ApiParams;
import api.ApiRequests;
import com.github.javafaker.Faker;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import user.GetPlace;
import utils.JsonUtils;
import utils.PropertiesUtils;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class JsonPlaceHolderSteps extends ApiRequests {

    PropertiesUtils prop = new PropertiesUtils();
    JsonUtils jsonUtils = new JsonUtils();
    ApiHeaders apiHeaders = new ApiHeaders();
    Faker faker = new Faker();
    ApiParams apiParams = new ApiParams();
    GetPlace getPlace = new GetPlace();



    @Dado("que possuo um token jsonPlaceHolder válido")
    public void quePossuoUmTokenJsonPlaceHolderVálido() {
        System.out.println("Não necessita de Token");

    }

    @Quando("eu enviar uma requisicao deste usuário")
        public void envio_um_request_com_dados_válidos() throws IOException {
            super.url = prop.getProp("url_jsonplaceholder");
            super.GET();

    }
    @Então("os dados do usuário desta api devem ser retornados")
    public void os_dados_do_usuário_desta_api_devem_ser_retornados() {
          assertEquals("1",response.jsonPath().getString("id"));
//        assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit",response.jsonPath().getString("title"));
//        assertEquals("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto",response.jsonPath().getString("body"));

  }

    @Então("o status code da requisição deve ser {int}")
    public void o_status_code_da_requisição_deve_ser(Integer statusEsperado) {
        assertEquals(statusEsperado, response.statusCode(), "Status code diferente do esperado!!");
    }

}
