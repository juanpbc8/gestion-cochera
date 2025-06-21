# API REST - Sistema de Gestión de Cochera Vehicular

Este proyecto Spring Boot implementa una API REST para administrar un sistema de cochera vehicular con soporte para:

- Clientes y Vehículos
- Reservas con fecha y hora
- Control de espacios disponibles en cocheras
- Tipos de vehículos y pagos asociados

## Tecnologías y dependencias

- Java 21
- Spring Boot 3.5.3
- H2 Database (en memoria)
- Spring Web, Spring Data JPA, Lombok
- Swagger (Springdoc OpenAPI)

## Flujo de trabajo con Git (sin ramas, con rebase seguro)

Para evitar errores, confusiones y conflictos en el código, cada integrante debe seguir estos pasos **SIEMPRE**:

### Antes de comenzar a programar (traer cambios del repo):

```bash
git pull --rebase
```

### Después de hacer tus cambios y probar tu API localmente:

```bash
git add .
git commit -m "mensaje del commit"
```

### Justo antes de subir:

```bash
git pull --rebase
```

### Finalmente sube tus cambios al repositorio remoto:

```bash
git push
```
