import java.util.ArrayList;

public class ArrayListBookRepository implements BookRepository {
    private ArrayList<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) throws LibraryException {
        if (findBookByISBN(book.getISBN()) != null) {
            throw new LibraryException("A book with ISBN " + book.getISBN() + " already exists.");
        }
        books.add(book);
    }

    @Override
    public void removeBook(String ISBN) throws LibraryException {
        Book toRemove = findBookByISBN(ISBN);
        if (toRemove == null) {
            throw new LibraryException("Cannot remove: book with ISBN " + ISBN + " not found.");
        }
        books.remove(toRemove);
    }

    @Override
    public Book findBookByISBN(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void listAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
