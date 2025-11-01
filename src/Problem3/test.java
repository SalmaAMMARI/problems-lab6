package Problem3;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of document to be in the library: ");
        int n = sc.nextInt();
        Library library = new Library(n);

        Novel novel = new Novel("novel1", "AuthorX", 350, 400);
        Textbook textbook = new Textbook("english", "AuthorY", "C1", 100);

        library.add(novel);
        library.add(textbook);
        boolean flag = true;

        while (flag) {
            System.out.println("Menu:");
            System.out.println("1. Add a document\n2. Display Documents\n3. Delete a Document\n4. Exit");
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1. A novel\n2. A textbook\n3. A magazine\n4. A Dictionary");
                    System.out.println("Enter your choice number:");
                    int ch = sc.nextInt();
                    switch (ch) {
                        case 1:
                            System.out.println("Enter the novel's title: ");
                            String title = sc.next();
                            System.out.println("Enter the novel's author: ");
                            String author = sc.next();
                            System.out.println("Enter number of pages: ");
                            int pages = sc.nextInt();
                            System.out.println("Enter the novel's price: ");
                            double price = sc.nextDouble();
                            Novel nove = new Novel(title, author, price, pages);
                            library.add(nove);
                            break;
                        case 2:
                            System.out.println("Enter the Textbook's title: ");
                            String title1 = sc.next();
                            System.out.println("Enter the Textbook's author: ");
                            String author1 = sc.next();
                            System.out.println("Enter number of pages: ");
                            int pages1 = sc.nextInt();
                            System.out.println("Enter the level: ");
                            String level = sc.next();
                            Textbook text = new Textbook(title1, author1, level, pages1);
                            library.add(text);
                            break;
                        case 3:
                            System.out.println("Enter the Magazine's title: ");
                            String title2 = sc.next();
                            System.out.println("Enter the month of the magazine: ");
                            String month = sc.next();
                            System.out.println("Enter the year of the magazine: ");
                            int year = sc.nextInt();
                            Magazine magazine = new Magazine(title2, month, year);
                            library.add(magazine);
                            break;
                        case 4:
                            System.out.println("Enter the title of the Dictionary: ");
                            String title3 = sc.next();
                            System.out.println("Enter the language of the Dictionary: ");
                            String language = sc.next();
                            Dictionary dictionary = new Dictionary(title3, language);
                            library.add(dictionary);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Display all documents of the library");
                    library.DisplayDocuments();
                    break;
                case 3:
                    System.out.println("Current documents in library:");
                    library.DisplayDocuments();
                    System.out.println("Enter the registration number of document to delete: ");
                    int numToDelete = sc.nextInt();
                    if (library.delete(library.document(numToDelete))) {
                        System.out.println("Document deleted successfully.");
                    } else {
                        System.out.println("Document not found.");
                    }
                    break;
                case 4:
                    flag = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            if (flag) {
                System.out.println("Do you want to continue? (yes/no)");
                String continueChoice = sc.next();
                if (!continueChoice.equalsIgnoreCase("yes")) {
                    flag = false;
                }
            }
        }


    }
}