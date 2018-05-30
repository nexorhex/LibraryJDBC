import java.util.Scanner;

public class App {

    public static void main(String[] args) {

//        Book book1 = new Book("Eragon","Christopher Paolini","2006","1045786220907");
//        BookDAO bookDAO = new BookDAO();
//        //bookDAO.save(book1);
//        //bookDAO.close();
//
//        Book book = bookDAO.read(2);
//        System.out.println(book);
//        bookDAO.close();
        int i = 1;
        while (i >= 1) {
            String startMessage = "Wybierz opcje: \n" +
                    "1 - Dodaj nowy rekord \n" +
                    "2 - Wyswietl ksiazke \n" +
                    "3 - Usuwanie \n" +
                    "4 - Aktualizacja \n" +
                    "5 - Zakoncz dzialanie programu";
            System.out.println(startMessage);
            Scanner scanner = new Scanner(System.in);
            int chosenNumber = Integer.parseInt(scanner.next());
            Book book = new Book();
            BookDAO bookDAO = new BookDAO();
            switch (chosenNumber) {
                case 1:
                    System.out.println("Podaj tytul");
                    book.setTitle(scanner.nextLine());
                    System.out.println("Podaj autora");
                    book.setAuthor(scanner.nextLine());
                    System.out.println("Podaj ISBN");
                    book.setISBN(scanner.nextLine());
                    System.out.println("Podaj rok wydania");
                    book.setYear(scanner.nextLine());
                    bookDAO.save(book);
                    bookDAO.close();
                    System.out.println("Ksiazka zapisana");
                    break;
                case 2:
                    System.out.println("Podaj ID ksiazki");
                    int id = Integer.parseInt(scanner.next());
                    System.out.println(bookDAO.read(id) + "\n");
                    bookDAO.close();
                    break;
                case 3:
                    System.out.println("Podaj ID ksiazki, ktora chcesz usunac");
                    int idDel = Integer.parseInt(scanner.next());
                    bookDAO.delete(idDel);
                    bookDAO.close();
                    System.out.println("Ksiazka usunieta\n");
                    break;
                case 4:
                    System.out.println("Podaj tytul");
                    book.setTitle(scanner.next());
                    System.out.println("Podaj autora");
                    book.setAuthor(scanner.next());
                    System.out.println("Podaj rok wydania");
                    book.setYear(scanner.next());
                    System.out.println("Podaj ISBN");
                    book.setISBN(scanner.next());
                    System.out.println("Podaj ID");
                    book.setId(Integer.parseInt(scanner.next()));
                    bookDAO.update(book);
                    bookDAO.close();
                    System.out.println("Ksiazka zostala zaktualizowana\n");
                    break;
                case 5:
                    System.out.println("Wylaczanie...");
                    return;
                default:
                    System.out.println("Prosze wybrac numer od 1 do 4\n");
                    break;
            }

        }
    }

}
