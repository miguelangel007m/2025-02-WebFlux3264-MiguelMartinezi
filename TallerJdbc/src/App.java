import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        EstudianteDAO dao = new EstudianteDAO();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU ESTUDIANTES ---");
            System.out.println("1. Insertar Estudiante");
            System.out.println("2. Actualizar Estudiante");
            System.out.println("3. Eliminar Estudiante");
            System.out.println("4. Consultar todos los Estudiantes");
            System.out.println("5. Consultar Estudiante por email");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Correo: ");
                    String correo = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt(); sc.nextLine();
                    System.out.print("Estado civil (SOLTERO, CASADO, VIUDO, UNION_LIBRE, DIVORCIADO): ");
                    String estado = sc.nextLine();
                    dao.insertar(new Estudiante(nombre, apellido, correo, edad, estado));
                    break;

                case 2:
                    System.out.print("Correo del estudiante a actualizar: ");
                    correo = sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Nuevo apellido: ");
                    apellido = sc.nextLine();
                    System.out.print("Nueva edad: ");
                    edad = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo estado civil: ");
                    estado = sc.nextLine();
                    dao.actualizar(new Estudiante(nombre, apellido, correo, edad, estado));
                    break;

                case 3:
                    System.out.print("Correo del estudiante a eliminar: ");
                    correo = sc.nextLine();
                    dao.eliminar(correo);
                    break;

                case 4:
                    List<Estudiante> lista = dao.consultarTodos();
                    for (Estudiante e : lista) {
                        System.out.println(e.getId() + " - " + e.getNombre() + " " + e.getApellido() +
                                " | " + e.getCorreo() + " | " + e.getEdad() + " años | " + e.getEstadoCivil());
                    }
                    break;

                case 5:
                    System.out.print("Correo a buscar: ");
                    correo = sc.nextLine();
                    Estudiante est = dao.consultarPorCorreo(correo);
                    if (est != null) {
                        System.out.println(est.getId() + " - " + est.getNombre() + " " + est.getApellido() +
                                " | " + est.getCorreo() + " | " + est.getEdad() + " años | " + est.getEstadoCivil());
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}
