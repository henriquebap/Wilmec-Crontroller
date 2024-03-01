# Wilmec Controller

In this college project, we aim to create a comprehensive system mirroring real-world scenarios, focusing on an Integrated Product Flow and Sales/Inventory Management System. The project's primary objective is to design and implement a robust solution that effectively controls the flow of products from procurement to sales, while simultaneously managing inventory and sales data.

---

#### Endpoints

- Categorias

  - [Registro de Produto](###Registro-deProduto)
  - [Busca de Produtos](###Busca-de-Produtos)
  - [Editar Informacoes do produto](###Editar-Informações-do-Produto)
  - [Fluxo de Vendas](###Fluxo-de-Vendas)

  ***

###### Objetivo

O controlador de produtos supervisiona o registro de produtos, abrangendo campos essenciais como Id, nome, descrição, categoria, prateleira e quantidade.

---

### Registro de Produto

`POST` /produto

Registra um novo produto.

**Corpo da Requisição**

| Campo      | Tipo   | Obrigatório | Descrição                                            |
| ---------- | ------ | ----------- | ---------------------------------------------------- |
| nome       | string | ✅          | O nome do produto                                    |
| descricao  | string | ❌          | Detalhes adicionais sobre o produto                  |
| categoria  | string | ✅          | A categoria à qual o produto pertence                |
| prateleira | string | ✅          | A prateleira ou local onde o produto está armazenado |
| quantidade | int    | ✅          | A quantidade do produto em estoque                   |

```json
{
  "nome": "Produto A",
  "descricao": "Descrição do Produto A",
  "categoria": "Fluidos",
  "prateleira": "A3",
  "quantidade": 50
}
```

**Exemplo de Resposta**

```json
{
  "id": 1,
  "nome": "Produto A",
  "descricao": "Descrição do Produto A",
  "categoria": "Fluidos",
  "prateleira": "A3",
  "quantidade": 50
}
```

**Códigos de Status**

| Código | Descrição                                           |
| ------ | --------------------------------------------------- |
| 201    | Produto registrado com sucesso                      |
| 400    | Erro de validação - verifique o corpo da requisição |

---

### Busca de Produto

`GET` /produto

Busca produtos por código, nome e prateleira.

**Parâmetros da Consulta**

- `codigo` (Opcional): Código do produto a ser procurado.
- `nome` (Opcional): Nome do produto a ser procurado.
- `prateleira` (Opcional): Localização do produto na prateleira.

**Exemplo de Resposta**

```json
[
  {
    "id": 1,
    "nome": "Produto A",
    "descricao": "Descrição do Produto A",
    "categoria": "Fluidos",
    "prateleira": "A3",
    "quantidade": 50
  },
  {
    "id": 2,
    "nome": "Produto B",
    "descricao": "Descrição do Produto B",
    "categoria": "Pecas",
    "prateleira": "B2",
    "quantidade": 30
  }
]
```

**Códigos de Status**

| Código | Descrição                                                 |
| ------ | --------------------------------------------------------- |
| 200    | Dados recuperados com sucesso                             |
| 404    | Nenhum produto encontrado com base nos critérios de busca |

---

### Editar Informações do Produto

`PUT` /produto/{id}

Edita as informações do produto com o `id` especificado.

**Corpo da Requisição**

| Campo      | Tipo   | Obrigatório | Descrição                                     |
| ---------- | ------ | ----------- | --------------------------------------------- |
| nome       | string | ✅          | O nome atualizado do produto                  |
| descricao  | string | ❌          | Detalhes atualizados sobre o produto          |
| categoria  | string | ✅          | A categoria atualizada do produto             |
| prateleira | string | ✅          | A prateleira ou local atualizado do produto   |
| quantidade | int    | ✅          | A quantidade atualizada do produto em estoque |

```json
{
  "nome": "Produto A Atualizado",
  "descricao": "Descrição do Produto A Atualizada",
  "categoria": "Filtros",
  "prateleira": "A4",
  "quantidade": 60
}
```

**Exemplo de Resposta**

```json
{
  "id": 1,
  "nome": "Produto A Atualizado",
  "descricao": "Descrição do Produto A Atualizada",
  "categoria": "Filtros",
  "prateleira": "A4",
  "quantidade": 60
}
```

**Códigos de Status**

| Código | Descrição                                            |
| ------ | ---------------------------------------------------- |
| 200    | Informações do produto atualizadas com sucesso       |
| 400    | Falha na validação - verifique o corpo da requisição |
| 404    | Id do produto não encontrado                         |

---

#### Excluir Produto

`DELETE` /produto/{id}

Exclui o produto com o `id` especificado.

**Códigos de Status**

| Código | Descrição                    |
| ------ | ---------------------------- |
| 204    | Produto excluído com sucesso |
| 404    | Id do produto não encontrado |

---

### Fluxo de Vendas

**Fluxo de vendas neste modelo e somente uma ideia**

O módulo de fluxo de vendas exibe as entradas e saídas de transações de vendas e produtos.

#### Transações de Vendas

`GET` /vendas

Retorna uma lista de transações de vendas, incluindo detalhes dos produtos vendidos e quantidades.

**Exemplo de Resposta**

```json
[
  {
    "idTransacao": 1,
    "timestamp": "2024-03-01T12:00:00Z",
    "produtos": [
      {
        "idProduto": 1,
        "nomeProduto": "Produto A Atualizado",
        "quantidade": 5
      },
      {
        "idProduto": 2,
        "nomeProduto": "Produto B",
        "quantidade": 2
      }
    ]
  },
  {
    "idTransacao": 2,
    "timestamp": "2024-03-02T14:30:00Z",
    "produtos": [
      {
        "idProduto": 1,
        "nomeProduto": "Produto A Atualizado",
        "quantidade": 3
      }
    ]
  }
]
```

**Códigos de Status**

| Código | Descrição                              |
| ------ | -------------------------------------- |
| 200    | Dados recuperados com sucesso          |
| 404    | Nenhuma transação de vendas encontrada |
