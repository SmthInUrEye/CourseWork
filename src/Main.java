public class Main {

    public static void printInfo(Employee[] employees) {
        System.out.printf ( "%-5s%-25s%-15s%-5s%n", "№", "Name", "Salary", "Department" );
        for (int i = 0; i < employees.length; i++) {
            System.out.printf ( "%-5s", employees[i].getId () );
            System.out.printf ( "%-25s", employees[i].getName () );
            System.out.printf ( "%-15s", employees[i].getSalary () );
            System.out.printf ( "%-5s", employees[i].getDepartment () );
            System.out.println ();
        }
    }

    public static double getMonthlyCosts(Employee[] employees) {
        double monthlyCosts = 0.0;
        for (int i = 0; i < employees.length; i++) {
            monthlyCosts += employees[i].getSalary ();
        }
        return monthlyCosts;
    }

    public static int findMinWageEmployeeId(Employee[] employees) {
        int MinWageId = 0;
        for (int i = 0; i < employees.length; i++) {
            if ( employees[i].getSalary () < employees[MinWageId].getSalary () ) {
                MinWageId = employees[i].getId () - 1;
            }
        }
        return MinWageId;
    }

    public static int findMaxWageEmployeeId(Employee[] employees) {
        int MaxWageId = 0;
        for (Employee employee : employees) {
            if ( employee.getSalary () > employees[MaxWageId].getSalary () ) {
                MaxWageId = employee.getId () - 1;
            }
        }
        return MaxWageId;
    }

    public static double getAverageSalary(Employee[] employees) {
        return (getMonthlyCosts ( employees ) / employees.length);
    }

    public static void printNames(Employee[] employees) {
        System.out.println ( "Список сотрудников: " );
        for (int i = 0; i < employees.length; i++) {
            System.out.println ( " - " + employees[i].getName () );
        }
    }

    public static void main(String[] args) {

        Employee[] employee = new Employee[10];
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

        printInfo ( employee );
        System.out.println ( "\nМесячные затраты на зарплату: " + getMonthlyCosts ( employee ) );
        System.out.println ( "Минимальная зарпалата у сотрудника " + employee[findMinWageEmployeeId ( employee )].getName () + " в размере " + employee[findMinWageEmployeeId ( employee )].getSalary () );
        System.out.println ( "Максимальная зарпалата у сотрудника " + employee[findMaxWageEmployeeId ( employee )].getName () + " в размере " + employee[findMaxWageEmployeeId ( employee )].getSalary () );
        System.out.println ( "Средняя зарплата сотрудников: " + getAverageSalary ( employee ) );
        printNames ( employee );

    }
}




