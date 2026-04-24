# Franquicias API

API REST desarrollada con Spring Boot para la gestión de franquicias, sucursales y productos.

Permite administrar franquicias, sus sucursales, los productos asociados a cada sucursal y consultar el producto con mayor stock por sucursal.

---

## 🚀 Tecnologías Utilizadas

* Java 17
* Spring Boot 4
* Spring Data JPA
* MySQL 8
* Maven
* Lombok
* Docker
* Docker Compose

---

## 📋 Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

* JDK 17 o superior
* MySQL Server 8.0 o superior
* Maven 3.9 o superior (opcional)
* Docker Desktop (opcional)

> El proyecto incluye Maven Wrapper, por lo que no es obligatorio instalar Maven.

---

## 📁 Estructura del Proyecto

```text
src/main/java/franquicias_api
├── controller
├── dto
├── model
├── repository
└── service
```

---

## ⚙️ Configuración del Entorno

### 1. Clonar el repositorio

```bash
git clone https://github.com/CamiloCT3105/franquicias-api.git
cd franquicias-api
```

### 2. Crear la base de datos

```sql
CREATE DATABASE franquicias_db;
```

### 3. Configurar credenciales

Edita el archivo:

```text
src/main/resources/application.properties
```

Y configura tus credenciales de MySQL:

```properties
spring.application.name=franquicias-api

spring.datasource.url=jdbc:mysql://localhost:3306/franquicias_db
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.open-in-view=false

server.port=8080
```

---

## ▶️ Ejecución Local

### Windows

```bash
.\mvnw.cmd spring-boot:run
```

### Linux / macOS

```bash
./mvnw spring-boot:run
```

---

## 🐳 Ejecución con Docker

```bash
docker compose up --build
```

> Asegúrate de tener Docker instalado y en ejecución.

---

## 🌐 URL Base

```text
http://localhost:8080
```

---

## 📌 Endpoints Disponibles

### Franquicias

#### Crear franquicia

```http
POST /api/franchises
```

```json
{
  "name": "Franquicia Colombia"
}
```

#### Actualizar nombre de franquicia

```http
PATCH /api/franchises/{franchiseId}/name
```

```json
{
  "name": "Nuevo Nombre"
}
```

#### Obtener producto con mayor stock por sucursal

```http
GET /api/franchises/{franchiseId}/top-products
```

---

### Sucursales

#### Crear sucursal

```http
POST /api/franchises/{franchiseId}/branches
```

```json
{
  "name": "Sucursal Medellín"
}
```

#### Actualizar nombre de sucursal

```http
PATCH /api/branches/{branchId}/name
```

```json
{
  "name": "Sucursal Bogotá"
}
```

---

### Productos

#### Crear producto

```http
POST /api/products/branch/{branchId}
```

```json
{
  "name": "Coca Cola",
  "stock": 100
}
```

#### Eliminar producto

```http
DELETE /api/products/{productId}
```

#### Actualizar stock

```http
PATCH /api/products/{productId}/stock
```

```json
{
  "stock": 500
}
```

#### Actualizar nombre del producto

```http
PATCH /api/products/{productId}/name
```

```json
{
  "name": "Coca Cola Zero"
}
```

---

## 🗄️ Modelo de Datos

* Una franquicia posee múltiples sucursales.
* Una sucursal posee múltiples productos.
* Un producto pertenece a una única sucursal.

---

## 🧪 Flujo de Uso

1. Crear una franquicia.
2. Crear una sucursal asociada.
3. Registrar productos.
4. Actualizar stock.
5. Consultar el producto con mayor stock por sucursal.

---

## 📦 Generar JAR

### Windows

```bash
.\mvnw.cmd clean package
```

### Linux / macOS

```bash
./mvnw clean package
```

El archivo generado se ubicará en:

```text
target/franquicias-api-0.0.1-SNAPSHOT.jar
```

---

## 🏗️ Características Implementadas

* Arquitectura en capas
* Persistencia con MySQL
* Spring Data JPA
* Hibernate ORM
* Validaciones con Bean Validation
* Programación funcional con Streams
* Dockerización
* API RESTful
* Código limpio y mantenible

---

## 📂 Flujo de Trabajo con Git

```bash
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin https://github.com/CamiloCT3105/franquicias-api.git
git push -u origin main
```

---

## 👨‍💻 Autor

**Juan Camilo Cañas Toro**

* GitHub: https://github.com/CamiloCT3105

---

## 📄 Licencia

Este proyecto fue desarrollado como parte de una prueba técnica para una posición de Desarrollador Backend.
