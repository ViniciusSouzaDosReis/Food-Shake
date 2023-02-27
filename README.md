# Food-Shake

Uma API para delivery de pedidos entregues por skatistas

## Endpoints

- Usuario
  - [Cadastrar](#cadastrar-usuario)
  - [Listar Unico](#listar-um-unico-usuario)
  - [Editar](#editar-usuario)
  - [Deletar](#deletar-usuario)
- Alimento
  - [Cadastrar](#cadastrar-alimento)
  - [Listar Todos](#listar-todos-alimentos)
  - [Listar Unico](#listar-um-unico-alimento)
  - [Editar](#editar-alimento)
  - [Deletar](#deletar-alimento)
- Pedido
  - [Cadastrar](#criar-pedido)
  - [Listar Unico](#listar-unico-pedido)
  - [Editar](#editar-pedido)
  - [Deletar](#deletar-pedido)

### Cadastrar Usuario

`POST` /foodshake/api/usuario

*Campos de requisição*

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----------
|id| int| sim| numero unico de indetificação do usuario
|nome| string | sim| nome do usuario
|sobreNome| string| sim| sobre nome do usuario
|dataDeNascimento| data| sim| data de nascimento do usuario
|cpf| string| sim| cpf do usuario
|email| string| sim| email do usuario
|telefone| string| sim| telefone do usuario
|senha| string| sim| senha do usuario
|localização| object| sim| local do usuario
|favoritos| [int]| sim| lista com os id dos alimentos marcados com 'favoritos'


```js
{
    id: 1,
    nome: 'Felipe',
    sobreNome: 'Astuto',
    dataDeNascimento: '2003-01-02',
    cpf: '69035783824',
    email: 'felipemegagamerastuto@gmail.com',
    telefone: '(73) 3964-1859',
    senha: 'felipinho123',
    localizacao:{
      cep: '77420-250',
      endereco: 'Rua C',
      bairro: 'Shangri-Lá',
      numero: '321',
      complemento: 'Bloco Hilário',
      cidade: 'Gurupi',
      estado: 'Tocantins',
    }
    favoritos: [32,123,4,2,3]
}
```

*Resposta*

| código | descrição 
|--------|----------
|201| O usuairo foi cadastrada com sucesso
|400| Campos inválidos

### Listar Um Unico Usuario

`GET` /foodshake/api/usuario/{idUsuario}

```js
{
    id: 1,
    nome: 'Felipe',
    sobreNome: 'Astuto',
    dataDeNascimento: '2003-01-02',
    cpf: '69035783824',
    email: 'felipemegagamerastuto@gmail.com',
    telefone: '(73) 3964-1859',
    senha: 'felipinho123',
    localizacao:{
      cep: '77420-250',
      endereco: 'Rua C',
      bairro: 'Shangri-Lá',
      numero: '321',
      complemento: 'Bloco Hilário',
      cidade: 'Gurupi',
      estado: 'Tocantins',
    }
    favoritos: [32,123,4,2,3]
}
```

*Resposta*

| código | descrição 
|--------|----------
|200| Os dados foram retornados
|404| Não foi encontrada usuario com esse ID

### Editar Usuario

`PUT` /foodshake/api/usuario/{idUsuario}

*Campos de edição*

| campo | editavel
|-------|:-------------:
|id|  não|
|nome|  não|
|sobreNome| não|
|dataDeNascimento| não|
|cpf| não|
|email| sim|
|telefone| sim|
|senha| sim|
|localização| sim|
|favoritos| sim|

```js
{
    id: 1,
    nome: 'Felipe',
    sobreNome: 'Astuto',
    dataDeNascimento: '2003-01-02',
    cpf: '69035783824',
    email: 'felipeultragamerastuto@gmail.com',
    telefone: '(66) 3223-3513',
    senha: 'felipinhogames123',
    localizacao:{
      cep: '89050-420',
      endereco: 'Rua Wernigerode',
      bairro: 'Ponta Aguda',
      numero: '321',
      complemento: 'Bloco Hilário',
      cidade: 'Blumenau',
      estado: 'Santa Catarina',
    }
    favoritos: [32,323,4,2,3]
}
```

*Resposta*

| código | descrição 
|--------|----------
|201| Os dados foram alterados
|204| Campos vazios

### Deletar Usuario

`DELETE` /foodshake/api/usuario/{idUsuario}

*Resposta*

| código | descrição 
|--------|----------
|200| Os dados foram deletados
|204| Campos vazios

### Cadastrar Alimento

`POST` /foodshake/api/alimento

*Campos de requisição*

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----------
|id|int|sim| id unico 
|valor|float|sim| um valor positivo
|nome|string|sim| nome
|descricao|string|sim| um texto de como é o produto
|categoria|string|sim| a qual categoria pertence

*Exemplo de requisição*

```js
{
    id: 1,
    valor: 100.59,
    nome: 'X-Egg',
    descricao: 'X-Egg bem bom',
    categaria: 'Hamburger'
}
```

*Resposta*

| código | descrição 
|--------|----------
|201| o alimento foi cadastrada com sucesso
|400| campos inválidos

### Listar Um Unico Alimento

`GET` /foodshake/api/alimento/{idAlimento}

```js
{
    id: 1,
    valor: 100.59,
    nome: 'X-Egg',
    descricao: 'X-Egg bem bom',
    categaria: 'Hamburger'
}
```

*Resposta*

| código | descrição 
|--------|----------
|200| Os dados foram retornados
|404| Não foi encontrada usuario com esse ID

### Listar Todos Alimentos

`GET` /foodshake/api/alimento/

```js
{
    id: 1,
    valor: 100.59,
    nome: 'X-Egg',
    descricao: 'X-Egg bem bom',
    categaria: 'Hamburger'
}
```

*Resposta*

| código | descrição 
|--------|----------
|200| Os dados foram retornados
|404| Não foi encontrada usuario com esse ID

### Editar Alimento

`PUT` /foodshake/api/alimento/{idAlimento}

*Campos de edição*

| campo | editavel
|-------|:-------------:
|id|  não|
|valor|  sim|
|nome| sim|
|descricao| sim|
|categaria| sim|

```js
{
    id: 1,
    valor: 102.59,
    nome: 'X-Egg Duplo',
    descricao: 'X-Egg bem bom e legal',
    categaria: 'Hamburger'
}
```
*Resposta*

| código | descrição 
|--------|----------
|201| Os dados foram alterados
|204| Campos vazios

### Deletar Alimento

`DELETE` /foodshake/api/alimento/{idAlimento}

*Resposta*

| código | descrição 
|--------|----------
|200| Os dados foram deletados
|204| Campos vazios

### Criar Pedido

`POST` /foodshake/api/pedido

*Campos de requisição*

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----------
|id| int| sim| numero unico de indetificação do pedido
|idUsuario| int | sim| id do usuario que fez o pedido
|localEntrega| object| sim| local a ser entregue o pedido
|entregue| boolean| não| para saber se o pedido foi entregue
|alimentos| [string]| sim| lista de alimentos
|valor| int| sim| preço do pedido
|manobras| [object]| sim| lista de manobras a seremm feitas
|finalizado| boolean| nâo| se o pedido ja foi finalizado

```js
{
    id: 1,
    idUsuario: 1,
    localEntrega: {
      cep: '89050-420',
      endereco: 'Rua Wernigerode',
      bairro: 'Ponta Aguda',
      numero: '321',
      complemento: 'Bloco Hilário',
      cidade: 'Blumenau',
      estado: 'Santa Catarina',
    }
    entregue: false,
    alimentos:[1, 343, 32, 12]
    valor: 123,43,
    manobras:[
      manobra: {
        nomeManobra: 'Ollie',
        quantidade: 1
      },
      manobra: {
        nomeManobra: 'Hardflip',
        quantidade: 3
      }
    ],
    finalizado: true
}
```

*Resposta*

| código | descrição 
|--------|----------
|201| O pedido foi cadastrada com sucesso
|400| Campos inválidos

### Listar Unico Pedido
`GET` /foodshake/api/pedido/{idPedido}

```js
{
    id: 1,
    idUsuario: 1,
    localEntrega: {
      cep: '89050-420',
      endereco: 'Rua Wernigerode',
      bairro: 'Ponta Aguda',
      numero: '321',
      complemento: 'Bloco Hilário',
      cidade: 'Blumenau',
      estado: 'Santa Catarina',
    }
    entregue: false,
    alimentos:[1, 343, 32, 12]
    valor: 123,43,
    manobras:[
      manobra: {
        nomeManobra: 'Ollie',
        quantidade: 1
      },
      manobra: {
        nomeManobra: 'Hardflip',
        quantidade: 3
      }
    ],
    finalizado: true
}
```

*Resposta*

| código | descrição 
|--------|----------
|200| Os dados foram retornados
|404| Não foi encontrada usuario com esse ID

### Editar Pedido

`PUT` /foodshake/api/pedido/{idPedido}

*Campos de edição*

| campo | editavel
|-------|:-------------:
|id|  não|
|idUsuario|  não|
|localEntrega| não|
|entregue| sim|
|alimentos| não|
|valor| não|
|manobras| não|
|finalizado| não|

```js
{
    id: 1,
    idUsuario: 1,
    localEntrega: {
      cep: '89050-420',
      endereco: 'Rua Wernigerode',
      bairro: 'Ponta Aguda',
      numero: '321',
      complemento: 'Bloco Hilário',
      cidade: 'Blumenau',
      estado: 'Santa Catarina',
    }
    entregue: true,
    alimentos:[1, 343, 32, 12]
    valor: 123,43,
    manobras:[
      manobra: {
        nomeManobra: 'Ollie',
        quantidade: 1
      },
      manobra: {
        nomeManobra: 'Hardflip',
        quantidade: 3
      }
    ],
    finalizado: true
}
```
*Resposta*

| código | descrição 
|--------|----------
|201| Os dados foram alterados
|204| Campos vazios

### Deletar Pedido

`DELETE` /foodshake/api/pedido/{idPedido}

*Resposta*

| código | descrição 
|--------|----------
|200| Os dados foram deletados
|204| Campos vazios