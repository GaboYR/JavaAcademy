public class SimpleLoanManager implements LoanManager {
    private BookRepository repository;

    public SimpleLoanManager(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void loanBook(String bookId, String userId) throws LibraryException {
        Book book = repository.findBookByISBN(bookId);
        if (book == null) {
            throw new LibraryException("Book with ISBN " + bookId + " not found.");
        }
        if (!book.getAvailable()) {
            throw new LibraryException("Book with ISBN " + bookId + " is already loaned.");
        }
        book.setAvailable(false);
        System.out.println("Book '" + book.getTitle() + "' loaned to user " + userId);
    }

    @Override
    public void returnBook(String bookId, String userId) throws LibraryException {
        Book book = repository.findBookByISBN(bookId);
        if (book == null) {
            throw new LibraryException("Book with ISBN " + bookId + " not found.");
        }
        if (book.getAvailable()) {
            throw new LibraryException("Book with ISBN " + bookId + " was not loaned.");
        }
        book.setAvailable(true);
        System.out.println("Book '" + book.getTitle() + "' returned by user " + userId);
    }

    @Override
    public boolean isBookLoaned(String bookId) {
        Book book = repository.findBookByISBN(bookId);
        return book != null && !book.getAvailable();
    }
}
