pe01_PrimerExamenParcial.java

import java.util.ArrayList;
import java.util.Scanner;

public class EscuelaInscripcion {

    // Definición de constantes para los costos de inscripción
    private static final int COSTO_ALUMNO = 40;
    private static final int COSTO_DOCENTE = 60;
    private static final int COSTO_TRABAJADOR = 80;

    public static void main(String[] args) {
        // Crear una lista para almacenar los participantes
        ArrayList<Participante> participantes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Contadores y acumuladores para los cálculos
        int totalAlumnos = 0;
        int totalDocentes = 0;
        int totalTrabajadores = 0;
        int totalHombres = 0;
        int totalMujeres = 0;
        int totalRechazados = 0;
        int totalEdad = 0;
        int totalRecaudadoAlumnos = 0;
        int totalRecaudadoDocentes = 0;
        int totalRecaudadoTrabajadores = 0;

        while (true) {
            // Solicitar datos del participante
            System.out.println("Ingrese el nombre del participante (o 'salir' para terminar): ");
            String nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("salir")) break;

            System.out.println("Ingrese la edad del participante: ");
            int edad = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer del scanner

            System.out.println("Ingrese el sexo del participante (H/M): ");
            String sexo = scanner.nextLine();
            if (!sexo.equalsIgnoreCase("H") && !sexo.equalsIgnoreCase("M")) {
                System.out.println("Sexo inválido. Ingrese H para Hombre o M para Mujer.");
                continue;
            }

            System.out.println("Ingrese el tipo de participante (Alumno, Docente, Trabajador): ");
            String tipoParticipante = scanner.nextLine();

            // Validar la edad del participante
            if (edad < 23) {
                System.out.println("El participante ha sido rechazado por no cumplir con la edad mínima.");
                totalRechazados++;
                continue;
            }

            // Crear un nuevo objeto Participante
            Participante participante = new Participante(nombre, edad, sexo, tipoParticipante);

            // Mostrar mensaje de bienvenida
            System.out.println("Bienvenido " + participante.getNombre() + "!");
            System.out.println("Edad: " + participante.getEdad());
            System.out.println("Sexo: " + participante.getSexo());
            System.out.println("Tipo de Participante: " + participante.getTipoParticipante());

            // Contar y acumular datos
            switch (participante.getTipoParticipante().toLowerCase()) {
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

            // Contar sexo
            if (participante.getSexo().equalsIgnoreCase("H")) {
                totalHombres++;
            } else {
                totalMujeres++;
            }

            // Acumulación de datos
            totalEdad += participante.getEdad();
            participantes.add(participante);
        }

        // Cálculo de totales
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

        // Mensaje final basado en el total recaudado
        if (totalRecaudadoGeneral < 50) {
            System.out.println("El evento concluye con ganancias BAJAS.");
        } else if (totalRecaudadoGeneral < 1000) {
            System.out.println("El evento concluye con ganancias MODERADAS.");
        } else {
            System.out.println("El evento concluye con BUENAS ganancias.");
        }

        scanner.close();
    }
}

// Clase que representa a un participante
class Participante {
    private String nombre;
    private int edad;
    private String sexo;
    private String tipoParticipante;

    public Participante(String nombre, int edad, String sexo, String tipoParticipante) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.tipoParticipante = tipoParticipante;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTipoParticipante() {
        return tipoParticipante;
    }
}
