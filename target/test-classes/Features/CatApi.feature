# language: pt
# Authora: Kenia
# Encoding: UTF-8
# version: 1.0

  @apiCat
Funcionalidade: Criar voto na CatApi
  A fim de criar voto na api,
  eu como usuário envio requisição para a api
  Para postar voto


  @postCatApi
  Cenário: criar voto na ApiCat
    Dado que possuo api key
    Quando envio uma requisição para a api
    Então deve ser criado o voto
    E o status da requisição deve ser 200

  @deleteCatApi
  Cenário: Excluir voto na ApiCat
    Dado que possuo api key
    Quando envio a requisição para excluir
    Então deve ser excluído o voto
    E o status da requisição deve ser 400