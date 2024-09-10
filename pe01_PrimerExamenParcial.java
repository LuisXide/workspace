pe01_PrimerExamenParcial.java

import java.util.Scanner;

public class EscuelaInscripcion {

    private static final int COSTO_ALUMNO = 40;
    private static final int COSTO_DOCENTE = 60;
    private static final int COSTO_TRABAJADOR = 80;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Contadores y acumuladores
        int totalAlumnos = 0, totalDocentes = 0, totalTrabajadores = 0;
        int totalHombres = 0, totalMujeres = 0, totalRechazados = 0;
        int totalEdad = 0, totalRecaudadoAlumnos = 0, totalRecaudadoDocentes = 0, totalRecaudadoTrabajadores = 0;

        while (true) {
            String nombre = leerNombre(scanner);
            if (nombre.equalsIgnoreCase("salir")) break;

            int edad = leerEdad(scanner);
            if (edad < 0) continue; // Error en la edad

            String sexo = leerSexo(scanner);
            if (sexo == null) continue; // Error en el sexo

            String tipoParticipante = leerTipoParticipante(scanner);
            if (tipoParticipante == null) continue; // Error en el tipo de participante

            // Validar edad
            if (edad < 23) {
                System.out.println("El participante ha sido rechazado por no cumplir con la edad mínima.");
                totalRechazados++;
                continue;
            }

            // Contar y acumular datos
            switch (tipoParticipante.toLowerCase()) {
                case "alumno":
                    totalAlumnos++;
                    totalRecaudadoAlumnos += COSTO_ALUMNO;
                    break;
                case "docente":
                    totalDocentes++;
                    totalRecaudadoDocentes += COSTO_DOCENTE;
                    break;
                case "trabajador":
                    totalTrabajadores++;
                    totalRecaudadoTrabajadores += COSTO_TRABAJADOR;
                    break;
                default:
                    System.out.println("Tipo de participante inválido.");
                    continue;
            }

            if (sexo.equalsIgnoreCase("H")) {
                totalHombres++;
            } else {
                totalMujeres++;
            }

            totalEdad += edad;
        }

        // Calcular resultados
        int totalParticipantes = totalAlumnos + totalDocentes + totalTrabajadores;
        int totalRecaudadoGeneral = totalRecaudadoAlumnos + totalRecaudadoDocentes + totalRecaudadoTrabajadores;
        double promedioEdad = totalParticipantes > 0 ? (double) totalEdad / totalParticipantes : 0;

        // Mostrar resultados
        System.out.println("Total de Alumnos: " + totalAlumnos);
        System.out.println("Total de Docentes: " + totalDocentes);
        System.out.println("Total de Trabajadores: " + totalTrabajadores);
        System.out.println("Total de Hombres: " + totalHombres);
        System.out.println("Total de Mujeres: " + totalMujeres);
        System.out.println("Total de Participantes: " + totalParticipantes);
        System.out.println("Promedio de Edad de los Participantes: " + promedioEdad);
        System.out.println("Total de Rechazados: " + totalRechazados);
        System.out.println("Total Recaudado de Alumnos: " + totalRecaudadoAlumnos);
        System.out.println("Total Recaudado de Docentes: " + totalRecaudadoDocentes);
        System.out.println("Total Recaudado de Trabajadores: " + totalRecaudadoTrabajadores);
        System.out.println("Total Recaudado General: " + totalRecaudadoGeneral);

        // Mensaje final
        if (totalRecaudadoGeneral < 50) {
            System.out.println("El evento concluye con ganancias BAJAS.");
        } else if (totalRecaudadoGeneral < 1000) {
            System.out.println("El evento concluye con ganancias MODERADAS.");
        } else {
            System.out.println("El evento concluye con BUENAS ganancias.");
        }

        scanner.close();
    }

    private static String leerNombre(Scanner scanner) {
        System.out.println("Ingrese el nombre del participante (o 'salir' para terminar): ");
        return scanner.nextLine();
    }

    private static int leerEdad(Scanner scanner) {
        System.out.println("Ingrese la edad del participante: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Edad inválida. Intente de nuevo.");
            return -1;
        }
    }

    private static String leerSexo(Scanner scanner) {
        System.out.println("Ingrese el sexo del participante (H/M): ");
        String sexo = scanner.nextLine();
        if (sexo.equalsIgnoreCase("H") || sexo.equalsIgnoreCase("M")) {
            return sexo;
        } else {
            System.out.println("Sexo inválido. Ingrese H para Hombre o M para Mujer.");
            return null;
        }
    }

    private static String leerTipoParticipante(Scanner scanner) {
        System.out.println("Ingrese el tipo de participante (Alumno, Docente, Trabajador): ");
        String tipo = scanner.nextLine();
        if (tipo.equalsIgnoreCase("Alumno") || tipo.equalsIgnoreCase("Docente") || tipo.equalsIgnoreCase("Trabajador")) {
            return tipo;
        } else {
            System.out.println("Tipo de participante inválido. Ingrese Alumno, Docente o Trabajador.");
            return null;
        }
    }
}
