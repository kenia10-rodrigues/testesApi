package steps;

import api.ApiParams;
import api.ApiRequests;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import utils.PropertiesUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CorreiosSteps extends ApiRequests {

    PropertiesUtils prop = new PropertiesUtils();
    ApiParams apiParams = new ApiParams();


    @Dado("que possuo um token válido")
    public void que_possuo_um_token_válido() {
        System.out.println("A API não requer token!");

    }
    @Quando("envio um request com dados válidos")
    public void envio_um_request_com_dados_válidos() throws IOException {
        super.url = prop.getProp("url_correios");
        super.params = apiParams.correiosParams();
        super.GET();

    }
    @Então("o valor do frete deve ser calculado")
    public void o_valor_do_frete_deve_ser_calculado() {
   assertTrue(Float.parseFloat(response.xmlPath().getString("Servicos.cServico.Valor")
            .replace(",", ".")) > 0);
    }


    @Quando("envio um request com dados válidos DataTable")
    public void envioUmRequestComDadosVálidosDataTable(DataTable dataTable) throws IOException {
        super.url = prop.getProp("url_correios");
        super.params = apiParams.setParams(dataTable.asMaps().get(0));
        super.GET();
        
    }

    @Então("o valor do frete deve ser {string}")
    public void oValorDoFreteDeveSer(String valorEsperado){
    assertEquals(valorEsperado,response.xmlPath().getString("Servicos.cServico.Valor"));
}

    @E("o status code do deve ser {int}")
    public void oStatusCodeDoDeveSer(Integer statusEsperado) {
        assertEquals(statusEsperado, response.statusCode(), "Status code diferente do esperado!!");
    }
}


