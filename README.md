# WMGestor

O **WMGestor** é uma aplicação fullstack desenvolvida para o cadastro e gerenciamento de categorias e produtos. O projeto utiliza **Spring Boot** no backend e **Vue.js** no frontend, incorporando diversas tecnologias modernas para oferecer uma solução robusta e eficiente.

## Funcionalidades Principais

- **Cadastro de Categorias**: Permite a criação, edição e exclusão de categorias de produtos.
- **Cadastro de Produtos**: Facilita a gestão de produtos associados às categorias, incluindo operações de CRUD (Create, Read, Update, Delete).
- **Autenticação e Autorização**: Implementa segurança utilizando **Spring Security** com **JWT (JSON Web Token)**, garantindo acesso seguro às funcionalidades da aplicação.

## Tecnologias Utilizadas

### Backend

- **Spring Boot**: Framework para construção de aplicações Java.
- **Spring Data JPA**: Facilita a interação com o banco de dados.
- **Spring Security**: Fornece recursos de autenticação e autorização.
- **JWT (JSON Web Token)**: Utilizado para autenticação stateless.
- **MySQL**: Banco de dados relacional utilizado para persistência dos dados.

### Frontend

- **Vue.js**: Framework progressivo para construção de interfaces de usuário.
- **Axios**: Cliente HTTP baseado em Promises para realizar requisições assíncronas.
- **Vuex**: Gerenciamento de estado centralizado para aplicações Vue.js.
- **Bootstrap 4**: Biblioteca de componentes responsivos para estilização da aplicação.
- **SCSS**: Pré-processador CSS que adiciona funcionalidades como variáveis e aninhamento.

## Estrutura do Repositório

- **wmgestor-api/**: Contém o código-fonte do backend desenvolvido com Spring Boot.
- **wmgestor-ui/**: Contém o código-fonte do frontend desenvolvido com Vue.js.

## Pré-requisitos

- **Java 8 ou superior**: Necessário para executar o backend.
- **Node.js**: Requerido para o ambiente de desenvolvimento do frontend.
- **MySQL**: Banco de dados para armazenar as informações da aplicação.

## Configuração e Execução

### Backend

1. **Configurar o Banco de Dados**: Atualize as credenciais do MySQL no arquivo `application.properties` localizado em `wmgestor-api/src/main/resources/`.

2. **Construir e Executar a Aplicação**:
   ```bash
   cd wmgestor-api
   mvn clean install
   java -jar target/wmgestor-api.jar
   ```

   A API estará disponível em `http://localhost:8080/`.

### Frontend

1. **Instalar as Dependências**:
   ```bash
   cd wmgestor-ui
   npm install
   ```

2. **Executar o Servidor de Desenvolvimento**:
   ```bash
   npm run serve
   ```

   A aplicação estará disponível em `http://localhost:8081/`.

## Licença

Este projeto está licenciado sob a licença MIT.

