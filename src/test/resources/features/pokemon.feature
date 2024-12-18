# language: pt

Funcionalidade: Testar a API de Pokémons
  Como um testador de API
  Eu quero verificar o comportamento dos endpoints da PokeAPI
  Para garantir que suas funcionalidades retornem dados consistentes e úteis

@graphQL
Cenário: Obter itens através de uma query GraphQL
  Dado que o endpoint GraphQL da PokeAPI está disponível
  Quando solicito a lista de itens usando a consulta GraphQL apropriada
  Então devo receber uma resposta bem-sucedida
  E essa resposta deve conter os itens com seus respectivos nomes e custos

@ditto
Cenário: Obter informações sobre o Pokémon Ditto
  Dado que o endpoint de Pokémon da PokeAPI está disponível
  Quando solicito informações sobre o Pokémon chamado "Ditto"
  Então devo receber uma resposta bem-sucedida
  E a resposta deve apresentar os dados do Pokémon Ditto

@dittoAbilities
Cenário: Verificar as habilidades do Pokémon Ditto
  Dado que o endpoint de Pokémon da PokeAPI está disponível
  Quando solicito informações sobre o Pokémon chamado "Ditto"
  Então devo receber uma resposta bem-sucedida
  E devo encontrar uma lista de habilidades associadas ao Ditto

@firstAbility
Cenário: Obter detalhes da primeira habilidade do Pokémon Ditto
  Dado que o endpoint de Pokémon da PokeAPI está disponível
  Quando solicito informações sobre o Pokémon chamado "Ditto"
  E identifico a primeira habilidade retornada para o Ditto
  Então ao solicitar detalhes sobre essa habilidade específica
  E Devo receber uma resposta bem-sucedida
  E essa resposta deve conter informações completas sobre a habilidade consultada

@firstAbilityAlternate
Cenário: Obter detalhes da primeira habilidade do Pokémon Ditto por outro método de identificação
  Dado que o endpoint de Pokémon da PokeAPI está disponível
  Quando solicito informações sobre o Pokémon chamado "Ditto"
  E determino a primeira habilidade por meio de sua posição na lista de habilidades
  Então ao consultar detalhes dessa habilidade específica
  E Devo receber uma resposta bem-sucedida
  E essa resposta deve apresentar as informações da habilidade solicitada

@allAbilities
Cenário: Consultar individualmente todas as habilidades do Pokémon Ditto
  Dado que o endpoint de Pokémon da PokeAPI está disponível
  Quando solicito informações sobre o Pokémon chamado "Ditto"
  Então devo receber uma lista completa de suas habilidades
  E ao consultar individualmente cada habilidade presente na lista
  E Devo receber, para cada habilidade, uma resposta bem-sucedida com seus detalhes

@allAbilitiesFlavorText
Cenário: Consultar as habilidades do Pokémon Ditto e verificar descrições em espanhol
  Dado que o endpoint de Pokémon da PokeAPI está disponível
  Quando solicito informações sobre o Pokémon chamado "Ditto"
  Então devo obter a lista de suas habilidades
  E ao consultar cada habilidade individualmente
  E Devo receber uma resposta bem-sucedida com o nome da habilidade
  E os textos descritivos (flavor texts) disponíveis em espanhol
