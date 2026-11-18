Ejercicio 14 - Administrador Único de Préstamos

Explicación del programa

En este ejercicio se creó una clase llamada AdministradorPrestamos que aplica el patrón Singleton para centralizar el control de préstamos de la biblioteca, asegurando que distintos mostradores compartan exactamente la misma instancia y eviten prestar el mismo ejemplar físico de forma simultánea, sin utilizar librerías externas ni imports.
La clase cuenta con:
- Una variable estática privada llamada instancia.
- Arreglos privados (ejemplares, socios, fechas, activo) y un contador (total) para gestionar la información de los préstamos de forma encapsulada.
- Un constructor privado para evitar la instanciación externa directa.
- Un método estático público llamado getInstancia() que devuelve siempre la misma referencia única.
- Métodos públicos para registrar préstamos con validación de disponibilidad, registrar devoluciones y consultar préstamos activos por socio.

Luego, dentro del método main, se simulan los dos mostradores obteniendo referencias al Singleton:
AdministradorPrestamos mostrador1 = AdministradorPrestamos.getInstancia();
AdministradorPrestamos mostrador2 = AdministradorPrestamos.getInstancia();

Finalmente, se utilizó System.out.println() para comprobar que ambas referencias apuntan al mismo objeto, demostrar que un préstamo realizado desde un mostrador impide prestar el mismo ejemplar desde el otro, y probar las reglas de devolución y consulta.

Lógica utilizada

La lógica del programa consiste en:
- Restringir la creación de objetos externos mediante un constructor privado.
- Controlar el acceso global a través de getInstancia() para garantizar que todos los mostradores operen sobre la misma colección de datos y estado.
- Aplicar validaciones lógicas para bloquear el préstamo de ejemplares ya ocupados y rechazar devoluciones inválidas de ejemplares sin préstamos activos.

Resultado de la ejecución

La ejecución del programa muestra en la consola lo siguiente:
¿Es la misma instancia?: true
Préstamo registrado exitosamente: Ejemplar EJ001 a Juan Perez

Intento de prestar el mismo ejemplar desde el mostrador 2:
Error: El ejemplar EJ001 ya se encuentra prestado a Juan Perez

--- Préstamos activos para el socio: Juan Perez ---
- Ejemplar ID: EJ001 | Fecha: 05/06/2026

Intentando devolver un ejemplar sin préstamo activo:
Error: El ejemplar EJ999 no existe en el sistema.

Realizando devolución del ejemplar EJ001 desde el mostrador 2:
Devolución exitosa: El ejemplar EJ001 ya está disponible.

Volviendo a prestar el ejemplar EJ001 a otro socio:
Préstamo registrado exitosamente: Ejemplar EJ001 a Ana Gomez

Captura de pantalla

<img width="953" height="584" alt="image" src="https://github.com/user-attachments/assets/67a3131e-4f89-43e3-bdb0-9090693151a2" />
