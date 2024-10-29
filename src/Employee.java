public class Employee {
    private final int id;
    private final String name;
    public double salary;
    private int department;
    public static int counter = 1;

    public Employee(String name, double salary, int department) {
        this.salary = salary;
        this.department = department;
        this.name = name;
        this.id = getCounter ();
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean equals(Object other) {
        if ( this.getClass () != other.getClass () ) {
            return false;
        }
        Employee employee2 = (Employee) other;
        return name.equals ( employee2.name ) && salary == employee2.salary && department == (employee2.department) && id == employee2.id;
    }

    public int hashCode() {
        return java.util.Objects.hash ( name ) + java.util.Objects.hash ( salary ) + java.util.Objects.hash ( department ) + java.util.Objects.hash ( id );
    }

    public String toString() {
        return id + "  " + name + "  " + salary + "  " + department + "  ";
    }
}
