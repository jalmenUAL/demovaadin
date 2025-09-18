| Tipo      | Name                                     | Transit To                                                                 |
|-----------|------------------------------------------|--------------------------------------------------------------------------|
| Diagram   | uc_youtube                               |                                                                          |
| Use Case  | Ultimos Videos de Administrador           | com.example.demo.views.UltimosVideosdeAdministrador_item, com.example.demo.views.UltimosVideosdeAdministrador |
| Use Case  | Ultimos Videos de Youtuber               | com.example.demo.views.UltimosVideosdeYoutuber_item, com.example.demo.views.UltimosVideosdeYoutuber |
| Use Case  | Bloquear                                  | com.example.demo.views.PerfilAjenodeAdministrador.Bloquear             |
| Use Case  | Perfil Ajeno de Administrador             | com.example.demo.views.PerfilAjenodeAdministrador                        |
| Use Case  | Perfil Ajeno de Youtuber                  | com.example.demo.views.PerfilAjenodeYoutuber                              |
| Actor     | Inicio                                    | com.example.demo.service.iInicio, com.example.demo.views.Inicio          |
| Actor     | Registrado                                | com.example.demo.service.iRegistrado, com.example.demo.views.Registrado  |
| Use Case  | Perfil                                    | com.example.demo.views.Perfil                                             |
| Use Case  | Perfil Propio                             | com.example.demo.views.PerfilPropio, com.example.demo.views.Youtuber.PerfilPropio |
| Use Case  | Enviar Correo                             | com.example.demo.views.Registrar.EnviarCorreo                             |
| Actor     | Servidor de Correo                         | com.example.demo.views.ServidordeCorreo                                   |
| Use Case  | Registrar                                 | com.example.demo.views.Registrar, com.example.demo.views.NoLogueado.Registrar |
| Use Case  | Lista de Videos                            | com.example.demo.views.ListadeVideos_item, com.example.demo.views.ListadeVideos |
| Use Case  | Seguir                                     | com.example.demo.views.PerfilAjenodeYoutuber.Seguir                      |
| Use Case  | Usuarios denunciados                       | com.example.demo.views.Usuariosdenunciados_item, com.example.demo.views.Usuariosdenunciados, com.example.demo.views.Administrador.Usuariosdenunciados |
| Use Case  | Denunciar                                  | com.example.demo.views.PerfilAjenodeYoutuber.Denunciar                   |
| Use Case  | Youtubers seguidos                          | com.example.demo.views.Youtubersseguidos_item, com.example.demo.views.Youtubersseguidos |
| Use Case  | Galería de Videos                           | com.example.demo.views.GaleradeVideos_item, com.example.demo.views.GaleradeVideos |
| Use Case  | Perfil Ajeno                                | com.example.demo.views.PerfilAjeno, com.example.demo.views.VerVideo.PerfilAjeno, com.example.demo.views.VerComentarios_item.PerfilAjeno, com.example.demo.views.Youtubersseguidos_item.PerfilAjeno |
| Use Case  | Videos publicados                           | com.example.demo.views.Videospublicados_item, com.example.demo.views.Videospublicados |
| Use Case  | Videos gustados                             | com.example.demo.views.Videosgustados_item, com.example.demo.views.Videosgustados |
| Use Case  | Publicar Video                              | com.example.demo.views.PublicarVideo, com.example.demo.views.PerfilPropio.PublicarVideo |
| Use Case  | Comentar                                    | com.example.demo.views.Comentar                                           |
| Use Case  | eliminar                                    | com.example.demo.views.VerComentariosdeAdministrador_item.eliminar        |
| Use Case  | Ver Comentarios de Youtuber                 | com.example.demo.views.VerComentariosdeYoutuber_item, com.example.demo.views.VerComentariosdeYoutuber |
| Use Case  | Ver Comentarios de Administrador            | com.example.demo.views.VerComentariosdeAdministrador_item, com.example.demo.views.VerComentariosdeAdministrador |
| Use Case  | Ver Comentarios                             | com.example.demo.views.VerComentarios_item, com.example.demo.views.VerComentarios, com.example.demo.views.VerVideo.VerComentarios |
| Use Case  | like                                        | com.example.demo.views.VerVideodeYoutuber.like                             |
| Use Case  | borrar                                      | com.example.demo.views.VerVideodeAdministrador.borrar                      |
| Use Case  | Videos relacionados                         | com.example.demo.views.Videosrelacionados_item, com.example.demo.views.Videosrelacionados, com.example.demo.views.VerVideo.Videosrelacionados |
| Use Case  | Ver Video de Administrador                  | com.example.demo.views.VerVideodeAdministrador                             |
| Use Case  | Ver Video de Youtuber                        | com.example.demo.views.VerVideodeYoutuber                                   |
| Use Case  | Ver Video                                   | com.example.demo.views.VerVideo, com.example.demo.views.Videosrelacionados_item.VerVideo, com.example.demo.views.ListadeVideos_item.VerVideo, com.example.demo.views.GaleradeVideos_item.VerVideo |
| Use Case  | Resultado de Busqueda                       | com.example.demo.views.ResultadodeBusqueda_item, com.example.demo.views.ResultadodeBusqueda |
| Use Case  | Configuracion                               | com.example.demo.views.Configuracion, com.example.demo.views.PerfilPropio.Configuracion |
| Use Case  | Buscar                                      | com.example.demo.views.Buscar, com.example.demo.views.Inicio.Buscar       |
| Use Case  | Logout                                      | com.example.demo.views.Registrado.Logout                                   |
| Use Case  | Login                                       | com.example.demo.views.Login, com.example.demo.views.NoLogueado.Login      |
| Use Case  | Ultimos Videos                               | com.example.demo.views.UltimosVideos_item, com.example.demo.views.UltimosVideos, com.example.demo.views.Inicio.UltimosVideos |
| Actor     | Administrador                               | com.example.demo.service.iAdministrador, com.example.demo.views.Administrador |
| Actor     | Youtuber                                    | com.example.demo.service.iYoutuber, com.example.demo.views.Youtuber       |
| Actor     | NoLogueado                                  | com.example.demo.service.iNoLogueado, com.example.demo.views.NoLogueado   |
