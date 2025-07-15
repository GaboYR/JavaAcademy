public class ArrayBookRepository implements BookRepository {
    private final int MAX_BOOKS = 100;
    private Book[] books = new Book[MAX_BOOKS];

    @Override
    public void addBook(Book book) throws LibraryException {
        if (findBookByISBN(book.getISBN()) != null) {
            throw new LibraryException("A book with ISBN " + book.getISBN() + " already exists.");
        }

        for (int i = 0; i < MAX_BOOKS; i++) {
            if (books[i] == null) {
                books[i] = book;
                return;
            }
        }
        throw new LibraryException("Repository is full. Cannot add more books.");
    }

    @Override
    public void removeBook(String ISBN) throws LibraryException {
        for (int i = 0; i < MAX_BOOKS; i++) {
            if (books[i] != null && books[i].getISBN().equals(ISBN)) {
                books[i] = null;
                return;
            }
        }
        throw new LibraryException("Cannot remove: book with ISBN " + ISBN + " not found.");
    }

    @Override
    public Book findBookByISBN(String ISBN) {
        for (Book book : books) {
            if (book != null && book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void listAllBooks() {
        for (Book book : books) {
            if (book != null) {
                System.out.println(book);
            }
        }
    }
}
