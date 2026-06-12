# Notes Backend API

Backend API untuk aplikasi Notes yang dibangun menggunakan Java Spring Boot. Project ini dibuat sebagai latihan backend Java dengan struktur project yang rapi, REST API, PostgreSQL, validasi request, dan rencana dokumentasi API menggunakan OpenAPI/Swagger.

## Tech Stack

* Java 21
* Spring Boot
* Maven
* PostgreSQL
* Docker
* Git
* Postman
* OpenAPI/Swagger

## Project Status

Project saat ini sudah memiliki setup awal backend dan Users API sederhana.

Progress:

* [x] Setup Java 21
* [x] Setup Maven
* [x] Setup PostgreSQL dengan Docker
* [x] Setup Spring Boot project
* [x] Setup struktur folder backend
* [x] Membuat Users API
* [x] Menambahkan request validation
* [x] Menambahkan response wrapper
* [x] Menambahkan basic exception handling
* [ ] Membuat authentication
* [ ] Menambahkan JWT authentication
* [ ] Membuat CRUD notes
* [ ] Menambahkan OpenAPI/Swagger documentation

## Struktur Project

```txt
src/main/java/com/notes/backend
├── config
├── controller
├── dto
│   ├── request
│   └── response
├── entity
├── exception
├── repository
├── service
└── SpringBackendApplication.java
```

Keterangan singkat:

```txt
config      → konfigurasi aplikasi
controller  → endpoint REST API
dto         → request dan response object
entity      → model database
exception   → handler error aplikasi
repository  → akses database
service     → business logic
```

## Setup Database

Project ini menggunakan PostgreSQL melalui Docker.

```bash
docker run --name notes-postgres \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_DB=notes_db \
  -p 5432:5432 \
  -d postgres:16
```

Cek container:

```bash
docker ps
```

Masuk ke database:

```bash
docker exec -it notes-postgres psql -U postgres -d notes_db
```

## Application Configuration

Konfigurasi lokal berada di:

```txt
src/main/resources/application.properties
```

Contoh konfigurasi:

```properties
spring.application.name=spring-backend

spring.datasource.url=jdbc:postgresql://localhost:5432/notes_db
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Catatan: konfigurasi ini hanya untuk development lokal.

## Menjalankan Project

Jalankan menggunakan Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Atau jalankan langsung melalui IntelliJ IDEA dari file:

```txt
SpringBackendApplication.java
```

Aplikasi berjalan di:

```txt
http://localhost:8080
```

## API Endpoints

### Users

| Method | Endpoint          | Description     |
| ------ | ----------------- | --------------- |
| POST   | `/api/users`      | Create new user |
| GET    | `/api/users`      | Get all users   |
| GET    | `/api/users/{id}` | Get user by ID  |

## Response Format

Response sukses menggunakan format:

```json
{
  "status": "success",
  "message": "User created successfully",
  "data": {}
}
```

Response error menggunakan format:

```json
{
  "status": "error",
  "message": "Email is already used"
}
```

## Request Validation

Validasi request dilakukan pada DTO menggunakan Jakarta Bean Validation.

Contoh validasi pada create user:

* Username wajib diisi
* Email wajib diisi dan harus valid
* Password wajib diisi
* Password memiliki panjang minimum

## Dokumentasi API

Dokumentasi API akan dibuat menggunakan OpenAPI/Swagger setelah endpoint utama selesai dibuat.

## Author

Created by Edo as a Java Spring Boot backend learning project.
