import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String ARCHIVO_EMPLEADOS = "empleados.txt";

    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();
        cargarEmpleadosDesdeArchivo(empleados);

        for (Empleado empleado : empleados) {
            if (empleado instanceof EmpleadoPorHoras) {
                EmpleadoPorHoras empleadoPorHoras = (EmpleadoPorHoras) empleado;
                System.out.println("Nombre: " + empleado.getNombre());
                System.out.println("Tipo: Empleado por Horas");
                System.out.println("Salario: " + empleadoPorHoras.calcularSalario());
                System.out.println("--------------------");
            } else if (empleado instanceof EmpleadoAsalariado) {
                EmpleadoAsalariado empleadoAsalariado = (EmpleadoAsalariado) empleado;
                System.out.println("Nombre: " + empleado.getNombre());
                System.out.println("Tipo: Empleado Asalariado");
                System.out.println("Salario: " + empleadoAsalariado.calcularSalario());
                System.out.println("--------------------");
            }
        }
    }

    private static void cargarEmpleadosDesdeArchivo(List<Empleado> empleados) {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_EMPLEADOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("Leyendo linea: " + linea);
                Empleado empleado = Empleado.fromDataString(linea);
                if (empleado != null) {
                    empleados.add(empleado);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}