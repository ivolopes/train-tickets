# train-tickets

Tecnologias e frameworks utilizados:

- Java 15
- Spring boot
- Lombok
- H2 Database
- Flyway Migrations
- JUnit
- Mockito

Rodar o projeto

-- Primeiro é necessário fazer o build da aplicação

./gradlew build

-- Se for rodar via docker

- docker run --publish 8080:8080 train-ticket

-- Se for executar o jar diretamente (Obs: Tem que ter o java 15)

- java -jar build/libs/train-ticket-0.0.1-SNAPSHOT.jar
