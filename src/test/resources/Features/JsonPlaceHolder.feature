# language: pt
# Authora: KR
# Data: 03/01/2022
# Version: 1.0
# Encoding: UTF-8

@JsonPlaceHolder
Funcionalidade: Criar e editar contas de usuários
  Eu como Administrador do sistema, quero cadastrar, editar e excluir usuários no sistema

@getPlace
Cenario: Buscar um usuário existente na API JsonPlaceHolder
  Dado que possuo um token jsonPlaceHolder válido
  Quando eu enviar uma requisicao deste usuário
  Então os dados do usuário desta api devem ser retornados
  E o status code da requisição deve ser 200

