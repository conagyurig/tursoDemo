# 🛠️ Turso JDBC Demo Application

This is a minimal Spring Boot microservice that uses **[Spring Data JDBC](https://spring.io/projects/spring-data-jdbc)** and the **Turso JDBC driver** to connect to a [Turso](https://turso.tech) (LibSQL) database.

It demonstrates powerful functionality such as:
- Spring Data repository support
- Pagination + sorting
- Custom endpoints for CRUD operations
- Prepared statements
- Batch inserts

## 🚀 Quick Start

### 1. Clone the repo

```bash
git clone https://github.com/your-username/turso-jdbc-demo.git
cd turso-jdbc-demo
```

### 2. Add your credentials to application.properties

```properties
spring.datasource.url=jdbc:libsql://{url}
spring.datasource.password={token}
```

## 📦 API Endpoints

| Method | Endpoint | Description                       |
|--------|----------|-----------------------------------|
| GET    | /        | Get all jobs (paginated & sorted) |
| GET    | /{id}    | Get a job by ID                   |
| POST   | /        | Create a job (pass status param)  |
| POST   | /{id}    | Update a job’s status             |
| DELETE | /{id}    | Delete a job by ID                |
| POST   | /bulk    | Create multiple jobs in a batch   |


## Example

curl -X POST "http://localhost:8080/?status=pending"


