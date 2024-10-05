# Gestor de Notas

## Descripción

Este proyecto es una aplicación web para la gestión de notas de estudiantes. Permite agregar estudiantes junto con sus calificaciones en actividades, parciales y exámenes finales. La aplicación está dividida en dos partes: un backend desarrollado en **Spring Boot** y un frontend en **React**.

## Tecnologías Utilizadas

- **Backend**: 
  - Spring Boot
  - JPA (Java Persistence API)
  - MySQL

- **Frontend**: 
  - React
  - Axios para realizar solicitudes HTTP

## Requisitos Previos

- Java 11 o superior
- Maven (si usas Maven para el backend)
- Node.js y npm
- MySQL

## Instalación

### Backend

1. Clona el repositorio:
   ```bash
   git clone <url_del_repositorio>
   cd gestor-notas-backend
   
2. Configura la base de datos en src/main/resources/application.properties:
   spring.datasource.url=jdbc:mysql://localhost:3306/gestor_notas
spring.datasource.username=root
spring.datasource.password=root

3. Compila e inicia el servidor:
   mvn clean install
mvn spring-boot:run

Frontend

1. Clona el repositorio:
   git clone <url_del_repositorio>
cd gestor-notas-frontend

2. Instala las dependencias:
   npm install

3. Inicia la aplicación
npm start


