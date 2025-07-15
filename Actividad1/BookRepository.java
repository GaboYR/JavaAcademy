public interface BookRepository {
    public void addBook(Book book) throws LibraryException;
    public void removeBook(String ISBN) throws LibraryException;
    public Book findBookByISBN(String ISBN);
    public void listAllBooks();
}
