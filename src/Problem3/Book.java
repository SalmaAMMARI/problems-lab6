package Problem3;

public class Book extends Document{
    private String author;
    private int nbrPages;
    public Book(String title,String author, int nbrPages) {
        super(title);
        this.author = author;
        this.nbrPages = nbrPages;
    }
    @Override
    public String toString(){
        return super.toString()+" Author: "+this.author +" nbrPages: "+this.nbrPages;

    }
    public String getAuthor() {
        return author;
    }

}
