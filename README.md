# 🛍️ Proyecto Compra-Venta Online (tipo Wallapop/Vinted)

Aplicación web para compra-venta de artículos de segunda mano, inspirada en **Wallapop** y **Vinted**.  
Permite a cualquier persona explorar un catálogo de productos, vender, comprar, negociar precios y dejar reseñas, todo dentro de un entorno seguro y administrado.

---

## 🚀 Características principales
- Catálogo organizado por categorías.
- Búsqueda de artículos por nombre o sub-cadena.
- Usuarios registrados pueden ser **compradores** y **vendedores** a la vez.
- Publicación de artículos con fotos, descripción, precio y categorías.
- Sistema de favoritos y ofertas.
- Pagos retenidos hasta confirmación de recepción del artículo.
- Reseñas con valoración numérica y texto.
- Denuncias gestionadas por administradores.
- Perfiles de usuario con historial de ventas/compras y reputación.

---

## 🏗️ Arquitectura (visión C4 - nivel de contexto)

```mermaid
C4Context
    title Sistema de compra-venta
    Person(usuario, "Usuario", "Comprador/Vendedor")
    Person(admin, "Administrador", "Gestiona la aplicación")
    System(app, "Aplicación Compra-Venta", "Web para explorar, vender y comprar artículos")
    System_Ext(pasarela, "Pasarela de Pago", "Gestión de cobros y pagos")
    usuario -> app : Explora, compra, vende
    admin -> app : Gestiona denuncias, categorías, usuarios
    app -> pasarela : Retiene y libera dinero
```

---

## 📂 Estructura del repositorio

```plaintext
.
├── backend/         # Lógica de negocio y API REST
├── frontend/        # Aplicación web (UI)
├── docs/            # Documentación (Markdown, UML, diagramas)
├── tests/           # Pruebas unitarias y de integración
└── README.md        # Este archivo
```

---

## ⚙️ Requisitos
- **Java 21** + **Spring Boot** (backend)
- **Vaadin / React** (frontend)
- **PostgreSQL** (base de datos)
- **Docker** (para despliegue opcional)

---

## ▶️ Ejecución local

```bash
# Clonar el repositorio
git clone https://github.com/tu-org/compra-venta.git
cd compra-venta

# Levantar con Docker
docker-compose up
```

La aplicación quedará disponible en `http://localhost:8080`.

---

## ✅ Requisitos Funcionales principales

- [x] Explorar catálogo sin registro
- [x] Registro de usuarios con correo, nick, avatar, cuenta bancaria y tarjeta
- [x] Publicación y edición de artículos
- [x] Favoritos y ofertas
- [x] Proceso de compra con retención de dinero
- [x] Reseñas tras confirmar recepción
- [x] Denuncias y gestión administrativa

---

## 🧩 Próximos pasos
- [ ] Implementar recomendaciones personalizadas según favoritos
- [ ] Notificaciones en tiempo real (WebSockets)
- [ ] Integración con sistemas externos de transporte
- [ ] Tests de carga y seguridad

---

## 👥 Roles en el sistema
- **Usuario no registrado** → Explora el catálogo.
- **Usuario registrado** → Compra, vende, oferta, reseña.
- **Administrador** → Gestiona categorías, denuncias, usuarios y reseñas.

---

## 📜 Licencia
Este proyecto se distribuye bajo la licencia **MIT**.  
Puedes usarlo, modificarlo y distribuirlo libremente respetando los términos de la licencia.

Este proyecto se distribuye bajo la licencia **MIT**.  
Consulta el archivo [LICENSE](LICENSE) para más información.
