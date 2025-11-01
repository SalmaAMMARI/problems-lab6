package Problem3;

public class Novel extends Book{
    private double Price;
    public Novel(String title, String author, double price, int nbrPages) {
        super(title,author, nbrPages);
        this.Price=price;
    }

    @Override
    public String toString(){
        return super.toString()+ " Price: "+Price;
    }

}
