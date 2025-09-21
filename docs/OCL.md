# 📑 Restricciones del sistema (OCL-like)

## Usuario
```ocl
-- Un usuario debe tener un correo único
context Usuario
inv correoUnico: Usuario.allInstances()->isUnique(u | u.email)

-- El apodo del usuario debe ser único
context Usuario
inv apodoUnico: Usuario.allInstances()->isUnique(u | u.apodo)

-- La contraseña debe tener al menos 8 caracteres
context Usuario
inv contrasenaValida: self.password.size() >= 8

-- Un usuario bloqueado no puede subir vídeos
context Usuario
inv usuarioBloqueadoNoSube: self.bloqueado implies self.videos->isEmpty()

-- Todo vídeo debe tener un título no vacío
context Video
inv tituloNoVacio: self.titulo.size() > 0

-- El autor de un vídeo debe existir
context Video
inv autorExistente: not self.autor.oclIsUndefined()

-- Un usuario no puede dar "me gusta" dos veces al mismo vídeo
context Video
inv likeUnicoPorUsuario: self.likes->isUnique(l | l.usuario)

-- Un comentario debe tener contenido no vacío
context Comentario
inv contenidoNoVacio: self.texto.size() > 0

-- El autor de un comentario debe estar registrado
context Comentario
inv autorDebeExistir: not self.autor.oclIsUndefined()

-- Un usuario no puede seguirse a sí mismo
context Seguimiento
inv noAutoSeguimiento: self.seguidor <> self.seguido

-- Un usuario no puede seguir al mismo usuario más de una vez
context Usuario
inv seguimientoUnico: self.seguidos->isUnique(u | u)

-- Solo el administrador puede eliminar vídeos
context Administrador
inv eliminarVideos: self.rol = 'ADMIN'

-- Solo el administrador puede bloquear usuarios
context Administrador
inv bloquearUsuarios: self.rol = 'ADMIN'
