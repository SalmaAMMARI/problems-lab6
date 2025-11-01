package problem5;

import java.util.LinkedList;

public class BookStack {
    private LinkedList<Book> stack;

    public BookStack() {
        stack = new LinkedList<>();
    }

    public void push(Book book) {
        stack.push(book); // add in the top of the stack (last in)
    }

    public Book pop() {
        // get and delete the last in element
        return stack.pop();
    }

    public Book peek() {
        // get without deleting
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        System.out.println("Stack contents(top to buttom):");
        for (Book book : stack) {
            System.out.println(" -" +book);
        }
    }
}
