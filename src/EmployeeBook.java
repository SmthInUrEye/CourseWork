public class EmployeeBook {

    Employee[] employee = new Employee[10];
    int[] freeIds = new int[10];

    public void getInit() {
        this.employee[0] = new Employee ( "Иван Петрович", 25000.00, 1 );
        this.employee[1] = new Employee ( "Петр Иванович", 50000.00, 1 );
        this.employee[2] = new Employee ( "Оксана Викторовна", 130000.00, 2 );
        this.employee[3] = new Employee ( "Людмила Владимировна", 120000.00, 3 );
        this.employee[4] = new Employee ( "Антон Глебович", 150000.00, 4 );
        this.employee[5] = new Employee ( "Ринат Башаев", 20000.00, 5 );
        this.employee[6] = new Employee ( "Софья Анатольевна", 80000.00, 3 );
        this.employee[7] = new Employee ( "Виктор Степанович", 100000.00, 2 );
        this.employee[8] = new Employee ( "Талайбек Джайдахалиевич", 15000.00, 4 );
        this.employee[9] = new Employee ( "Артур Богданович", 90000.00, 5 );
    }

    public void printInfo(Employee[] employees) {
        System.out.printf ( "%-5s%-25s%-15s%-5s%n", "№", "Name", "Salary", "Department" );
        for (int i = 0; i < employees.length; i++) {
            System.out.printf ( "%-5s", employees[i].getId () );
            System.out.printf ( "%-25s", employees[i].getName () );
            System.out.printf ( "%-15s", employees[i].getSalary () );
            System.out.printf ( "%-5s", employees[i].getDepartment () );
            System.out.println ();
        }
    }

    public double getMonthlyCosts(Employee[] employees) {
        double monthlyCosts = 0.0;
        for (int i = 0; i < employees.length; i++) {
            monthlyCosts += employees[i].getSalary ();
        }
        return monthlyCosts;
    }

    public int findMinWageEmployeeId(Employee[] employees) {
        int MinWageId = 0;
        for (int i = 0; i < employees.length; i++) {
            if ( employees[i].getSalary () < employees[MinWageId].getSalary () ) {
                MinWageId = employees[i].getId () - 1;
            }
        }
        return MinWageId;
    }

    public int findMaxWageEmployeeId(Employee[] employees) {
        int MaxWageId = 0;
        for (int i = 0; i < employees.length; i++) {
            if ( employees[i].getSalary () > employees[MaxWageId].getSalary () ) {
                MaxWageId = employees[i].getId () - 1;
            }
        }
        return MaxWageId;
    }

    public double getAverageSalary(Employee[] employees) {
        return (getMonthlyCosts ( employees ) / employees.length);
    }

    public void printNames(Employee[] employees) {
        System.out.println ( "Список сотрудников: " );
        for (int i = 0; i < employees.length; i++) {
            System.out.println ( " - " + employees[i].getName () );
        }
    }

    public void getIndexedSalary(Employee[] employees, double indexationPercentage) {
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary ( employees[i].getSalary () * indexationPercentage / 100 + employees[i].getSalary () );
        }
    }

    public void printDepartmentInfo(Employee[] employees, int department) {
        System.out.println ( "Список сотрудников отдела № " + department );
        for (int i = 0; i < employees.length; i++) {
            if ( employees[i].getDepartment () == department ) {
                System.out.println ( employees[i].getId () + " " + employees[i].getName () + " " + employees[i].getSalary () );
            }
        }
    }

    public int findMinWageDepartmentEmployeeId(Employee[] employees, int department) {
        int MinWageDepartmentId = 0;
        for (int i = 0; i < employees.length; i++) {
            if ( employees[i].getDepartment () == department ) {
                MinWageDepartmentId = employees[i].getId () - 1;
                break;
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if ( employees[i].getDepartment () == department ) {
                if ( employees[i].getSalary () < employees[MinWageDepartmentId].getSalary () ) {
                    MinWageDepartmentId = employees[i].getId () - 1;
                }
            }
        }
        return MinWageDepartmentId;
    }

    public int findMaxWageDepartmentEmployeeId(Employee[] employees, int department) {
        int MaxWageDepartmentId = 0;
        for (int i = 0; i < employees.length; i++) {
            if ( employees[i].getDepartment () == department ) {
                MaxWageDepartmentId = employees[i].getId () - 1;
                break;
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if ( employees[i].getDepartment () == department ) {
                if ( employees[i].getSalary () > employees[MaxWageDepartmentId].getSalary () ) {
                    MaxWageDepartmentId = employees[i].getId () - 1;
                }
            }
        }
        return MaxWageDepartmentId;
    }

    public double getMonthlyDepartmentCosts(Employee[] employees, int department) {
        double monthlyDepartmentCosts = 0.0;
        for (int i = 0; i < employees.length; i++) {
            if ( employees[i].getDepartment () == department ) {
                monthlyDepartmentCosts += employees[i].getSalary ();
            }
        }
        return monthlyDepartmentCosts;
    }

    public double getAverageDepartmentCosts(Employee[] employees, int department) {
        double averageDepartmentCosts = 0.0;
        int departmentHeadcount = 0;
        for (int i = 0; i < employees.length; i++) {
            if ( employees[i].getDepartment () == department ) {
                departmentHeadcount++;
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if ( employees[i].getDepartment () == department ) {
                averageDepartmentCosts = getMonthlyDepartmentCosts ( employees, department ) / departmentHeadcount;
            }
        }
        return averageDepartmentCosts;
    }

    public void getIndexedDepartmentSalary(Employee[] employees, int department, double indexationPercentage) {
        for (int i = 0; i < employees.length; i++) {
            if ( employees[i].getDepartment () == department ) {
                employees[i].setSalary ( employees[i].getSalary () * indexationPercentage / 100 + employees[i].getSalary () );
            }
        }
    }

    public void findEmployeesWithSmallerSalary(Employee[] employees, double salary) {
        System.out.println ( "Список сотрудников с зарплатой меньше " + salary );
        for (int i = 0; i < employees.length; i++) {
            if ( employees[i].getSalary () < salary ) {
                System.out.printf ( "%-5s", employees[i].getId () );
                System.out.printf ( "%-25s", employees[i].getName () );
                System.out.printf ( "%-15s", employees[i].getSalary () );
                System.out.println ();
            }
        }

    }

    public void findEmployeesWithBiggerSalary(Employee[] employees, double salary) {
        System.out.println ( "Список сотрудников с зарплатой больше " + salary );
        for (int i = 0; i < employees.length; i++) {
            if ( employees[i].getSalary () > salary ) {
                System.out.printf ( "%-5s", employees[i].getId () );
                System.out.printf ( "%-25s", employees[i].getName () );
                System.out.printf ( "%-15s", employees[i].getSalary () );
                System.out.println ();
            }
        }

    }

    public void addEmployee(Employee[] employees, String EmployeeName, double EmployeeSalary, int EmployeeDepartment) {
        for (int i = 0; i < employees.length; i++) {
            if ( employees[i] == null ) {
                employees[i] = new Employee ( EmployeeName, EmployeeSalary, EmployeeDepartment );
            }
        }
    }

    public void deleteEmployee(Employee[] employees, int id) {
        employee[id - 1] = null;
        System.gc ();
    }

    public void getEmployeeById(Employee[] employees, int id) {
        for (int i = 0; i < employees.length; i++) {
            if ( id == employees[i].getId () ) {
                System.out.println ( employees[i] );
            }

        }
    }
}








