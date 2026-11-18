public class AdministradorPrestamos {
    private static AdministradorPrestamos instancia;
    private String[] ejemplares;
    private String[] socios;
    private String[] fechas;
    private boolean[] activo;
    private int total;

    private AdministradorPrestamos() {
        this.ejemplares = new String[5];
        this.socios = new String[5];
        this.fechas = new String[5];
        this.activo = new boolean[5];
        this.total = 0;
    }

    public static AdministradorPrestamos getInstancia() {
        if (instancia == null) {
            instancia = new AdministradorPrestamos();
        }
        return instancia;
    }

    public void prestar(String idEjemplar, String socio, String fecha) {
        if (idEjemplar == null || idEjemplar.isEmpty() || socio == null || socio.isEmpty()) {
            System.out.println("Error: Datos incompletos.");
            return;
        }

        // Buscar si el ejemplar ya está registrado
        for (int i = 0; i < total; i++) {
            if (ejemplares[i].equals(idEjemplar)) {
                if (activo[i]) {
                    System.out.println("Error: El ejemplar " + idEjemplar + " ya se encuentra prestado a " + socios[i]);
                    return;
                } else {
                    // Reactivar el préstamo si el ejemplar ya existía pero estaba devuelto
                    socios[i] = socio;
                    fechas[i] = fecha;
                    activo[i] = true;
                    System.out.println("Préstamo registrado exitosamente: Ejemplar " + idEjemplar + " a " + socio);
                    return;
                }
            }
        }

        // Si no existe, agregarlo como nuevo registro
        if (total < 5) {
            ejemplares[total] = idEjemplar;
            socios[total] = socio;
            fechas[total] = fecha;
            activo[total] = true;
            total++;
            System.out.println("Préstamo registrado exitosamente: Ejemplar " + idEjemplar + " a " + socio);
        } else {
            System.out.println("Error: Capacidad máxima del administrador alcanzada.");
        }
    }

    public void devolver(String idEjemplar) {
        for (int i = 0; i < total; i++) {
            if (ejemplares[i].equals(idEjemplar)) {
                if (activo[i]) {
                    activo[i] = false;
                    System.out.println("Devolución exitosa: El ejemplar " + idEjemplar + " ya está disponible.");
                    return;
                } else {
                    System.out.println("Error: El ejemplar " + idEjemplar + " no tiene un préstamo activo.");
                    return;
                }
            }
        }
        System.out.println("Error: El ejemplar " + idEjemplar + " no existe en el sistema.");
    }

    public void consultarPrestamosSocio(String socioBuscado) {
        System.out.println("--- Préstamos activos para el socio: " + socioBuscado + " ---");
        boolean encontrado = false;
        for (int i = 0; i < total; i++) {
            if (socios[i] != null && socios[i].equals(socioBuscado) && activo[i]) {
                System.out.println("- Ejemplar ID: " + ejemplares[i] + " | Fecha: " + fechas[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No posee préstamos activos.");
        }
    }
}