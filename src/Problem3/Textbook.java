package Problem3;

public class Textbook extends Book{
    private String level;
    public Textbook(String title, String author, String level, int nbrPages) {
        super(title,author, nbrPages);
        this.level=level;
    }
    @Override
    public String toString(){
        return super.toString()+ " Level: "+this.level;
    }

}
