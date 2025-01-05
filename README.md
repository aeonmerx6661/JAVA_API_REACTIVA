
# Proyecto API Reactiva con Spring WebFlux

Este proyecto es un ejemplo de implementación de una API REST reactiva utilizando **Spring Boot** y **Spring WebFlux**. El objetivo es mostrar cómo crear endpoints reactivos para manejar datos de forma eficiente y no bloqueante.

## Requisitos Previos

Asegúrate de tener las siguientes herramientas instaladas antes de comenzar:

- [Java 17 o superior](https://adoptium.net/)
- [Maven](https://maven.apache.org/) o [Gradle](https://gradle.org/) (dependiendo del build tool configurado)
- [Git](https://git-scm.com/)
- Un IDE (como IntelliJ IDEA o Eclipse)

---

## Instalación

Sigue los pasos para clonar y ejecutar este proyecto:

1. **Clonar el repositorio:**

   ```bash
   git clone https://github.com/aeonmerx6661/JAVA_API_REACTIVA.git
   cd JAVA_API_REACTIVA
   ```

2. **Configurar el entorno:**

   Abre el proyecto en tu IDE favorito e importa las dependencias. Si usas Maven o Gradle, las dependencias se descargarán automáticamente.

3. **Configurar la base de datos (si aplica):**

   - Este proyecto puede incluir integración con una base de datos reactiva como MongoDB.
   - Configura las credenciales en el archivo `application.yml` o `application.properties`.

4. **Compilar y ejecutar el proyecto:**

   Con Maven:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   Con Gradle:

   ```bash
   ./gradlew clean build
   ./gradlew bootRun
   ```

---

## Uso de la API

### Endpoints principales

| Método | Endpoint          | Descripción                        |
|--------|-------------------|------------------------------------|
| GET    | `/api/v1/items`   | Lista todos los items disponibles |
| GET    | `/api/v1/items/{id}` | Obtiene un item por ID            |
| POST   | `/api/v1/items`   | Crea un nuevo item                 |
| PUT    | `/api/v1/items/{id}` | Actualiza un item existente        |
| DELETE | `/api/v1/items/{id}` | Elimina un item existente         |

Puedes usar herramientas como **Postman**, **cURL**, o integraciones HTTP para probar estos endpoints.

---

## Principales Tecnologías

- **Spring Boot**: Framework base del proyecto.
- **Spring WebFlux**: Soporte para aplicaciones no bloqueantes y programación reactiva.
- **Reactor**: Motor de programación reactiva subyacente.
- **MongoDB (opcional)**: Base de datos reactiva y orientada a documentos.

---

## Estructura del Proyecto

```plaintext
src/main/java/com/usuario/proyecto
├── config          # Configuración reactiva de la app
├── controller      # Controladores REST
├── dto             # Objetos de transferencia de datos
├── model           # Modelos de datos
├── repository      # Interfaces para la capa de datos
└── service         # Lógica del negocio
```

---

## Contribuir

Si deseas contribuir al proyecto:

1. Realiza un fork del repositorio.
2. Crea una nueva rama para tu feature o bugfix:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Haz un commit de tus cambios:
   ```bash
   git commit -m "Descripción de la nueva funcionalidad"
   ```
4. Envía tus cambios a tu fork:
   ```bash
   git push origin feature/nueva-funcionalidad
   ```
5. Abre un pull request en el repositorio original.

---

## Licencia

Este proyecto está licenciado bajo la **MIT License**. Consulta el archivo `LICENSE` para más detalles.
