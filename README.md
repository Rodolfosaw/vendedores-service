# Vendedores Service

API REST para CRUD de Vendedores
Mercantiservice – Arquitetura Backend com Spring Boot

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
- Verifique o console do H2: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:vendedoresdb
- User: sa
- Password: (deixe vazio)

## 🔗 Documentação da API (Swagger)

Acesse a documentação interativa da API via Swagger UI:

👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)


## Estrutura do Projeto
```plaintext
vendedores-service/
├── build.gradle
├── settings.gradle
├── README.md
└── src
    ├── main
    │   ├── java/com/mercantiservice/vendedores
    │   │   ├── controller
    │   │   ├── dto
    │   │   ├── enums
    │   │   ├── exception
    │   │   ├── mock
    │   │   ├── model
    │   │   ├── repository
    │   │   ├── service
    │   │   ├── validation
    │   │   └── VendedoresServiceApplication.java
    │   └── resources
    │       └── application.properties
    └── test
        └── java/com/mercantiservice/vendedores/service/impl
            └── VendedorServiceImplTest.java
