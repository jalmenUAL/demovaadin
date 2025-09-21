# YouTube-like App 🎥

Una aplicación web inspirada en **YouTube**, desarrollada como proyecto académico/personal, que permite a los usuarios registrarse, subir vídeos, interactuar con otros y gestionar su propia comunidad.

---
## 🚀 Funcionalidades

### 👤 Usuarios
- Registro de usuarios con **apodo, correo electrónico y contraseña**.  
- Perfil personal con:
  - Lista de **vídeos propios**.
  - Lista de **vídeos con "me gusta"**.
  - Lista de **usuarios seguidos**.  
- Posibilidad de **seguir/dejar de seguir** a otros usuarios.  
- Opción de **denunciar usuarios**.

### 🎬 Vídeos
- Subida de vídeos con **título**.  
- Cada vídeo muestra:
  - Información detallada (autor, título, comentarios, likes).  
  - Lista de comentarios asociados.  
- Acciones disponibles:
  - **Dar y quitar "me gusta"**.  
  - **Comentar** vídeos propios o de otros usuarios.  

### 🏠 Página de inicio
- **Usuarios registrados**: últimos vídeos subidos por ellos y por los usuarios que siguen.  
- **Usuarios no registrados**: últimos vídeos públicos.  
- **Administradores**: listado completo de todos los vídeos.

### 🛡️ Administración
- El administrador puede:
  - **Eliminar vídeos**.  
  - **Eliminar comentarios**.  
  - **Bloquear usuarios denunciados**.  

---

## 🗂️ Estructura general del proyecto
```bash
📂 youtube-like-app
 ├── 📂 src/main/java/       # Código fuente Java (Spring Boot + Vaadin)
 │    ├── 📂 domain/         # Entidades JPA
 │    ├── 📂 repository/     # Repositorios JPA
 │    ├── 📂 service/        # Lógica de negocio
 │    ├── 📂 ui/             # Vistas Vaadin
 │    └── Application.java   # Clase principal Spring Boot
 ├── 📂 src/main/resources/  # Configuración (application.properties, plantillas, etc.)
 ├── 📂 src/test/java/       # Pruebas unitarias/integración
 ├── 📂 docs/                # Documentación
 ├── README.md               # Este archivo
 └── pom.xml                 # Configuración del proyecto Maven
```

---

## ⚙️ Tecnologías utilizadas
Este proyecto utiliza el siguiente stack tecnológico:
- **Frontend**: [Vaadin](https://vaadin.com/) (UI en Java).  
- **Backend**: [Spring Boot](https://spring.io/projects/spring-boot).  
- **Persistencia**: [JPA/Hibernate](https://hibernate.org/) como ORM.  
- **Base de datos**: MySQL o PostgreSQL.  
- **Autenticación**: Spring Security (con sesiones o JWT).  



---

## 📄 Licencia
Este proyecto está bajo la licencia **MIT**.  
