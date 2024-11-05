public class Main {

    public static Employee[] employee = new Employee[10];

    public static void printInfo() {
        System.out.printf ( "%-5s%-25s%-15s%-5s%n", "№", "Name", "Salary", "Department" );
        for (Employee value : employee) {
            System.out.printf ( "%-5s", value.getId () );
            System.out.printf ( "%-25s", value.getName () );
            System.out.printf ( "%-15s", value.getSalary () );
            System.out.printf ( "%-5s", value.getDepartment () );
            System.out.println ();
        }
    }

    public static double getMonthlyCosts() {
        double monthlyCosts = 0.0;
        for (Employee value : employee) {
            monthlyCosts += value.getSalary ();
        }
        return monthlyCosts;
    }

    public static int findMinWageEmployeeId() {
        int minWageId = 0;
        for (Employee value : employee)
            if ( value.getSalary () < employee[minWageId].getSalary () ) {
                minWageId = value.getId () - 1;
            }
        return minWageId;
    }

    public static int findMaxWageEmployeeId() {
        int maxWageId = 0;
        for (Employee value : employee)
            if ( value.getSalary () > employee[maxWageId].getSalary () ) {
                maxWageId = value.getId () - 1;

        }
        return maxWageId;
    }

    public static double getAverageSalary() {
        return (getMonthlyCosts () / employee.length);
    }

    public static void printNames() {
        System.out.println ( "Список сотрудников: " );
        for (Employee value : employee) {
            System.out.println ( " - " + value.getName () );
        }
    }

    public static void main(String[] args) {

        employee[0] = new Employee ( "Иван Петрович", 25000.00, 1 );
        employee[1] = new Employee ( "Петр Иванович", 50000.00, 1 );
        employee[2] = new Employee ( "Оксана Викторовна", 100000.00, 2 );
        employee[3] = new Employee ( "Людмила Владимировна", 120000.00, 3 );
        employee[4] = new Employee ( "Антон Глебович", 150000.00, 4 );
        employee[5] = new Employee ( "Ринат Башаев", 100000.00, 5 );
        employee[6] = new Employee ( "Софья Анатольевна", 80000.00, 3 );
        employee[7] = new Employee ( "Виктор Степанович", 100000.00, 2 );
        employee[8] = new Employee ( "Талайбек Джайдахалиевич", 15000.00, 4 );
        employee[9] = new Employee ( "Артур Богданович", 90000.00, 5 );

        printInfo ();
        System.out.println ( "\nМесячные затраты на зарплату: " + getMonthlyCosts () );
        System.out.println ( "Минимальная зарпалата у сотрудника " + employee[findMinWageEmployeeId ()].getName () + " в размере " + employee[findMinWageEmployeeId ()].getSalary () );
        System.out.println ( "Максимальная зарпалата у сотрудника " + employee[findMaxWageEmployeeId ()].getName () + " в размере " + employee[findMaxWageEmployeeId ()].getSalary () );
        System.out.println ( "Средняя зарплата сотрудников: " + getAverageSalary () );
        printNames ();

    }
}




