abstract class Empleado {
    private String nombre;
    private double salarioBase;

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalario();

    public String getNombre() {
        return nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public String toDataString() {
        return getClass().getSimpleName() + "|" + nombre + "|" + salarioBase;
    }

    public static Empleado fromDataString(String data) {
        String[] parts = data.split("\\|");
        String tipoEmpleado = parts[0];
        String nombre = parts[1];
        double salarioBase = Double.parseDouble(parts[2]);

        if (tipoEmpleado.equals("EmpleadoAsalariado")) {
            return new EmpleadoAsalariado(nombre, salarioBase);
        } else if (tipoEmpleado.equals("EmpleadoPorHoras")) {
            int horasTrabajadas = Integer.parseInt(parts[3]);
            return new EmpleadoPorHoras(nombre, salarioBase, horasTrabajadas);
        }
        return null;
    }
}