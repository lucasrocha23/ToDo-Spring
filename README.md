# Projeto ToDo
Este projeto se trata de uma API RESTful para gerenciamento de tarefas, desenvolvido em Java com Spring Boot. Nessa API os endpoints permitem que uma requisição possa adicionar tarefas, editar, apagar, visualizar todas as tarefas visualizar uma tarefa específica que estão em um banco de dados. Para esse projeto foi utilizado de forma local o SQL Server

## Pré-requisitos
- Java 17+
- Spring Boot
- SQL Server 2022 ou MySQL (local)
- GIT

## Tecnologias embarcadas
- Back-end: Java com Spring Boot
- Gerenciamento de depêndencias: Maven
- Banco de dados: SQL serve
- Versionamento de código: GIT (GitHub)

## Configuração do projeto
### Passo 1: Criar o banco de dados local com SQL server ou MYSQL
- Baixe e Instale o SQL Server Evaluation ou outra versão caso preferir. Crie um banco de dado para ser usado com esse projeto.

### Passo 2: Configurando o Java para conexão com o banco de dados
- No diretório src/main/resources do projeto, existe um arquivo application.properties, no qual serão configurados as informações de conxeção com o banco de dados:

```bash
spring.datasource.url=jdbc:sqlserver://<HOST>:1433;databaseName=<DB_NAME>;encrypt=true;trustServerCertificate=true
spring.datasource.username=<DB_USER>
spring.datasource.password=<DB_PASSWORD>
```
- Substituia os valores de <HOST>, <DB_NAME>, <DB_USER>,<DB_PASSWORD> para o valores que você configurou no passo de intalação e criação do banco de dados.

### Passo 3: Scrips de migração
- No diretório src/main/resources/db/migration há um arquivo com o script de migração que será responsável por criar a tabela de tarefas no banco de dados.
```bash
CREATE TABLE Tasks
(
    Id          bigint IDENTITY(1,1) NOT NULL,
    title       nvarchar(100) NOT NULL,
    description nvarchar(500) NULL,
    status      nvarchar(20) NOT NULL,
    created_at  datetime NOT NULL,
    version     bigint   NOT NULL,
);
```
### Passo 4: Clonar o repositório
- Através do link a seguir clone o repositótio em sua máquina local
```bash
git clone https://github.com/lucasrocha23/ToDo-Spring.git
cd ToDo-Spring
```

## Executando o projeto
### Passo 1: Compilar e excutar
- O seguinte comando do terminal compila e excuta o projeto em sua máquina
```bash
mvn spring-boot:run
A aplicação estará disponível em http://localhost:9090.
```
### Passo 2: Testando os endpoints
#### O projeto possui os seguintes endpoints:
- `GET /api/tasks` - Lista todas as tarefas
- `POST /api/tasks` - Cria uma nova tarefa
- `GET /api/tasks/{id}` - Obtém uma tarefa específica
- `PUT /api/tasks/{id}` - Atualiza uma tarefa
- `DELETE /api/tasks/{id}` - Remove uma tarefa
  
##### Para acessar os endpoints foi utilizado o Insomnia.
#### 1. POST /tasks 
- exemplo de Body:
``` bash
{
	"title": "Levar o Lixo",
	"description": "dia 03 o caminhão do lixo vai passar as 7:00 da manhã"
}
```
#### Resposta:
```bash
{
	"id": 6,
	"title": "Levar o Lixo",
	"description": "dia 03 o caminhão do lixo vai passar as 7:00 da manhã",
	"status": "pendente",
	"createdAt": "2025-06-05T21:26:13.8306881",
	"version": 0
}
```
#### 2. GET /tasks 
#### Resposta:
```bash
[
	{
		"id": 1,
		"title": "Comprar pão",
		"description": "ir comprar pão",
		"status": "pendente",
		"createdAt": "2025-06-05T18:33:09.267",
		"version": 0
	},
	{
		"id": 3,
		"title": "Comprar remédio",
		"description": "Meu pai está doente e precisa de medicação urgente",
		"status": "concluida",
		"createdAt": "2025-06-05T18:41:20.277",
		"version": 4
	},
	{
		"id": 6,
		"title": "Levar o Lixo",
		"description": "dia 03 o caminhão do lixo vai passar as 7:00 da manhã",
		"status": "pendente",
		"createdAt": "2025-06-05T21:26:13.8306881",
		"version": 0
	}
]
```
#### 3. GET /tasks/{id} 
#### Resposta:
```bash
{
	"id": 6,
	"title": "Levar o Lixo",
	"description": "dia 03 o caminhão do lixo vai passar as 7:00 da manhã",
	"status": "pendente",
	"createdAt": "2025-06-05T21:26:13.8306881",
	"version": 0
}
```
#### 4. PUT /tasks/{id} 
- exemplo de Body:
``` bash
{
	"title": "Comprar remédio",
	"description": "Meu pai está doente e precisa de medicação urgente",
	"status": "concluida"
}
```
#### Resposta:
```bash
{
	"id": 3,
	"title": "Comprar remédio",
	"description": "Meu pai está doente e precisa de medicação urgente",
	"status": "concluida",
	"createdAt": "2025-06-05T18:41:20.277",
	"version": 4
}
```
#### 5. DELETE /tasks/{id} 
