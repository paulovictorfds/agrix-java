# <img src="https://cdn-icons-png.flaticon.com/128/226/226777.png" alt="Java Projects Logo" width="42" height="30" /> 🌱 Agrix - Gestão e Monitoramento de Fazendas  <img src="https://cdn-icons-png.flaticon.com/128/226/226777.png" alt="Java Projects Logo" width="42" height="30" />

## Descrição do Projeto

O projeto **Agrix** é uma aplicação web para gestão e monitoramento de fazendas, desenvolvida durante o módulo de Java do curso de Desenvolvimento Web da Trybe. O objetivo principal é auxiliar fazendas que buscam melhorar suas tecnologias e otimizar o uso sustentável do solo, gerenciando plantações, estoques de fertilizantes, entre outros recursos.

<details>
<summary><h2>📈 Diagrama Banco de dados</h2></summary>

![Diagrama do banco de dados](./images/agrix-tabelas-fase-b.png)
</details>

<details>
  <summary><h2>Funcionalidades Implementadas</h2></summary>

  - **Autenticação e Autorização**: Controle de acesso seguro utilizando Spring Security.
  - **Gestão de Fazendas e Plantações**: Rotas para cadastro e monitoramento de fazendas, plantações e fertilizantes.
  - **API REST**: Interface para interação com o sistema.
  - **Gerenciamento de Erros**: Tratamento robusto de erros com Spring Web.
  - **Execução em Docker**: Configuração completa para rodar a aplicação em containers Docker.
</details>

<details>
  <summary><h2>Habilidades Desenvolvidas</h2></summary>

  - Uso avançado do **Spring Framework** para construir aplicações seguras e robustas.
  - Implementação de **Spring Security** para autenticação e autorização de usuários.
  - Desenvolvimento de uma **API REST** com rotas de CRUD para gestão agrícola.
  - Integração com o **Spring Data JPA** para persistência de dados em MySQL.
  - Uso de **Docker** para conteinerização da aplicação e ambiente de testes.
  - Criação de testes unitários com **JUnit**.
</details>

<details>
  <summary><h2>Como Executar</h2></summary>
  
  1. **Clonar o Repositório**:
     ```bash
     git clone https://github.com/paulovictorfds/agrix-java.git
     ```

  2. **Acessar o Diretório**:
     ```bash
     cd agrix-java
     ```

  3. **Compilar e Executar**:
     Use Maven para rodar o projeto:
     ```bash
     mvn spring-boot:run
     ```

  4. **Executar os Testes**:
     Para rodar testes unitários:
     ```bash
     mvn test
     ```

  5. **Executar com Docker**:
     Construa e rode o container Docker:
     ```bash
     docker compose up
     ```
</details>
