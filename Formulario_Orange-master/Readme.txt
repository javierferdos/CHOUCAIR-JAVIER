Nombre del Proyecto: PRUEBA_JAVIERFERNANDO
Descripción:
Este script automatiza el diligenciamiento del formulario de reclutamiento en la página:
https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

Requisitos del Sistema:
JDK: Versión 11.
Maven: Versión más actual (según disponibilidad).
Google Chrome: Actualizado a la última versión.

Instrucciones de Uso:
1. Ajustar los datos de prueba (opcional):
Si deseas personalizar los datos utilizados en la prueba, edita el archivo login.feature ubicado en:
Producs_Store/src/test/resources/login.feature

En este archivo puedes modificar los siguientes campos:

name: Nombre del candidato.
middleName: Segundo nombre del candidato.
lastName: Apellido del candidato.
vacant: Vacante a la que aplica.
email: Correo electrónico del candidato.
number: Número de contacto.
archive: Archivo adjunto (por ejemplo, currículum).
habilitates: Habilidades del candidato.
notes: Notas adicionales.
status: Estado del proceso de reclutamiento.

Nota: Este paso es opcional y no es obligatorio para ejecutar el script.

2. Ejecutar la clase principal:
Ejecuta la clase RunnerReclutamientoNuevoPersonal ubicada en:
Formulario_OrangeHRM/src/test/java/Runner/RunnerReclutamientoNuevoPersonal

Esta clase ejecutará todo el script de prueba.

3. Generar y visualizar el reporte:
Abrir CMD:

Accede a la carpeta donde descargaste el repositorio desde GitHub.
En la barra de direcciones de la carpeta, escribe cmd y presiona Enter.

2. Ejecutar pruebas con Maven:
mvn clean verify

Abrir el reporte:

Vuelve al explorador de archivos.
Navega a la ubicación:
Formulario_OrangeHRM/target/site/serenity/index
Abre el archivo index.html en tu navegador para visualizar el reporte.


