# Notes Backend API

Backend API untuk aplikasi Notes yang dibangun menggunakan Java Spring Boot. Project ini dibuat sebagai latihan backend Java dengan struktur yang rapi, REST API, PostgreSQL, dan rencana dokumentasi API menggunakan OpenAPI/Swagger.

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

Project saat ini masih dalam tahap setup awal.

Progress:

* [x] Setup Java 21
* [x] Setup Maven
* [x] Setup PostgreSQL dengan Docker
* [x] Setup Spring Boot project
* [ ] Setup struktur folder backend
* [ ] Membuat API users
* [ ] Membuat authentication
* [ ] Membuat CRUD notes
* [ ] Menambahkan OpenAPI/Swagger documentation

## Struktur Project

Struktur project akan dikembangkan secara bertahap.

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
├── security
├── service
└── SpringBackendApplication.java
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
spring.datasource.password=
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

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

## API Documentation

Dokumentasi API akan dibuat menggunakan OpenAPI/Swagger setelah endpoint utama mulai dibuat.

## Author

Created by Edo as a Java Spring Boot backend learning project.
