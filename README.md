# 🐦 Proyecto X (Twitter en castellano)

[![Java](https://img.shields.io/badge/Java-17-blue?logo=openjdk)](https://adoptium.net/)
[![Vaadin](https://img.shields.io/badge/Vaadin-Flow%2024-00b4f0?logo=vaadin)](https://vaadin.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green?logo=springboot)](https://spring.io/projects/spring-boot)
[![Database](https://img.shields.io/badge/PostgreSQL-15-blue?logo=postgresql)](https://www.postgresql.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

---

## 📌 Descripción

Aplicación de escritorio desarrollada con **Vaadin Flow** que replica las funcionalidades principales de **X (antes Twitter)**, íntegramente en **castellano**.  
Se priorizó la funcionalidad esencial sobre las características avanzadas, para cumplir los plazos del proyecto.  

✅ Tweets con texto, imágenes y vídeos  
✅ Likes, comentarios y retweets  
✅ Hashtags y menciones  
✅ Perfiles con muro personal  
✅ Seguimiento entre usuarios y bloqueos  
✅ Notificaciones  
✅ Panel de administración  

---

## 🛠️ Tecnologías utilizadas

- ☕ **Java 17+**
- ⚡ **Vaadin Flow 24+**
- 🍃 **Spring Boot 3**
- 🗄️ **PostgreSQL** (puede usarse MySQL)
- 🐳 **Docker** (opcional, para la BD)
- 📦 **Maven**
- 🧪 **JUnit 5**

---

## 📂 Estructura del proyecto

```
src/main/java/com/miapp/
 ├── views/          # Vistas Vaadin (Login, Registro, Perfil, Muro, Admin...)
 ├── models/         # Entidades (Usuario, Tweet, Comentario, Hashtag...)
 ├── services/       # Lógica de negocio (TweetService, UserService...)
 ├── repositories/   # Interfaces JPA
 └── security/       # Configuración de login y OAuth
```

---

## ⚙️ Instalación y ejecución

1. **Clonar repositorio**
   ```bash
   git clone https://github.com/usuario/proyecto-x.git
   cd proyecto-x
   ```

2. **Configurar base de datos** en `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/proyecto_x
   spring.datasource.username=postgres
   spring.datasource.password=tu_password
   ```

3. **Levantar PostgreSQL con Docker** (opcional):
   ```bash
   docker run --name proyecto-x-db -e POSTGRES_PASSWORD=tu_password -p 5432:5432 -d postgres
   ```

4. **Compilar y ejecutar**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. **Acceder en navegador**
   ```
   http://localhost:8080/login
   ```

---

## 👤 Roles y funcionalidades

### 🧑‍💻 Cibernauta no registrado
- Ver perfiles y tweets públicos
- No puede interactuar (likes, comentarios, retweets, seguir)

### 👥 Usuario registrado
- Crear tweets, dar like, comentar, retweetear
- Seguir/bloquear usuarios
- Recibir notificaciones
- Editar perfil
- Borrar cuenta

### 🛡️ Administrador
- Ver todos los tweets en un feed global
- Eliminar tweets o comentarios
- Banear usuarios (soft-delete)
- No reciben notificaciones ni tienen perfiles privados

---

## 🗄️ Modelo de datos

📊 El esquema de la base de datos se encuentra en [`/docs/diagrama-bd.puml`](docs/diagrama-bd.puml).  
Incluye entidades como `User`, `Tweet`, `Comment`, `Media`, `Hashtag`, `Follow`, `Block`, `Like`, `Notification`, `AdminLog`.  

---

## 🔒 Seguridad

- Validación de contraseñas: **8-14 caracteres, 1 mayúscula, 1 carácter especial**  
- Login tradicional o vía **Google OAuth**  
- Usuarios eliminados/baneados **no pueden volver a registrarse** con el mismo correo  
- **Perfiles bloqueados** no permiten interacción  

---

## 📸 Capturas de pantalla

*(Incluir imágenes de la UI: login, muro, perfil, panel admin…)*

---

## ✅ Tests

Se incluyen pruebas unitarias y de integración para:  
- Servicios de usuarios y tweets  
- Validación de login/registro  
- Restricciones de negocio (likes, bloqueos, follows)  

Ejecutar tests:  
```bash
mvn test
```

---

## 👥 Equipo

- ✨ Nombre Apellido – [GitHub](#) – [LinkedIn](#)  
- ✨ Nombre Apellido – [GitHub](#) – [LinkedIn](#)  

---



## 📄 Licencia

Este proyecto se distribuye bajo la licencia **MIT**.  
Consulta el archivo [LICENSE](LICENSE) para más información.
