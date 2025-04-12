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
git clone https://github.com/conagyurig/tursoDemo.git
cd turso-jdbc-demo
```

### 2. Add your credentials to application.properties

```properties
spring.application.name=tursoDemo
spring.datasource.username=ignored
spring.datasource.driver-class-name=org.conagyurig.LibSqlDriver
spring.sql.init.mode=always
spring.datasource.url=jdbc:libsql://{url}
spring.datasource.password={token}
```

### 3. Run the application
Run the main method in TursoDemoApplication.java

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

## 📚 Info
### Custom Dialect
Currently Spring Data does not support LibSQL or SQLite so a custom dialect is required which is implemented in LibSQLDialect.java

