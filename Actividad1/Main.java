public class Main {
    public static void main(String[] args) {
        BookRepository repo = new ArrayListBookRepository();
        LoanManager loanManager = new SimpleLoanManager(repo);

        try {
            Book b1 = new Book("123", "Java Basics", "Alice", 2020, true);
            repo.addBook(b1);

            loanManager.loanBook("123", "user001");
            loanManager.returnBook("123", "user001");

        } catch (LibraryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
