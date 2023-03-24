# Sistema de entrega
Este projeto consiste em um sistema de entrega que gerencia entregas, ocorrências, clientes, status de entrega e destinos. O sistema possui as seguintes entidades:

- Delivery: representa a entrega em si, contendo informações como identificação, descrição, data de criação, data de entrega e informações do cliente.
- Occurrence: representa as ocorrências relacionadas a uma entrega, como atrasos, mudanças no status e outros eventos.
- Client: representa o cliente que está recebendo a entrega, contendo informações como nome, endereço e outras informações de contato.
- DeliveryStatus: representa o status atual de uma entrega, podendo ser "em andamento", "entregue", "cancelado" ou outro status definido pelo sistema.
- Destination: representa o destino de uma entrega, contendo informações como endereço de entrega, nome do destinatário e outras informações relevantes.

## As tecnologias utilizadas foram:

- Spring Boot: framework para construção de aplicações web em Java.
- MySQL: banco de dados relacional utilizado para armazenar as informações do sistema.
- Flyway: ferramenta para gerenciamento de migrações do banco de dados.
- DevTools: ferramenta para desenvolvimento rápido e fácil.
- ModelMapper: biblioteca utilizada para mapeamento de objetos.
- Valid: biblioteca para validação de dados.
- Lombok: biblioteca utilizada para reduzir a verbosidade do código.
- JPA: API para mapeamento objeto-relacional.
- Maven: ferramenta para gerenciamento de dependências.
- Git: sistema de controle de versão utilizado para gerenciamento de código-fonte.
- Postman: ferramenta utilizada para testar os endpoints da API.

## Explicando as Entidades
A entidade Occurrence possui um relacionamento OneToMany com Delivery, indicando que uma entrega pode ter várias ocorrências. A entidade Delivery tem um relacionamento ManyToOne com Client, indicando que um cliente pode ter várias entregas. A entidade Destination tem um relacionamento Embbeded com Delivery, indicando que as informações do destino estão inclusas nas informações da entrega.

## Técnicas usadas
As técnicas de programação utilizadas incluem programação funcional, uso de generics, DTO (Data Transfer Object), POO (Programação Orientada a Objetos) e interface marcadora.

O projeto segue a convenção REST e possui os seguintes diretórios:

Web service: contém os endpoints da API.
Stateless: as chamadas dos endpoints são stateless.
Camadas de Repositories, Services e Resources: a camada de Repositories é responsável por acessar o banco de dados, a camada de Services é responsável por implementar as regras de negócio e a camada de Resources é responsável por receber e enviar dados para os endpoints.
