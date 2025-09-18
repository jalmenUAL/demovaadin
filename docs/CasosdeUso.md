
# Documento de Requisitos Funcionales (RF)

## Proyecto: Aplicación web de compra-venta de segunda mano (tipo Wallapop/Vinted)

---

## 🎭 Casos de Uso

```mermaid
flowchart TB
    U0(["👤 Usuario no registrado"]) --> |"Explora catálogo"| Cat[(Catálogo)]
    U0 --> |"Buscar artículos"| Cat

    U(["👥 Usuario registrado"]) --> |"Publicar artículo"| Cat
    U --> |"Editar/Borrar artículo"| Cat
    U --> |"Marcar favorito"| Cat
    U --> |"Comprar / Hacer oferta"| Cat
    U --> |"Confirmar recepción"| Pago[(Pagos)]
    U --> |"Escribir reseña"| Perfil[(Perfil vendedor)]
    U --> |"Denunciar compra fallida"| Admin[(Administradores)]

    A(["🛡️ Administrador"]) --> |"Gestionar denuncias"| Admin
    A --> |"Bloquear usuarios"| Admin
    A --> |"Borrar artículos"| Cat
    A --> |"Crear/Borrar categorías"| Cat
    A --> |"Borrar reseñas inadecuadas"| Perfil


## 1. Catálogo y Búsquedas

* **RF-1**: El catálogo estará organizado por categorías.
* **RF-2**: Un artículo puede pertenecer a una o varias categorías.
* **RF-3**: Cualquier usuario (registrado o no) y los administradores pueden buscar artículos por nombre (o sub-cadena) en una categoría o en todo el catálogo.
* **RF-4**: Los artículos aparecerán como **reservados** cuando el vendedor anota el envío y como **vendidos** cuando el comprador confirma la recepción.

---

## 2. Registro y Usuarios

* **RF-5**: Para registrarse, el usuario debe proporcionar: correo electrónico (servirá como login), password, nick, imagen de avatar, número de cuenta (para cobrar ventas) y número de tarjeta (para pagar compras).
* **RF-6**: Un usuario registrado puede actuar como comprador y vendedor simultáneamente.
* **RF-7**: Los usuarios registrados pueden consultar sus compras y ventas realizadas, sus ingresos por ventas y sus gastos por compras.
* **RF-8**: Los perfiles de usuario mostrarán la información pública: nick, avatar, ubicación, reseñas, número total de ventas, media de valoraciones y número de ventas/compras realizadas.

---

## 3. Gestión de Artículos

* **RF-9**: Para publicar un artículo, un usuario registrado debe introducir: nombre, varias fotos, categorías, precio y descripción.
* **RF-10**: El vendedor podrá **editar** la información de un artículo en cualquier momento mientras no haya una venta pendiente.
* **RF-11**: El vendedor podrá **eliminar** un artículo en cualquier momento mientras no haya una venta pendiente.

---

## 4. Favoritos y Ofertas

* **RF-12**: Cualquier usuario registrado puede marcar un artículo como favorito.
* **RF-13**: Un usuario puede hacer una oferta por un artículo.
* **RF-14**: El vendedor puede aceptar o rechazar ofertas.

---

## 5. Compras y Envíos

* **RF-15**: Un usuario registrado puede comprar un artículo directamente o mediante una oferta aceptada.
* **RF-16**: Al realizar la compra, el vendedor debe anotar el envío en la aplicación y subir el resguardo de la empresa de transporte y fotografías del producto y el embalaje.
* **RF-17**: El comprador debe anotar la recepción del artículo en la aplicación.
* **RF-18**: El dinero de la transacción se retiene hasta que el comprador confirme la recepción.
* **RF-19**: Si el comprador no confirma en un tiempo límite, el sistema libera el dinero automáticamente al vendedor.

---

## 6. Reseñas

* **RF-20**: Los compradores podrán dejar una reseña (valoración numérica y texto) solo tras confirmar la recepción.
* **RF-21**: El perfil del vendedor mostrará todas las reseñas y la media de valoraciones.
* **RF-22**: Los administradores podrán borrar reseñas inadecuadas.

---

## 7. Denuncias y Resolución de Conflictos

* **RF-23**: Si una compra no se realiza con éxito (envío no recibido o artículo defectuoso), el comprador puede denunciarlo especificando el artículo y la causa.
* **RF-24**: Los administradores evaluarán las denuncias y decidirán si son válidas.
* **RF-25**: En función de la resolución, el administrador podrá devolver el dinero al comprador o liberarlo al vendedor.
* **RF-26**: Los usuarios que realicen denuncias indebidas podrán ser bloqueados.

---

## 8. Roles y Administración

* **RF-27**: Los administradores pueden crear y borrar categorías.
* **RF-28**: Los administradores pueden borrar artículos del catálogo.
* **RF-29**: Los administradores pueden bloquear usuarios por múltiples denuncias válidas, denuncias falsas o reseñas inadecuadas.
* **RF-30**: Los administradores tienen acceso a toda la información de usuarios, compras, ventas e historiales.

---

## 9. Página Principal y Recomendaciones

* **RF-31**: En la página principal de usuarios no registrados y administradores aparecerán los últimos artículos en venta.
* **RF-32**: En la página principal de usuarios registrados aparecerán, además de los últimos artículos, artículos recomendados basados en sus favoritos.
