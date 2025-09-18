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
 ├── 📂 src/              # Código fuente de la aplicación
 ├── 📂 public/           # Recursos estáticos
 ├── 📂 docs/             # Documentación
 ├── README.md            # Este archivo
 └── package.json         # Configuración del proyecto (ejemplo si es JS/Node)
```

---

## ⚙️ Tecnologías sugeridas
Dependiendo del stack elegido, el proyecto podría desarrollarse con tecnologías como:
- **Frontend**: React, Vue o Angular.  
- **Backend**: Node.js (Express), Django o Spring Boot.  
- **Base de datos**: MySQL, PostgreSQL o MongoDB.  
- **Autenticación**: JWT, OAuth2 o sistema propio.  
- **Gestión de archivos**: almacenamiento local o servicios en la nube (ej. AWS S3).  

---

## 📌 Próximos pasos
- [ ] Definir stack tecnológico.  
- [ ] Diseñar la base de datos.  
- [ ] Implementar autenticación de usuarios.  
- [ ] Implementar CRUD de vídeos.  
- [ ] Añadir funcionalidades sociales (likes, follows, comentarios).  
- [ ] Desarrollar panel de administración.  

---

## 🤝 Contribución
Las contribuciones son bienvenidas. Para colaborar:
1. Haz un **fork** del repositorio.  
2. Crea una rama con tu feature: `git checkout -b feature/nueva-funcionalidad`.  
3. Haz commit de tus cambios: `git commit -m 'Agrego nueva funcionalidad'`.  
4. Sube la rama: `git push origin feature/nueva-funcionalidad`.  
5. Crea un **Pull Request**.  

---

## 📄 Licencia
Este proyecto está bajo la licencia **MIT**.  
