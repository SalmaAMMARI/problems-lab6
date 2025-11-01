package Problem2;

public class main {
    public static void main(String[] args) {
        Bank bank = new Bank("CIH");
        Customer customer1 = new Customer("Salma");
        Customer customer2 = new Customer("Lamiae");
        Customer customer3 = new Customer("Faouzi");

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);
        bank.addCustomer(customer3);

        bank.addTransaction(customer1,100.12);
        bank.addTransaction(customer1,-200.12);
        bank.addTransaction(customer2,200.12);
        bank.addTransaction(customer3,-300.50);

        bank.printCustomer(customer1);






    }
}
