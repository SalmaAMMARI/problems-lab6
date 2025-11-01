package Problem2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class Bank {
    private String name;
    private ArrayList<Customer> customers;
    public Bank(String name){
        this.customers = new ArrayList<>();
        this.name=name;
    }
    public void addCustomer(Customer customer) {
        if (!(customers.contains(customer))){
            customers.add(customer);

        }else{
            System.out.println("Customer already exists");
        }
    }
    public void addTransaction( Customer customer,Double transaction) {
        if (customers.contains(customer)){
            ArrayList<Double> transactions = customer.getTransactions();
            transactions.add(transaction);
            customer.setTransactions(transactions);


        }
    }

    public  void printCustomer(Customer customer){
        System.out.println("Customer name: " + customer.getName());
        System.out.println("Customer transactions:" );
        for (Double transaction : customer.getTransactions()){
            //double transactions = transaction; // unboxing
            System.out.println("Amount:"+transaction);
        }
    }

}
