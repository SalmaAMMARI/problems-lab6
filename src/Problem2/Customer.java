package Problem2;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class Customer {
    private String name;
    private ArrayList<Double> transactions; // a transaction is pos or neg
    public Customer(String name){
        this.name=name;
        this.transactions = new ArrayList<>();
    }
    public ArrayList<Double> getTransactions() {
        return this.transactions;
    }
    public void setTransactions(ArrayList<Double> transactions) {
        this.transactions = transactions;
    }
    public String getName(){
        return this.name;
    }


}
