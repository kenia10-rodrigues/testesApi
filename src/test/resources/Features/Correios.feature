# language: pt
# Author: Kenia
# Version: 1.0
# encoding: UTF-8

  @regressivo
Funcionalidade: Calcular o valor do frete
  A fim de calcular o valor do frete
  Eu como usuário da API dos correios envio request com dados de origem e destino e características da embalagem
  Para saber o valor do frete e tempo de entrega

  @frete
  Cenario: Calcular o valor do frete com dados válidos
    Dado que possuo um token válido
    Quando envio um request com dados válidos
    Então o valor do frete deve ser calculado
    E o status code do deve ser 200

    @freteDataTable
    Cenário: Calcular o valor do frete com os dados válidos usando DataTable
      Dado que possuo um token válido
      Quando envio um request com dados válidos DataTable
      | sCepOrigem | sCepDestino | nVlPeso | nVlComprimento | nVlAltura | VlLargura |
      | 74371520   | 1327000     | 3.00    |  40.00         | 20.00     | 12.00     |
      Então o valor do frete deve ser "40,60"
      E o status code do deve ser 200
