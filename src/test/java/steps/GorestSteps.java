package steps;

import api.ApiHeaders;
import api.ApiRequests;
import com.github.javafaker.Faker;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.cucumber.messages.internal.com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import user.UsersLombok;
import utils.JsonUtils;
import utils.PropertiesUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GorestSteps extends ApiRequests {

    PropertiesUtils prop = new PropertiesUtils();
    JsonUtils jsonUtils = new JsonUtils();
    ApiHeaders apiHeaders = new ApiHeaders();
    Faker faker = new Faker();
    UsersLombok userEnvio;



    @Dado("que possuo gorest token válido")
    public void quePossuoGorestTokenVálido() throws IOException {
       token = (prop.getProp("token_gorest"));
    }

    @Quando("envio um resquest de cadastro de usuário com dados válidos")
    public void envioUmResquestDeCadastroDeUsuárioComDadosVálidos() throws IOException, JSONException {
        super.url = prop.getProp("url_gorest");
        super.headers = apiHeaders.gorestHeaders(token);

//        super.body = jsonUtils.parseJSONFile();
//        super.body.put("email", faker.internet().emailAddress());//para criar e-mail randomico
////        super.body.put("Teste", "Teste");
//        UsersGetterSetter usersGetterSetter = new UsersGetterSetter();
//        usersGetterSetter.setEmail(faker.internet().emailAddress());
//        usersGetterSetter.setStatus("Active");
//        usersGetterSetter.setGender("Female");
//        usersGetterSetter.setName(faker.name().fullName());
//        super.body = usersGetterSetter.getJson();
          userEnvio = UsersLombok.builder()
                          .email(faker.internet().emailAddress())
                          .status("active")
                          .gender("female")
                          .name(faker.name().fullName())
                          .build();
        super.body = new JSONObject((new Gson().toJson(userEnvio)));
        super.POST();

    }

    @Então("o usuário deve ser criado corretamente")
    public void oUsuárioDeveSerCriadoCorretamente() {
//       assertEquals(body.getString("email"),response.jsonPath().getString("data.email"));
//       assertEquals(body.getString("name"),response.jsonPath().getString("data.name"));
//        assertEquals(body.getString("gender").toLowerCase(),response.jsonPath().getString("data.gender"));
//        assertEquals(body.getString("status"),response.jsonPath().getString("data.status"));
        assertEquals(userEnvio, response.jsonPath().getObject("data", UsersLombok.class),
                "Erro na comparação do Objeto." );

    }

    @E("o status code do request deve ser {int}")
    public void oStatusCodeDoRequestDeveSer(Integer statusEsperado) {
        assertEquals(statusEsperado, response.statusCode(), "Status code diferente do esperado!!");

    }

    @E("existe o usuário cadastrado")
    public void existeOUsuárioCadastrado() throws IOException {
        envioUmResquestDeCadastroDeUsuárioComDadosVálidos();
    }

    @Quando("buscar este usuário")
    public void buscarEsteUsuário() throws IOException {
        super.url = prop.getProp("url_gorest") + "/" + response.jsonPath().getJsonObject("data.id");
        super.headers = apiHeaders.gorestHeaders(token);
        super.body = new JSONObject(); //Para setar um json vazio
        super.GET();

    }

    @Então("os dados do usuário devem ser retornados")
    public void osDadosDoUsuárioDevemSerRetornados() {
        assertEquals(userEnvio, response.jsonPath().getObject("data", UsersLombok.class),
                "Erro na comparação do Objeto.");
        }

    @Quando("altero os dados do usuário")
    public void alteroOsDadosDoUsuário() throws IOException {
        super.url = prop.getProp("url_gorest") + "/" + response.jsonPath().getJsonObject("data.id");
        super.headers = apiHeaders.gorestHeaders(token);
       // super.body.put("status", "inactive");
        userEnvio.setStatus("inactive");
        userEnvio.setGender("male");
        super.body = new JSONObject((new Gson().toJson(userEnvio)));
        super.PUT();

    }

    @Então("os dados do usuário devem ser alterados com sucesso")
    public void osDadosDoUsuárioDevemSerAlteradosComSucesso() {
        assertEquals(userEnvio, response.jsonPath().getObject("data", UsersLombok.class),
                "Erro na comparação do Objeto.");
    }

    @Quando("altero um ou mais dados do usuário")
    public void alteroUmOuMaisDadosDoUsuário() throws IOException {
        super.url = prop.getProp("url_gorest") + "/" + response.jsonPath().getJsonObject("data.id");
        super.headers = apiHeaders.gorestHeaders(token);
        userEnvio.setGender("male");
        super.body = new JSONObject("{\"gender\":\"male\"}");
        super.PATCH();
    }

    @Quando("deleto este usuário")
    public void deletoEsteUsuário() throws IOException {
        super.url = prop.getProp("url_gorest") + "/" + response.jsonPath().getJsonObject("data.id");
        super.headers = apiHeaders.gorestHeaders(token);
        super.body = new JSONObject();
        super.DELETE();

    }

    @Então("os dados do usuário devem ser removido")
    public void osDadosDoUsuárioDevemSerRemovido() {
       assertEquals("", response.asString());
    }


}
