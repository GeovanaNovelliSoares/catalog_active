# 🏢 Asset Reservation API - ERP System

Esta é uma API RESTful desenvolvida em **Java 17** e **Spring Boot 3**, projetada para gerenciar a reserva de ativos corporativos (equipamentos, salas de reuniões e veículos). O projeto aplica os princípios da **Clean Architecture** e **SOLID** para garantir um código escalável e de fácil manutenção.

---

## 🚀 Principais Funcionalidades

* **Gestão de Reservas:** Permite a criação de reservas vinculadas a ativos específicos.
* **Regra de Conflito de Horário:** Validação inteligente que impede reservas duplicadas ou sobrepostas para o mesmo ativo.
* **Segurança RBAC (Role-Based Access Control):** * **Funcionários:** Podem solicitar reservas.
    * **Gerentes:** Possuem permissão para aprovar solicitações (Endpoint PATCH).
* **Banco de Dados em Memória:** Utilização de H2 para testes rápidos e demonstração sem necessidade de setup complexo.

---

## 🏗️ Arquitetura e Padrões

O projeto foi estruturado seguindo o padrão de **Arquitetura em Camadas**, garantindo a independência das regras de negócio:



* **API Layer:** Controladores REST e documentação Swagger.
* **Application Layer:** Serviços que orquestram os casos de uso e validações.
* **Domain Layer:** Entidades de negócio puras (Asset, Reservation).
* **Infra Layer:** Configurações de segurança e repositórios (Spring Data JPA).

---

## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3.x**
* **Spring Security** (Autenticação Basic)
* **Spring Data JPA**
* **H2 Database**
* **Lombok** (Produtividade no código)
* **Swagger/OpenAPI 3** (Documentação)

---

## 🚦 Como Testar

### 1. Documentação Interativa (Swagger)
Com a aplicação rodando, acesse:
`http://localhost:8080/swagger-ui/index.html`

### 2. Credenciais de Teste
| Usuário | Senha | Perfil |
| :--- | :--- | :--- |
| `funcionario` | `123` | ROLE_EMPLOYEE |
| `gerente` | `admin` | ROLE_MANAGER |

### 3. Banco de Dados (H2 Console)
Para visualizar as tabelas e dados em tempo real:
`http://localhost:8080/h2-console`
* **JDBC URL:** `jdbc:h2:mem:testdb`
* **User:** `sa` (sem senha)

---
