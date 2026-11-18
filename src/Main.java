public class Main {
    public static void main(String[] args) {
        // Simulando dos mostradores utilizando la misma instancia Singleton
        AdministradorPrestamos mostrador1 = AdministradorPrestamos.getInstancia();
        AdministradorPrestamos mostrador2 = AdministradorPrestamos.getInstancia();

        System.out.println("¿Es la misma instancia?: " + (mostrador1 == mostrador2));

        // 1. Registrar un préstamo desde el mostrador 1
        mostrador1.prestar("EJ001", "Juan Perez", "05/06/2026");

        // 2. Demostrar que el mostrador 2 NO puede prestar el mismo ejemplar
        System.out.println("\nIntento de prestar el mismo ejemplar desde el mostrador 2:");
        mostrador2.prestar("EJ001", "Ana Gomez", "05/06/2026");

        // 3. Consultar préstamos activos de un socio
        System.out.println();
        mostrador1.consultarPrestamosSocio("Juan Perez");

        // 4. Devolución de un ejemplar inexistente o sin préstamo activo (rechazado)
        System.out.println("\nIntentando devolver un ejemplar sin préstamo activo:");
        mostrador2.devolver("EJ999");

        // 5. Devolución correcta desde el mostrador 2 para liberar el ejemplar
        System.out.println("\nRealizando devolución del ejemplar EJ001 desde el mostrador 2:");
        mostrador2.devolver("EJ001");

        // 6. Ahora el mostrador 1 puede volver a prestarlo
        System.out.println("\nVolviendo a prestar el ejemplar EJ001 a otro socio:");
        mostrador1.prestar("EJ001", "Ana Gomez", "06/06/2026");
    }
}