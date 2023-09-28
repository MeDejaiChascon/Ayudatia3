class EmpleadoPorHoras extends Empleado {
    private double salarioPorHora;
    private int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, double salarioPorHora, int horasTrabajadas) {
        super(nombre, 0);
        this.salarioPorHora = salarioPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }
    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
    @Override
    public double calcularSalario() {
        return salarioPorHora * horasTrabajadas;
    }
}