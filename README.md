@startuml
object Usuario
object LoginOverlay
object LoginUI
object AuthenticationManager
object SecurityContextHolder
object HttpSessionSecurityContextRepository
object UI

Usuario -> LoginOverlay : 1. ingresar credenciales
LoginOverlay -> LoginUI : 2. onLogin(event)
LoginUI -> AuthenticationManager : 3. authenticate(username, password)
AuthenticationManager --> LoginUI : 4. Authentication

LoginUI -> SecurityContextHolder : 5. createEmptyContext()\n6. setAuthentication(auth)
LoginUI -> HttpSessionSecurityContextRepository : 7. saveContext(context, req, res)

LoginUI -> UI : 8. navigate(Administrador/Youtuber)

LoginUI -> LoginOverlay : 9. setError(true)\n[si falla]
LoginUI -> LoginOverlay : 10. show("Usuario o contraseña incorrectos")
@enduml
