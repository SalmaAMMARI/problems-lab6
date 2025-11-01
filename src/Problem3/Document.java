package Problem3;

public class Document {
    private int numRec;
    private String title;
    private static int numRec1=0;

    public Document( String title) {
        this.numRec = numRec1++;
        this.title = title;
    }
    public String toString(){
        return "title: "+title +" numRec: " + numRec;
    }
    public int getNumRec() {
        return numRec;
    }

}
