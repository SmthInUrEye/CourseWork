public class EmployeeBook {

    Employee[] employee = new Employee[10];

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

    public void printInfo() {
        System.out.printf ( "%-5s%-25s%-15s%-5s%n", "№", "Name", "Salary", "Department" );
        for (Employee value : employee) {
            System.out.printf ( "%-5s", value.getId () );
            System.out.printf ( "%-25s", value.getName () );
            System.out.printf ( "%-15s", value.getSalary () );
            System.out.printf ( "%-5s", value.getDepartment () );
            System.out.println ();
        }
    }

    public double getMonthlyCosts() {
        double monthlyCosts = 0.0;
        for (Employee value : employee) {
            monthlyCosts += value.getSalary ();
        }
        return monthlyCosts;
    }

    public int findMinWageEmployeeId() {
        int minWageId = 0;
        for (Employee value : employee) {
            if ( value.getSalary () < employee[minWageId].getSalary () ) {
                minWageId = value.getId () - 1;
            }
        }
        return minWageId;
    }

    public int findMaxWageEmployeeId() {
        int maxWageId = 0;
        for (int i = 0; i < employee.length; i++) {
            if ( employee[i].getSalary () > employee[maxWageId].getSalary () ) {
                maxWageId = employee[i].getId () - 1;
            }
        }
        return maxWageId;
    }

    public double getAverageSalary() {
        return (getMonthlyCosts () / employee.length);
    }

    public void printNames() {
        System.out.println ( "Список сотрудников: " );
        for (Employee value : employee) {
            System.out.println ( " - " + value.getName () );
        }
    }

    public void getIndexedSalary(double indexationPercentage) {
        for (Employee value : employee) {
            value.setSalary ( value.getSalary () * indexationPercentage / 100 + value.getSalary () );
        }
    }

    public void printDepartmentInfo(int department) {
        System.out.println ( "Список сотрудников отдела № " + department );
        for (Employee value : employee) {
            if ( value.getDepartment () == department ) {
                System.out.println ( value.getId () + " " + value.getName () + " " + value.getSalary () );
            }
        }
    }

    public int findMinWageDepartmentEmployeeId(int department) {
        int minWageDepartmentId = 0;
        for (Employee value : employee) {
            if ( value.getDepartment () == department ) {
                minWageDepartmentId = value.getId () - 1;
                break;
            }
        }
        for (Employee value : employee) {
            if ( value.getDepartment () == department ) {
                if ( value.getSalary () < employee[minWageDepartmentId].getSalary () ) {
                    minWageDepartmentId = value.getId () - 1;
                }
            }
        }
        return minWageDepartmentId;
    }

    public int findMaxWageDepartmentEmployeeId(int department) {
        int maxWageDepartmentId = 0;
        for (Employee value : employee) {
            if ( value.getDepartment () == department ) {
                maxWageDepartmentId = value.getId () - 1;
                break;
            }
        }
        for (Employee value : employee) {
            if ( value.getDepartment () == department ) {
                if ( value.getSalary () > employee[maxWageDepartmentId].getSalary () ) {
                    maxWageDepartmentId = value.getId () - 1;
                }
            }
        }
        return maxWageDepartmentId;
    }

    public double getMonthlyDepartmentCosts(int department) {
        double monthlyDepartmentCosts = 0.0;
        for (Employee value : employee) {
            if ( value.getDepartment () == department ) {
                monthlyDepartmentCosts += value.getSalary ();
            }
        }
        return monthlyDepartmentCosts;
    }

    public double getAverageDepartmentCosts(int department) {
        double averageDepartmentCosts = 0.0;
        int departmentHeadcount = 0;
        for (Employee value : employee) {
            if ( value.getDepartment () == department ) {
                departmentHeadcount++;
            }
        }
        for (Employee value : employee)
            if ( value.getDepartment () == department )
                averageDepartmentCosts = getMonthlyDepartmentCosts ( department ) / departmentHeadcount;
        return averageDepartmentCosts;
    }

    public void getIndexedDepartmentSalary(int department, double indexationPercentage) {
        for (Employee value : employee) {
            if ( value.getDepartment () == department ) {
                value.setSalary ( value.getSalary () * indexationPercentage / 100 + value.getSalary () );
            }
        }
    }

    public void findEmployeesWithSmallerSalary(double salary) {
        System.out.println ( "Список сотрудников с зарплатой меньше " + salary );
        for (Employee value : employee) {
            if ( value.getSalary () < salary ) {
                System.out.printf ( "%-5s", value.getId () );
                System.out.printf ( "%-25s", value.getName () );
                System.out.printf ( "%-15s", value.getSalary () );
                System.out.println ();
            }
        }

    }

    public void findEmployeesWithBiggerSalary( double salary) {
        System.out.println ( "Список сотрудников с зарплатой больше " + salary );
        for (Employee value : employee) {
            if ( value.getSalary () > salary ) {
                System.out.printf ( "%-5s", value.getId () );
                System.out.printf ( "%-25s", value.getName () );
                System.out.printf ( "%-15s", value.getSalary () );
                System.out.println ();
            }
        }

    }

    public void addEmployee(String employeeName, double employeeSalary, int employeeDepartment) {
        for (int i = 0; i < employee.length; i++) {
            if ( employee[i] == null ) {
                employee[i] = new Employee ( employeeName, employeeSalary, employeeDepartment );
            }
        }
    }

    public void deleteEmployee(int id) {
        employee[id - 1] = null;
        System.gc ();
    }

    public void getEmployeeById(int id) {
        for (Employee value : employee) {
            if ( id == value.getId () ) {
                System.out.println ( value );
            }

        }
    }
}








