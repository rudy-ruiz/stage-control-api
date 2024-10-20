# Stage Control API

Bienvenido a **Stage Control API**, una solución robusta para la gestión de ambientes de desarrollo, QA y producción. Este proyecto está construido utilizando **Spring Boot 3.3.4**, **Maven** y **OpenJDK 17**.

## Descripción

**Stage Control API** proporciona una interfaz sencilla y eficiente para gestionar diferentes ambientes, permitiendo la configuración y el cambio de parámetros específicos para cada entorno de manera ágil. Esto optimiza el flujo de trabajo y mejora la productividad en el desarrollo de software.

## Estructura de Perfiles

El API soporta tres perfiles principales, cada uno con su propio archivo de propiedades:

- **dev.properties**: Configuración para el entorno de desarrollo.
- **qas.properties**: Configuración para el entorno de QA.
- **pro.properties**: Configuración para el entorno de producción.

### Ejemplo de Configuración en `application-{profile}.properties`

```properties
# Configuración para el entorno de desarrollo
spring.datasource.url=jdbc:postgresql://dev-db-server:5432/dev_db
spring.datasource.username=dev_user
spring.datasource.password=dev_password
spring.jpa.hibernate.ddl-auto=update


# Perfil por defecto
spring.profiles.active=qas

mvn spring-boot:run -Dspring-boot.run.profiles=qas

# Ejecutar comandos basicos
# Para desarrollo
mvn spring-boot:run -Dspring-boot.run.profiles=dev
# Para QA
mvn spring-boot:run -Dspring-boot.run.profiles=qas
# Para producción
mvn spring-boot:run -Dspring-boot.run.profiles=prod  

