# Vendedores Service

API REST para CRUD de Vendedores
Desafio Backend Casas Bahia

## Tecnologias
- Java 21
- Spring Boot 3.2.5
- Spring Data JPA
- H2 Database (em memória)
- Bean Validation (JSR-380)
- Jackson (JSON)
- JUnit + Mockito
- **Gradle** (build system)


## Como rodar
- Java 21 instalado (verifique com java -version)
- Compile: ./gradlew clean build
- No Linux/Mac: ./gradlew bootRun
- No Windows: ./gradlew bootRun
- Alternativamente, importe o projeto na IDE e rode a classe VendedoresServiceApplication
- Verifique o console do H2: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:vendedoresdb
- User: sa
- Password: (deixe vazio)

## Estrutura do Projeto
```plaintext
vendedores-service/
├── build.gradle
├── settings.gradle
├── README.md
└── src
    ├── main
    │   ├── java/com/casasbahia/vendedores
    │   │   ├── VendedoresServiceApplication.java
    │   │   ├── controller
    │   │   ├── dto
    │   │   ├── exception
    │   │   ├── model
    │   │   ├── repository
    │   │   ├── service
    │   │   └── mock
    │   └── resources
    │       └── application.properties
    └── test/java