# security_backend


## Configuracion del proyecto
En el archivo `src/main/resources/application.properties`, debe colocar el siguiente contenido modificando la conexion a MySQL:
```aidl
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=create

server.port=8080
server.error.include-message=always

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=CONEXION_MYSQL
spring.datasource.username=USUARIO_MYSQL
spring.datasource.password=PASSWORD_MYSQL
```