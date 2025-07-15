// Interface of the LoanManager
// Dependency: BookManager (Dependency Inversion Principle)
public interface LoanManager {
    public void loanBook(String bookId, String userId) throws LibraryException;
    public void returnBook(String bookId, String userId) throws LibraryException;
    public boolean isBookLoaned(String bookId);
}
