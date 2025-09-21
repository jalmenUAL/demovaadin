# 📑 Requisitos No Funcionales (RNF)

## RNF.01 – Seguridad
- El sistema debe garantizar que las contraseñas se almacenen **cifradas** (ej. BCrypt).  
- Se deberá implementar **Spring Security** para controlar accesos según roles (usuario, administrador).  
- Solo los usuarios autenticados podrán subir vídeos, dar "me gusta", comentar, seguir o denunciar a otros usuarios.  

---

## RNF.02 – Rendimiento
- El sistema debe ser capaz de soportar al menos **100 usuarios concurrentes** sin degradación significativa del servicio.  
- Las consultas a la base de datos deberán estar optimizadas mediante **JPA** y el uso de índices.  

---

## RNF.03 – Usabilidad
- La interfaz debe ser **intuitiva y responsiva**, desarrollada con **Vaadin**.  
- Los formularios deben validar campos en tiempo real (ej. correo válido, contraseña mínima de 8 caracteres).  

---

## RNF.04 – Disponibilidad
- El sistema debe estar disponible el **99% del tiempo**.  
- En caso de error o caída, deberá mostrar mensajes claros al usuario.  

---

## RNF.05 – Mantenibilidad
- El código deberá seguir principios de **Clean Code** y buenas prácticas de **Spring Boot**.  
- Se deberán realizar pruebas unitarias y de integración con al menos un **70% de cobertura**.  

---

## RNF.06 – Escalabilidad
- La arquitectura deberá permitir la integración con **almacenamiento en la nube** para vídeos en caso de crecimiento (ej. AWS S3).  
- La aplicación deberá poder desplegarse en contenedores (ej. Docker) para facilitar la escalabilidad horizontal.  

---

## RNF.07 – Portabilidad
- La aplicación deberá poder ejecutarse en cualquier sistema con **Java 17+**.  
- El despliegue deberá poder realizarse en servidores locales o en la nube.  

---

## RNF.08 – Auditoría y trazabilidad
- El sistema deberá registrar en logs las operaciones críticas: inicio/cierre de sesión, subida/eliminación de vídeos, bloqueos de usuarios.  
- Los administradores podrán acceder a registros de actividad.  
