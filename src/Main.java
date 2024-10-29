public class Main {

    public static void main(String[] args) {

        EmployeeBook book = new EmployeeBook ();

        book.getInit ();
        book.printInfo ();
        System.out.println ("----------------------------------------------------");

        book.deleteEmployee ( 6 );
        book.addEmployee ( "Влад Салтыков", 150000, 5 );

        book.getEmployeeById ( 6); //Это будет null (можно ли исправить не изменяя модификатор доступа к полю класса Employee - id ???
        book.getEmployeeById ( 11 );

    }
}




