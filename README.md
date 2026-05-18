# Sistema WMS - Warehouse Management System
API REST para gerenciamento de estoque desenvolvida com Java e Spring Boot.

[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.5-brightgreen.svg)](https://spring.io/projects/spring-boot)

Um sistema simples de **gestão de estoque (WMS)** desenvolvido em Spring Boot, com foco em cadastro de produtos e estrutura inicial de gerenciamento de estoque e alertas de estoque baixo.

## 📁 Estrutura do Projeto

```text
src/main/java/com/davi/wms
├── controller
├── service
├── repository
├── entity
├── dto
├── config
└── exception
```

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 4.0.5
- Spring Data JPA + Hibernate
- H2 Database (desenvolvimento)
- Lombok
- Jakarta Bean Validation
- Maven
- SpringDoc OpenAPI (Swagger)

## 🎯 Funcionalidades Implementadas

- Cadastro de produtos com SKU único
- Controle de estoque (entrada e saída)
- Consulta de produtos com estoque baixo
- Atualização e desativação lógica de produtos
- Persistência com JPA/Hibernate
- Documentação automática com Swagger

## ▶️ Como Rodar Localmente

### Pré-requisitos
- JDK 21
- Maven 3.8+

### Passos

#### Clone o repositório

```bash
git clone https://github.com/davibar114-afk/sistema-wms.git
cd sistema-wms
```

#### Compile o projeto

```bash
mvn clean install
```

#### Execute a aplicação

```bash
mvn spring-boot:run
```

## Links Úteis

- Swagger: http://localhost:8080/swagger-ui.html
- H2 Console: http://localhost:8080/h2-console

## Configuração do Banco H2

JDBC URL: jdbc:h2:file:./data/wmsdb
Usuário: sa
Senha: (em branco)

## Endpoints Principais

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/produtos` | Criar produto |
| GET | `/produtos` | Listar produtos |
| GET | `/produtos/{id}` | Buscar produto por ID |
| PUT | `/produtos/{id}` | Atualizar produto |
| DELETE | `/produtos/{id}` | Desativar produto |
| POST | `/produtos/entrada` | Entrada de estoque |
| POST | `/produtos/saida` | Saída de estoque |
| GET | `/produtos/estoque-baixo` | Produtos com estoque baixo |

## Exemplo JSON - Criar Produto

```json
{
  "sku": "PROD-001",
  "nome": "Notebook Dell XPS 15",
  "descricao": "Notebook high performance",
  "categoria": "Eletrônicos",
  "unidade": "UN",
  "quantidadeAtual": 10,
  "quantidadeMinima": 5,
  "precoCusto": 4500.00,
  "ativo": true
}
```

## Próximas Funcionalidades

### Infraestrutura
- [ ] Migração para MySQL
- [ ] Docker + Docker Compose

### Arquitetura
- [ ] Implementação de DTOs
- [ ] Tratamento global de exceções
- [ ] Padronização de respostas da API

### Segurança
- [ ] Spring Security + JWT

### Qualidade
- [ ] Testes unitários com JUnit e Mockito

### Regras de Negócio
- [ ] Módulo de movimentações
- [ ] Endereçamento logístico
- [ ] Histórico de movimentações
- [ ] Auditoria

### Deploy
- [ ] Deploy em nuvem

## Autor
Feito por Davi Feldmann | Estudante de Java e desenvolvimento backend.
Aberto a oportunidades de estágio e desenvolvimento Java Júnior.

Qualquer feedback ou sugestão é muito bem-vindo!
