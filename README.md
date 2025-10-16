# 🎵 API de Gerenciamento de Músicas e Playlists


**Autor:** Jean Carlos santos matos dos santos

**Disciplina:** Atividade Individual - Back-End com Spring Boot - API RestFul    
**Banco de Dados:** PostgreSQL  

---

## 📋 Descrição do Projeto

Esta API foi desenvolvida como atividade prática da disciplina de Desenvolvimento de API Restful com Spring Boot.  
O objetivo é implementar uma aplicação **RESTful** que gerencie **usuários, perfis, artistas, músicas e playlists**, aplicando conceitos de **JPA, relacionamentos, validações, tratamento de exceções e documentação com Swagger**.


## 🚀 Como Rodar o Projeto

### 🧩 Pré-requisitos
Antes de iniciar, certifique-se de ter instalado:
- **Java 17** ou superior  
- **Maven 3.8+**  
- **PostgreSQL**   
- Uma IDE de sua preferência (**IntelliJ**, **Eclipse**, **VS Code**, etc.)

---

## ⚙️ Configuração do Banco de Dados

**Edite o arquivo `src/main/resources/application.properties` com as credenciais do seu banco.**

### 🐘 Exemplo para PostgreSQL:
spring.datasource.url=jdbc:postgresql://localhost:5432/playlistdb
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha  
spring.jpa.hibernate.ddl-auto=update      
spring.jpa.show-sql=true                         
spring.jpa.properties.hibernate.format_sql=true     
---

## 🧩 Funcionalidades Principais

- CRUD completo para:
  - **Usuário**
  - **Artista**
  - **Música**
  - **Playlist**
- Criação automática de *Perfil* junto com o **Usuário**
- Associação de **Playlist** a um **Usuário existente**
- Atualização de **músicas em uma playlist**
- Validação de dados com **Bean Validation**
- Tratamento centralizado de erros com **@ControllerAdvice**
- Documentação automática com **Swagger / Springdoc OpenAPI**

---

## 🏗️ Arquitetura do Projeto

O projeto segue a seguinte estrutura de pacotes:

- src/main/java/org/serratec/atividade/individual
- ├── controller # Controladores REST (contém a lógica de negócio)
- ├── domain # Entidades (modelos JPA)
- ├── repository # Interfaces Repository (acesso ao banco)
- ├── exception # Tratamento de exceções globais
- └── config # Configurações adicionais (Swagger, etc)
