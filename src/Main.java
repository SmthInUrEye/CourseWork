public class Main {

    public static void main(String[] args) {

        EmployeeBook book = new EmployeeBook ();

        book.getInit ();
        book.printInfo ( book.employee );
        System.out.println ("----------------------------------------------------");

        book.deleteEmployee ( book.employee, 6 );
        book.addEmployee ( book.employee, "Влад Салтыков", 150000, 5 );

        book.getEmployeeById ( book.employee, 6); //Это будет null (можно ли исправить не изменяя модификатор доступа к полю класса Employee - id ???
        book.getEmployeeById ( book.employee, 11 );

    }
}




