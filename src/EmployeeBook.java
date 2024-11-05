public class EmployeeBook {

    Employee[] employee = new Employee[10];

    public void getInit() {
        this.employee[0] = new Employee ( "Иван Петрович", 25000.00, 5 );
        this.employee[1] = new Employee ( "Петр Иванович", 50000.00, 1 );
        this.employee[2] = new Employee ( "Оксана Викторовна", 130000.00, 2 );
        this.employee[3] = new Employee ( "Людмила Владимировна", 121000.00, 3 );
        this.employee[4] = new Employee ( "Антон Глебович", 150000.00, 4 );
        this.employee[5] = new Employee ( "Ринат Башаев", 20000.00, 5 );
        this.employee[6] = new Employee ( "Софья Анатольевна", 80000.00, 3 );
        this.employee[7] = new Employee ( "Виктор Степанович", 100000.00, 2 );
        this.employee[8] = new Employee ( "Талайбек Джайдахалиевич", 15000.00, 5 );
        this.employee[9] = new Employee ( "Артур Богданович", 10000.00, 5 );
    }

    public void printInfo() {
        System.out.printf ( "%-5s%-25s%-15s%-5s%n", "№", "Name", "Salary", "Department" );
        for (Employee employeer : employee) {
            System.out.printf ( "%-5s", employeer.getId () );
            System.out.printf ( "%-25s", employeer.getName () );
            System.out.printf ( "%-15s", employeer.getSalary () );
            System.out.printf ( "%-5s", employeer.getDepartment () );
            System.out.println ();
        }
    }

    public double getMonthlyCosts() {
        double monthlyCosts = 0.0;
        for (Employee employeer : employee) {
            monthlyCosts += employeer.getSalary ();
        }
        return monthlyCosts;
    }

    public int findMinWageEmployeeId() {
        int minWageId = 0;
        for (Employee employeer : employee) {
            if ( employeer.getSalary () < employee[minWageId].getSalary () ) {
                minWageId = employeer.getId () - 1;
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
        for (Employee employeer : employee) {
            System.out.println ( " - " + employeer.getName () );
        }
    }

    public void getIndexedSalary(double indexationPercentage) {
        for (Employee employeer : employee) {
            employeer.setSalary ( employeer.getSalary () * indexationPercentage / 100 + employeer.getSalary () );
        }
    }

    public void printDepartmentInfo(int department) {
        System.out.println ( "Список сотрудников отдела № " + department );
        for (Employee employeer : employee) {
            if ( employeer.getDepartment () == department ) {
                System.out.println ( employeer.getId () + " " + employeer.getName () + " " + employeer.getSalary () );
            }
        }
    }

    public int findMinWageDepartmentEmployeeId(int department) {
        int minWageDepartmentId = 0;
        double minWageDepartment = Double.MAX_VALUE;
        for (Employee employeer : employee) {
            if ( employeer.getDepartment () == department ) {
                if ( employeer.getSalary () < minWageDepartment ) {
                    minWageDepartment = employeer.getSalary ();
                    minWageDepartmentId = employeer.getId ();
                }
            }
        }
        return minWageDepartmentId;
    }

    public int findMaxWageDepartmentEmployeeId(int department) {
        int maxWageDepartmentId = 0;
        double maxWageDepartment = Double.MIN_VALUE;
        for (Employee employeer : employee) {
            if ( employeer.getDepartment () == department ) {
                if ( employeer.getSalary () > maxWageDepartment ) {
                    maxWageDepartment = employeer.getSalary ();
                    maxWageDepartmentId = employeer.getId ();
                }
            }
        }
        return maxWageDepartmentId;
    }

    public double getMonthlyDepartmentCosts(int department) {
        double monthlyDepartmentCosts = 0.0;
        for (Employee employeer : employee) {
            if ( employeer.getDepartment () == department ) {
                monthlyDepartmentCosts += employeer.getSalary ();
            }
        }
        return monthlyDepartmentCosts;
    }

    public double getAverageDepartmentCosts(int department) {
        double averageDepartmentCosts = 0.0;
        int departmentHeadcount = 0;
        for (Employee employeer : employee) {
            if ( employeer.getDepartment () == department ) {
                departmentHeadcount++;
            }
        }
        averageDepartmentCosts = getMonthlyDepartmentCosts ( department ) / departmentHeadcount;
        return averageDepartmentCosts;
    }

    public void getIndexedDepartmentSalary(int department, double indexationPercentage) {
        for (Employee employeer : employee) {
            if ( employeer.getDepartment () == department ) {
                employeer.setSalary ( employeer.getSalary () * indexationPercentage / 100 + employeer.getSalary () );
            }
        }
    }

    public void findEmployeesWithSmallerSalary(double salary) {
        System.out.println ( "Список сотрудников с зарплатой меньше " + salary );
        for (Employee employeer : employee) {
            if ( employeer.getSalary () < salary ) {
                System.out.printf ( "%-5s", employeer.getId () );
                System.out.printf ( "%-25s", employeer.getName () );
                System.out.printf ( "%-15s", employeer.getSalary () );
                System.out.println ();
            }
        }

    }

    public void findEmployeesWithBiggerSalary(double salary) {
        System.out.println ( "Список сотрудников с зарплатой больше " + salary );
        for (Employee employeer : employee) {
            if ( employeer.getSalary () > salary ) {
                System.out.printf ( "%-5s", employeer.getId () );
                System.out.printf ( "%-25s", employeer.getName () );
                System.out.printf ( "%-15s", employeer.getSalary () );
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
    }

    public void getEmployeeById(int id) {
        for (Employee employeer : employee) {
            if ( id == employeer.getId () ) {
                System.out.println ( employeer );
            }

        }
    }
}








