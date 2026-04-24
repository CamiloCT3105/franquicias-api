Franquicias API

API REST desarrollada con Spring Boot para la gestión de franquicias, sucursales y productos. Permite administrar franquicias, sus sucursales, los productos asociados a cada sucursal y consultar el producto con mayor stock por sucursal.

🚀 Tecnologías Utilizadas
Java 17
Spring Boot 4
Spring Data JPA
MySQL 8
Maven
Lombok
Docker
Docker Compose
📋 Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

Java Development Kit 17 o superior
MySQL Community Server 8.0 o superior
Apache Maven 3.9 o superior (opcional, el proyecto incluye Maven Wrapper)
Docker Desktop (opcional)
📁 Estructura del Proyecto
src/main/java/franquicias_api
├── controller
├── dto
├── model
├── repository
└── service
⚙️ Configuración del Entorno
1. Clonar el repositorio
   git clone https://github.com/CamiloCT3105/franquicias-api.git
   cd franquicias-api

2. Crear la base de datos

Ejecuta en MySQL:

CREATE DATABASE franquicias_db;
3. Configurar credenciales

Edita el archivo:

src/main/resources/application.properties

Y configura tus credenciales:

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
▶️ Ejecución Local
Usando Maven Wrapper (Recomendado)
Windows
.\mvnw.cmd spring-boot:run
Linux / macOS
./mvnw spring-boot:run
🐳 Ejecución con Docker
docker compose up --build

Asegúrate de tener Docker instalado y en ejecución.

🌐 URL Base
http://localhost:8080
📌 Endpoints Disponibles
Franquicias
Crear franquicia
POST /api/franchises
{
"name": "Franquicia Colombia"
}
Actualizar nombre de franquicia
PATCH /api/franchises/{franchiseId}/name
{
"name": "Nuevo Nombre"
}
Obtener producto con mayor stock por sucursal
GET /api/franchises/{franchiseId}/top-products
Sucursales
Crear sucursal
POST /api/franchises/{franchiseId}/branches
{
"name": "Sucursal Medellín"
}
Actualizar nombre de sucursal
PATCH /api/branches/{branchId}/name
{
"name": "Sucursal Bogotá"
}
Productos
Crear producto
POST /api/products/branch/{branchId}
{
"name": "Coca Cola",
"stock": 100
}
Eliminar producto
DELETE /api/products/{productId}
Actualizar stock
PATCH /api/products/{productId}/stock
{
"stock": 500
}
Actualizar nombre del producto
PATCH /api/products/{productId}/name
{
"name": "Coca Cola Zero"
}
🗄️ Modelo de Datos
Una franquicia posee múltiples sucursales.
Una sucursal posee múltiples productos.
Un producto pertenece a una única sucursal.
🧪 Ejemplo de Flujo de Uso
Crear una franquicia.
Agregar una sucursal a la franquicia.
Agregar productos a la sucursal.
Actualizar stock.
Consultar el producto con mayor stock.
📦 Generar JAR
Windows
.\mvnw.cmd clean package
Linux / macOS
./mvnw clean package

El archivo se generará en:

target/franquicias-api-0.0.1-SNAPSHOT.jar

🏗️ Características Implementadas
Arquitectura en capas.
Persistencia con MySQL.
Uso de JPA/Hibernate.
Validaciones con Bean Validation.
Programación funcional con Streams.
Dockerización de la aplicación.
Endpoints RESTful.
Código limpio y mantenible.
📂 Git Workflow Recomendado
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin https://github.com/CamiloCT3105/franquicias-api.git
git push -u origin main
👨‍💻 Autor

Juan Camilo Cañas Toro

GitHub: https://github.com/CamiloCT3105

📄 Licencia

Este proyecto fue desarrollado como parte de una prueba técnica para una posición de Desarrollador Backend.