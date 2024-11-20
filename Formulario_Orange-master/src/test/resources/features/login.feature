Feature: Proceso de incorporación de un nuevo empleado
  Scenario: Validación del proceso de incorporación de un empleado
    Given El usuario accede a la plataforma Orange HRM
    When El usuario inicia sesión con las credenciales correspondientes "Admin" "admin123"
    Then Una vez en la pantalla principal, el usuario selecciona el módulo Recruitment y hace clic en el botón Add
    When Al presionar el botón Add, el usuario completa el formulario con la información requerida
      | name            | Javier             |
      | middleName      | Fernando              |
      | lastName        | prueba              |
      | vacant          | test                 |
      | email           | JefeMaestro@gmail.com    |
      | number          | 314256987            |
      | archive         | No                    |
      | habilitates     | web,java,selenium     |
      | notes           | prueba javier fer        |
    And despues el usuario va al modulo nuevamente y verifica que si este el registro y verifica que los datos sean correctos
      | name            | Javier              |
      | middleName      | Fernando              |
      | lastName        | prueba              |
      | vacant          | test                 |
      | status          | Application Initiated |
