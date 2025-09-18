# 📑 Requisitos Funcionales (RF)

## RF.01 – Registro de usuarios
- La aplicación deberá permitir el **registro de usuarios** proporcionando: apodo, correo electrónico y contraseña.  
- El sistema validará que el correo no esté repetido y que el apodo sea único.  

## RF.02 – Autenticación de usuarios
- El sistema deberá permitir a los usuarios iniciar sesión con su correo electrónico y contraseña.  
- Se deberá gestionar la **seguridad y sesiones** mediante Spring Security.  

## RF.03 – Gestión de perfiles
- Cada usuario tendrá un perfil con:
  - Lista de **vídeos propios**.
  - Lista de **vídeos con "me gusta"**.
  - Lista de **usuarios seguidos**.  

## RF.04 – Subida de vídeos
- Los usuarios registrados podrán **subir vídeos** con un título obligatorio.  
- Los vídeos estarán asociados al usuario creador.  

## RF.05 – Visualización de vídeos
- Cualquier usuario (registrado o no) podrá **visualizar vídeos**.  
- Al visualizar un vídeo, se mostrará:
  - Título.  
  - Autor.  
  - Número de "me gusta".  
  - Comentarios asociados.  

## RF.06 – Buscador de vídeos
- Cualquier usuario podrá **buscar vídeos por título**.  

## RF.07 – Likes
- Los usuarios registrados podrán **dar y quitar "me gusta"** a los vídeos.  
- En el perfil de usuario deberá mostrarse la lista de vídeos que le han gustado.  

## RF.08 – Comentarios
- Los usuarios registrados podrán **añadir comentarios** en vídeos propios o de otros usuarios.  
- Los administradores podrán **eliminar comentarios** inapropiados.  

## RF.09 – Seguimiento de usuarios
- Los usuarios registrados podrán **seguir o dejar de seguir** a otros usuarios.  
- En el perfil se mostrará la lista de usuarios seguidos.  

## RF.10 – Denuncias
- Los usuarios podrán **denunciar a otros usuarios**.  
- El administrador podrá **bloquear** a usuarios denunciados.  

## RF.11 – Página de inicio
- **Usuario registrado**: verá los últimos vídeos propios y de los usuarios que sigue.  
- **Usuario no registrado**: verá los últimos vídeos subidos al sistema.  
- **Administrador**: verá **todos los vídeos del sistema**.  

## RF.12 – Administración de contenidos
- El administrador podrá:
  - **Eliminar vídeos** de cualquier usuario.  
  - **Eliminar comentarios**.  
  - **Bloquear usuarios denunciados**.  
