| Caso de Uso / Actor             | Clases Java relacionadas                                                                        | Notas                                                          |
| ------------------------------- | ----------------------------------------------------------------------------------------------- | -------------------------------------------------------------- |
| Inicio                          | `Inicio`, `Buscar`, `UltimosVideos`                                                             | Pantalla principal, incluye barra de búsqueda y últimos vídeos |
| Registrado                      | `Registrado`, `Youtuber`, `Administrador`                                                       | Actor registrado, abstracción para Youtuber y Admin            |
| NoLogueado                      | `NoLogueado`, `Login`, `Registrar`                                                              | Actor no registrado                                            |
| Administrador                   | `Administrador`, `PerfilAjenodeAdministrador`, `Usuariosdenunciados`, `VerVideodeAdministrador` | Funciones de administración                                    |
| Youtuber                        | `Youtuber`, `PerfilPropio`, `PublicarVideo`, `Configuracion`                                    | Funciones de usuario registrado                                |
| Buscar                          | `Buscar`, `ResultadodeBusqueda`, `GaleradeVideos_item`                                          | Búsqueda de vídeos por título                                  |
| Publicar Video                  | `PublicarVideo`, `PerfilPropio`                                                                 | Publicar nuevos vídeos                                         |
| Comentar                        | `Comentar`, `VerComentariosdeYoutuber`, `VerComentarios_item`                                   | Añadir comentarios en vídeos                                   |
| Like                            | `VerVideodeYoutuber`                                                                            | Dar o quitar "me gusta"                                        |
| Seguir / Dejar de seguir        | `PerfilAjenodeYoutuber`, `Youtubersseguidos_item`                                               | Gestión de seguimientos                                        |
| Denunciar                       | `PerfilAjenodeYoutuber`, `Usuariosdenunciados_item`                                             | Función de denuncias                                           |
| Ver Video                       | `VerVideo`, `Videosrelacionados_item`, `VerComentarios`                                         | Visualización de vídeo y comentarios                           |
| Últimos Videos de Administrador | `UltimosVideosdeAdministrador`, `UltimosVideosdeAdministrador_item`                             | Lista completa de vídeos                                       |
| Últimos Videos de Youtuber      | `UltimosVideosdeYoutuber`, `UltimosVideosdeYoutuber_item`                                       | Lista de vídeos de usuarios seguidos y propios                 |
| Lista de Vídeos                 | `ListadeVideos`, `ListadeVideos_item`                                                           | Para listas de vídeos en perfiles o secciones                  |
| Enviar Correo                   | `Registrar`, `ServidordeCorreo`                                                                 | Confirmación de registro vía email                             |
