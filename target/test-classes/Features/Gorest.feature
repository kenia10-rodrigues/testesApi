# language: pt
# Authora: Kenia Rodrigues
# Version: 1.0
# Encoding: UTF-8

@Gorest
Funcionalidade: Criar e editar contas de usuários
  Eu como Administrador do sistema, quero cadastrar, editar e excluir usuários no sistema

  @post
  Cenario: Cadastrar novo usuário no API Gorest
    Dado que possuo gorest token válido
    Quando envio um resquest de cadastro de usuário com dados válidos
    Então o usuário deve ser criado corretamente
    E o status code do request deve ser 201

    @get
  Cenario: Buscar um usuário existente na API Gorest
    Dado que possuo gorest token válido
    E existe o usuário cadastrado
    Quando buscar este usuário
    Então os dados do usuário devem ser retornados
    E o status code do request deve ser 200


   @put
  Cenario: Alterar um usuário existente na API Gorest
    Dado que possuo gorest token válido
    E existe o usuário cadastrado
    Quando altero os dados do usuário
    Então os dados do usuário devem ser alterados com sucesso
    E o status code do request deve ser 200


  @patch
  Cenario: Alterar um usuário existente na API Gorest PATCH
    Dado que possuo gorest token válido
    E existe o usuário cadastrado
    Quando altero um ou mais dados do usuário
    Então os dados do usuário devem ser alterados com sucesso
    E o status code do request deve ser 200


  @delete
  Cenario: Deletar um usuário existente na API Gorest
    Dado que possuo gorest token válido
    E existe o usuário cadastrado
    Quando deleto este usuário
    Então os dados do usuário devem ser removido
    E o status code do request deve ser 204




