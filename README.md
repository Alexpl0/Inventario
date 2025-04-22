# Sistema de Gestión de Inventario

<div align="center">
  <img src="https://img.shields.io/badge/Java-23-orange" alt="Java 23">
  <img src="https://img.shields.io/badge/Spring_Boot-3.4.3-brightgreen" alt="Spring Boot 3.4.3">
  <img src="https://img.shields.io/badge/PostgreSQL-Latest-blue" alt="PostgreSQL">
  <img src="https://img.shields.io/badge/Docker-Ready-blue" alt="Docker Ready">
  <img src="https://img.shields.io/badge/License-MIT-green" alt="License MIT">
</div>

<br>

> Una aplicación robusta y moderna para la gestión integral de inventarios, productos, categorías y reservaciones de salas.

## 📑 Contenido

- Descripción General
- Tecnologías Utilizadas
- Estructura del Proyecto
- Modelo de Datos
- API REST
- Instrucciones de Configuración
- Contribución
- Solución de Problemas

## 📋 Descripción General

Esta API RESTful proporciona una solución completa para la gestión de inventarios, con funcionalidades que incluyen:

- ✅ **Gestión de productos** - Control completo del catálogo de productos
- ✅ **Categorización** - Organización eficiente mediante categorías
- ✅ **Control de ubicaciones** - Seguimiento preciso de ubicaciones físicas
- ✅ **Reserva de salas** - Sistema integrado para gestionar espacios compartidos
- ✅ **Seguimiento de inventario** - Monitoreo detallado del estado de los productos

## 🛠️ Tecnologías Utilizadas

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| Java | 23 | Lenguaje de programación principal |
| Spring Boot | 3.4.3 | Framework para desarrollo de aplicaciones |
| Spring Data JPA | 3.4.3 | Persistencia y acceso a datos |
| PostgreSQL | Latest | Base de datos relacional |
| Docker Compose | - | Contenerización y despliegue |
| Lombok | - | Reducción de código boilerplate |
| Maven | - | Gestión de dependencias y construcción |

## 📁 Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── inventario/
│   │           ├── Categoria/              # Gestión de categorías
│   │           ├── InvtentarioGeneral/     # Control de inventario
│   │           ├── Producto/               # Gestión de productos
│   │           ├── Reservaciones/          # Sistema de reservaciones
│   │           ├── Salas/                  # Gestión de salas
│   │           ├── Ubicacion/              # Control de ubicaciones
│   │           ├── InventarioApplication   # Clase principal
│   │           └── WebConfig               # Configuración CORS
│   └── resources/
│       └── application.properties          # Configuración de la aplicación
└── test/                                   # Pruebas automatizadas
```

## 🗃️ Modelo de Datos

La aplicación se basa en las siguientes entidades principales:

| Entidad | Descripción | Relaciones |
|---------|-------------|------------|
| **Producto** | Elementos físicos en inventario | ManyToOne con Categoria y Ubicacion |
| **Categoria** | Clasificación de productos | OneToMany con Producto |
| **Ubicacion** | Ubicación física de productos | OneToMany con Producto |
| **Salas** | Espacios que pueden reservarse | OneToMany con Reservaciones |
| **Reservaciones** | Registro de reservas de salas | ManyToOne con Salas |
| **Inventario** | Estado actual de los productos | ManyToOne con Producto |

## 🌐 API REST

### Productos (`/productos`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/productos` | Listar todos los productos |
| GET | `/productos/{id}` | Obtener producto por ID |
| POST | `/productos` | Crear nuevo producto |
| PUT | `/productos/{id}` | Actualizar producto existente |
| DELETE | `/productos/{id}` | Eliminar producto |

### Categorías (`/categorias`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/categorias` | Listar todas las categorías |
| GET | `/categorias/{id}` | Obtener categoría por ID |
| POST | `/categorias` | Crear nueva categoría |
| PUT | `/categorias/{id}` | Actualizar categoría existente |
| DELETE | `/categorias/{id}` | Eliminar categoría |

### Ubicaciones (`/ubicaciones`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/ubicaciones` | Listar todas las ubicaciones |
| GET | `/ubicaciones/{id}` | Obtener ubicación por ID |
| POST | `/ubicaciones` | Crear nueva ubicación |
| PUT | `/ubicaciones/{id}` | Actualizar ubicación existente |
| DELETE | `/ubicaciones/{id}` | Eliminar ubicación |

### Salas (`/salas`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/salas` | Listar todas las salas |
| GET | `/salas/{id}` | Obtener sala por ID |
| POST | `/salas` | Crear nueva sala |
| PUT | `/salas/{id}` | Actualizar sala existente |
| DELETE | `/salas/{id}` | Eliminar sala |

### Reservaciones (`/reservaciones`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/reservaciones` | Listar todas las reservaciones |
| GET | `/reservaciones/{id}` | Obtener reservación por ID |
| POST | `/reservaciones` | Crear nueva reservación |
| PUT | `/reservaciones/{id}` | Actualizar reservación existente |
| DELETE | `/reservaciones/{id}` | Eliminar reservación |

### Inventario (`/inventario`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/inventario` | Listar todos los registros de inventario |
| GET | `/inventario/{id}` | Obtener registro por ID |
| POST | `/inventario` | Crear nuevo registro de inventario |
| PUT | `/inventario/{id}` | Actualizar registro existente |
| DELETE | `/inventario/{id}` | Eliminar registro de inventario |

## ⚙️ Instrucciones de Configuración

### Requisitos Previos

- Java 23 JDK
- Docker y Docker Compose
- Maven

### Pasos para Ejecutar

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/usuario/inventario.git
   cd inventario
   ```

2. **Iniciar la base de datos PostgreSQL**
   ```bash
   docker-compose up -d
   ```

3. **Ejecutar la aplicación Spring Boot**
   ```bash
   # En Linux/Mac
   ./mvnw spring-boot:run
   
   # En Windows
   mvnw.cmd spring-boot:run
   ```

### Configuración de Base de Datos

La aplicación se conecta a PostgreSQL con la siguiente configuración:

| Parámetro | Valor |
|-----------|-------|
| URL | jdbc:postgresql://localhost:5432/postgres |
| Usuario | postgres |
| Contraseña | postgres |
| Modo DDL | update |

## 🤝 Contribución

Para contribuir al proyecto:

1. Realice un fork del repositorio
2. Cree una rama para su función (`git checkout -b feature/nueva-funcion`)
3. Haga commit de sus cambios (`git commit -m 'Añade nueva función'`)
4. Push a la rama (`git push origin feature/nueva-funcion`)
5. Abra un Pull Request

Por favor, asegúrese de seguir los patrones de código existentes y agregar pruebas para cualquier nueva funcionalidad.

## ❓ Solución de Problemas

### Conflictos de Puerto

Si encuentra conflictos con el puerto 8080:

1. **Identifique el proceso en uso**
   ```bash
   netstat -ano | findstr :8080
   ```

2. **Termine el proceso**
   ```bash
   taskkill /PID <PID> /F
   ```

3. **Alternativa**: Configure un puerto diferente en `application.properties`:
   ```properties
   server.port=8081
   ```

---

<div align="center">
  <p>Desarrollado con ❤️ por el equipo de Inventario</p>
  <p>© 2025 | Todos los derechos reservados</p>
</div>