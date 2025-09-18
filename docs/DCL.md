```mermaid
classDiagram
    class Administrador {
        +iAdministrador
        +Usuariosdenunciados()
        +Administrador(iAdministrador)
        +UltimosVideos()
    }
    
    class Buscar {
        -textobuscar
        +botonbuscar
        +ResultadodeBusqueda()
        -buscar()
    }

    class Comentar {
        -campoComentario
        +id
        +Comentar(iYoutuber)
        +setParameter(event, parameter)
        -publicar_comentario()
    }

    class Configuracion {
        -imagenDeFondo
        -avatar
        -password
        +Configuracion(iYoutuber)
        -actualizar(iYoutuber)
    }

    class GaleradeVideos {
        +tituloGaleria
        +GaleradeVideos(videos)
    }

    class GaleradeVideos_item {
        +VerVideo()
        +GaleradeVideos_item(video)
    }

    class Inicio {
        +Buscar()
        +UltimosVideos()
    }

    class ListadeVideos {
        +ListadeVideos(videos)
    }

    class ListadeVideos_item {
        +VerVideo()
        +ListadeVideos_item(video)
    }

    class Login
    class NoLogueado
    class Perfil
    class PerfilAjeno
    class PerfilAjenodeAdministrador
    class PerfilAjenodeYoutuber
    class PerfilPropio
    class PublicarVideo
    class Registrado
    class Registrar
    class ResultadodeBusqueda
    class ServidordeCorreo
    class UltimosVideos
    class Usuariosdenunciados
    class VerComentarios
    class VerComentariosdeAdministrador
    class VerComentariosdeYoutuber
    class VerVideo
    class VerVideodeAdministrador
    class VerVideodeYoutuber
    class Videosgustados
    class Videospublicados
    class Videosrelacionados
    class Youtuber
    class Youtubersseguidos

    %% Relaciones
    GaleradeVideos_item --> VerVideo
    GaleradeVideos --> "*" GaleradeVideos_item
    ListadeVideos_item --> VerVideo
    ListadeVideos --> "*" ListadeVideos_item
    VerVideo --> VerComentarios
    VerVideo --> Videosrelacionados
    Perfil --> Videosgustados
    Perfil --> Videospublicados
    Perfil --> Youtubersseguidos
    PerfilPropio --> Configuracion
    PerfilPropio --> PublicarVideo
    Registrado <|-- Youtuber
    Registrado <|-- Administrador
    NoLogueado --> Login
```
    NoLogueado --> Registrar
    Registrar --> ServidordeCorreo
