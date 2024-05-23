# Proyecto BBDD

Este proyecto es un gestor de base de datos en Java que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en una tabla de usuarios. Está diseñado para interactuar con una base de datos MySQL.

## Tabla de Contenidos

- [Instalación](#instalación)
- [Uso](#uso)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Licencia](#licencia)
- [Contacto](#contacto)

## Instalación

1. **Clonar el repositorio:**

    ```bash
    git clone https://github.com/AlvaroSLuna/proyectoBBDD.git
    cd proyectoBBDD
    ```

2. **Configurar la base de datos:**

   - Asegúrate de tener MySQL instalado y en funcionamiento.
   - Crea una base de datos llamada `proyecto` en tu servidor MySQL.
   - Actualiza las constantes de conexión en el archivo `Conexion.java` si es necesario:
     ```java
     private static final String URL = "jdbc:mysql://localhost:3309/proyecto?allowPublicKeyRetrieval=true";
     private static final String USUARIO = "root";
     private static final String CLAVE = "123456789";
     ```
   - Las credenciales (usuario y clave) deben coincidir con las configuradas en tu servidor MySQL.

3. **Compilar el proyecto:**

   - Asegúrate de tener JDK instalado.
   - Compila los archivos `.java` desde la línea de comandos o usando tu IDE favorito.

## Uso

1. **Ejecutar la aplicación:**

    - Desde la línea de comandos:
      ```bash
      java BBDD.Main
      ```

2. **Interacción con la aplicación:**

    - El programa mostrará un menú con las siguientes opciones:
      1. Añadir Usuarios.
      2. Mostrar Usuarios.
      3. Editar Usuarios.
      4. Eliminar Usuarios.
      5. Mostrar Paises de Usuarios.
      6. Salir.

    - Sigue las instrucciones en pantalla para realizar las diferentes operaciones.

## Estructura del Proyecto

- `BBDD/Conexion.java`: Clase que maneja la conexión a la base de datos y las operaciones CRUD.
- `BBDD/Menu.java`: Clase que muestra el menú y gestiona la interacción con el usuario.
- `BBDD/Main.java`: Clase principal que inicia la aplicación.
- `BBDD/Usuario.java`: Clase que representa la entidad Usuario.
- `BBDD/Interfaces/ConexionesBaseDatos.java`: Interfaz que define los métodos para las operaciones en la base de datos.
- `BBDD/Interfaces/InterfazMenu.java`: Interfaz que define los métodos para el menú de la aplicación.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para obtener más información.

## Contacto

Alvaro Serrano Luna - (serranoalvaroluna@gmail.com)

