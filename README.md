# Sobre este Projeto

API para manutenção de laboratórios e exames.

## Funcionalidades
- Laboratórios
	- Cadastrar um novo laborário;
	- Obter uma lista de laboratórios ativos;
	- Atualizar um laboratório existente;
	- Remover logicamente um laboratório ativo;
- Exames
	- Cadastrar um novo exame;
	- Obter uma lista de exames ativos;
	- Atualizar um exame existente;
	- Remover logicamente um exame ativo.
- Associação:
  - Associa um exame ativo à um laboratório ativo;

## Algumas Informções técnicas
### Técnologias
- **Java**: JDK 1.8
- **SPRING BOOT**: versão 2.3.4.RELEASE
- **Swagger**: versão 2.9.2
- **JUnit**: versão 5
- **Build tool**: Maven versão 3.6.3

## Camadas

![Diagrama de Sequência](https://github.com/byhammert/manutencao-laboratorios-exames/blob/master/src/main/resources/img/diagrama_sequencia.png)

### Controller

Responsável por receber as requisições HTTP. Realiza conversões e validações de dados.

### Use case

Contém um método público chamado  `executar`  referente a uma regra de negócio.

### Infrastructure

Responsável por intermediar os acessos aos dados, seja por meio de Repository ou API.

### Repository In Memory

Executa operações de leitura/escrita em memória. 


### URLS para testes com Swagger
Desenvolvimento
```
	http://localhost:8080/swagger-ui.html#/
```


## Quick Start!

### Rodando em Desenvolvimento

#### Requecitos
Para executar este projeto, em desenvolvimento, você apenas precisará ter o **Java jdk 1.8** e o **maven 3.6.3** configurado na sua máquina. 

### Instalando e Executando a Aplicação
Cloning o Repository
```
	$ git clone https://github.com/byhammert/manutencao-laboratorios-exames.git
	$ cd manutencao-laboratorios-exames
```
Instale as dependências
```
	$ mvn install
```
Execute os testes unitários
```
	$ mvn test
```
Execute a aplicação
```
	$ mvn spring-boot:run
```
## Como Usar a API

### Cadastrando um novo laboratório:
#### Método da requisição HTTP
- POST
#### Request
Sobre os campos de request

- nome: recebe valores alfanuméricos;
- endereço:  recebe valores alfanuméricos;
- exames: recebe uma lista de valores alfanuméricos;


Campos Obrigatórios:
- nome

Exemplo de request
```json
	{
		"endereco": "Rua do Laboratório",
		"nome": "Nome do Laboratório",
		"exames": []
	}
```
#### Response
Retorana o laboratório cadastrado.

##### Sobre os campos de response

- id: é um valor alfanumérico que identifica o laboratório;
- nome: é um valor alfanumérico;
- endereço:  é um valor alfanumérico;
- status: é um valor alfanumérico;
- exames: é uma lista de valores alfanuméricos;

Exemplo de response
```json
	{
		"id": "a68be5b7ac1f4faca7a15dc736ede0c7",
		"nome": "Nome do Laboratório",
		"endereco": "Rua do Laboratório",
		"status": "ATIVO",
		"exames": []
	}
```

### Cadastrando um novo exame:
#### Método da requisição HTTP
- POST
#### Request
Sobre os campos de request

- nome: recebe valor alfanumérico;
- tipoExame: recebe valor alfanumérico que deve ser: IMAGEM ou ANALISE_CLINICA;
- laboratorios: recebe uma lista de valores alfanuméricos;


Campos Obrigatórios:
- nome
-  tipoExame

Exemplo de request
```json
	{
		"nome": "Nome do Exame",
		"tipoExame": "IMAGEM",
		"laboratorios": []
	}
```
#### Response
Retorana o exame cadastrado.

##### Sobre os campos de response

- id: é um valor alfanumérico que identifica o exame;
- nome: é um valor alfanumérico;
- tipoExame:  é um valor alfanumérico;
- status: é um valor alfanumérico;
- laboratorios: é uma lista de valores alfanuméricos;

Exemplo de response
```json
	{
		"id": "530bec1317e048e997db2d179ebdccd4",
		"nome": "test",
		"tipoExame": "IMAGEM",
		"status": "ATIVO",
		"laboratorios": []
	}
```
### Consultando uma lista de laboratório:
#### Método da requisição HTTP
- GET
#### Request
Não tem.
#### Response
Retorana uma lista de laboratório.

##### Sobre os campos de response

- id: é um valor alfanumérico que identifica o laboratório;
- nome: é um valor alfanumérico;
- endereço:  é um valor alfanumérico;
- status: é um valor alfanumérico;
- exames: é uma lista de valores alfanuméricos;

Exemplo de response
```json
	[
		{
		"id": "a68be5b7ac1f4faca7a15dc736ede0c7",
		"nome": "Nome do Laboratório",
		"endereco": "Rua do Laboratório",
		"status": "ATIVO",
		"exames": []
		}
	]
```

### Consultando uma lista de exame:
#### Método da requisição HTTP
- GET
#### Request
Não tem.
#### Response
Retorana uma lista de exame.

##### Sobre os campos de response

- id: é um valor alfanumérico que identifica o exame;
- nome: é um valor alfanumérico;
- tipoExame:  é um valor alfanumérico;
- status: é um valor alfanumérico;
- laboratorios: é uma lista de valores alfanuméricos;

Exemplo de response
```json
	[
		{
		"id": "530bec1317e048e997db2d179ebdccd4",
		"nome": "Nome do Exame",
		"tipoExame": "IMAGEM",
		"status": "ATIVO",
		"laboratorios": []
		}
	]
```

### Alterando um laboratório:
#### Método da requisição HTTP
- PUT
#### Request
Sobre os campos de request

- id: recebe valor alfanumérico que identifica o laboratório;
- nome: recebe valor alfanumérico;
- endereço: recebe valor alfanumérico;
- status:  recebe valor alfanumérico que deve ser: ATIVO ou INATIVO;
- exames: recebe uma lista de valores alfanuméricos que identifica os exames;


Campos Obrigatórios:
- id
- nome
- status

Exemplo de request
```json
	{
		"id": "28b87e584ba743ceb2203effd03d3d2f",
		"nome": "Nome do Laboratório",
		"endereco": "Rua do Laboratório",
		"status": "ATIVO",
		"exames": [
			"530bec1317e048e997db2d179ebdccd4"
		]
	}
```
#### Response
Retorana o laboratório alterado.

##### Sobre os campos de response

- id: é um valor alfanumérico que identifica o laboratório;
- nome: é um valor alfanumérico;
- endereço:  é um valor alfanumérico;
- status: é um valor alfanumérico;
- exames: é uma lista de valores alfanuméricos;

Exemplo de response
```json
	{
		"id": "28b87e584ba743ceb2203effd03d3d2f",
		"nome": "Nome do Laboratório",
		"endereco": "Rua do Laboratório",
		"status": "ATIVO",
		"exames": [
			"530bec1317e048e997db2d179ebdccd4"
		]
	}
```

### Alterando um exame:
#### Método da requisição HTTP
- PUT
#### Request
Sobre os campos de request
- id: é um valor alfanumérico que identifica o exame;
- nome: recebe valor alfanumérico;
- tipoExame: recebe valor alfanumérico que deve ser: IMAGEM ou ANALISE_CLINICA;
- status:  recebe valor alfanumérico que deve ser: ATIVO ou INATIVO;
- laboratorios: recebe uma lista de valores alfanuméricos;

Campos Obrigatórios:
- id
- nome
- tipoExame
- status

Exemplo de request
```json
	{
		"id": "530bec1317e048e997db2d179ebdccd4",
		"nome": "test",
		"tipoExame": "IMAGEM",
		"status": "ATIVO",
		"laboratorios": [
			"28b87e584ba743ceb2203effd03d3d2f"
		]
	}
```
#### Response
Retorana o exame alterado.

##### Sobre os campos de response

- id: é um valor alfanumérico que identifica o exame;
- nome: é um valor alfanumérico;
- tipoExame:  é um valor alfanumérico;
- status: é um valor alfanumérico;
- laboratorios: é uma lista de valores alfanuméricos;

Exemplo de response
```json
	{
		"id": "530bec1317e048e997db2d179ebdccd4",
		"nome": "test",
		"tipoExame": "IMAGEM",
		"status": "ATIVO",
		"laboratorios": [
			"28b87e584ba743ceb2203effd03d3d2f"
		]
	}
```
### Deletando um laboratório:
#### Método da requisição HTTP
- DELETE
#### Request
Sobre os campos de request

- id: é um valor alfanumérico que identifica o laboratório;

Campos Obrigatórios:
- id

Exemplo de request
```
	[HOST]/api/laboratorio/ef61f5cc5869494992e2447ae747f594
```
#### Response
```
	Retorno http status code 204 No Content
```
### Deletando um exame:
#### Método da requisição HTTP
- DELETE
#### Request
Sobre os campos de request

- id: é um valor alfanumérico que identifica o exame;

Campos Obrigatórios:
- id

Exemplo de request
```
	[HOST]/api/exame/530bec1317e048e997db2d179ebdccd4
```
#### Response
Retorno http status code 204 No Content

