# API RESTful de Creación de Usuarios

Esta aplicación expone una API RESTful para la creación de usuarios. Utiliza JSON para enviar y recibir datos, incluso para mensajes de error. La API sigue los estándares de diseño REST y cumple con los siguientes requisitos:

- Permite registrar un nuevo usuario con nombre, correo electrónico, contraseña y lista de teléfonos.
- Retorna el usuario creado con un ID único, fecha de creación, fecha de modificación, fecha del último inicio de sesión, token de acceso y estado de activación.
- Valida que el correo electrónico tenga un formato correcto y que la contraseña cumpla con un formato configurable.
- Retorna un mensaje de error si el correo electrónico ya está registrado en la base de datos.

## Diagrama de la Solución
    +---------------------+
    |      Controller     |
    +----------+----------+
               |
               | HTTP Request/Response
               |
    +----------v----------+
    |       Service       |
    +----------+----------+
               |
               | Business Logic
               |
    +----------v----------+
    |      Repository     |
    +----------+----------+
               |
               | Database CRUD Operations
               |
    +----------v----------+
    |      Database       |
    +---------------------+



## Cómo Probar la Aplicación

1. **Clonar el Repositorio:**
   Clona el repositorio de GitHub en tu máquina local:
- git clone <url_del_repositorio>


2. **Construir la Aplicación:**
Desde el directorio raíz del proyecto, utiliza Gradle o Maven para construir la aplicación:
- mvn clean install


3. **Ejecutar la Aplicación:**
Una vez construida la aplicación, ejecútala:
- java -jar nombre-del-archivo.jar


4. **Enviar Solicitud HTTP:**
Utiliza herramientas como Postman o cURL para enviar una solicitud POST a la API:
```console
POST /users
Content-Type: application/json

{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "hunter2",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "countrycode": "57"
        }
    ]
}
```
Asegúrate de enviar los datos correctos y de acuerdo al formato especificado en el cuerpo de la solicitud. 

5. **Verificar la Respuesta:** La  API responderá con un objeto JSON que contiene los detalles del usuario creado, incluyendo su ID, fechas relevantes, token de acceso, etc. Si la solicitud es incorrecta, la API devolverá un mensaje de error en formato JSON. Con estos pasos, puedes probar fácilmente la API  RESTful de creación de usuarios y verificar su funcionamiento.

## Tecnologías Utilizadas  
- Java 17 
- Spring Boot 
- JSON Web Token (JWT) 
- Spring Data JPA 
- H2 Database (en memoria) -
- Maven (gestión de dependencias y construcción del proyecto)
