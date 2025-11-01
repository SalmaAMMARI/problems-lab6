package Problem3;
import java.util.ArrayList;

public class Library {
    private int capacity ;
    ArrayList<Document> docs;
    public Library(int capacity) {
        this.capacity = capacity;
        this.docs =new ArrayList<>(capacity);
    }
    public void DisplayDocuments(){
        for (Document doc : docs){
            System.out.println(doc);
        }
    }
    boolean add(Document doc){
        if (docs.contains(doc)){
            return false;
        }else{
            docs.add(doc);
            return true;
        }
    }
    boolean delete(Document doc){
       for (Document Doc : docs){
           if (Doc.getNumRec()==doc.getNumRec()){
               docs.remove(Doc);
               return true;
           }

       }
       return false;
    }
    public Document document(int numEnrg){
        for (Document doc : docs){
            if (doc.getNumRec()==numEnrg){
                return doc;
            }
        }
        return null;
    }
    public void displayAuthors(){
        for (Document doc : docs){
            if (doc instanceof Book){
                Book book = (Book) doc;
                System.out.println(book.getAuthor());
            }

        }
    }
}
