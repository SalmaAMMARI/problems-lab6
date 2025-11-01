package problem5;

import java.util.ArrayList;

public class BookQueue {
    private ArrayList<Book> list;

    public BookQueue() {
        list = new ArrayList<>();
    }

    public void push(Book book) {
        //add at the end of the queue
        list.add(book);
    }

    public Book pop() {
        //pop from the front
        Book book = list.get(0);
        list.remove(0);
        return book;
    }

    public Book peek() {
        // get the element in the front without removing it
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void display() {
        System.out.println("Queue contents (front to back):");
        for (Book book : list) {
            System.out.println(" -"+book);
        }
    }
}
