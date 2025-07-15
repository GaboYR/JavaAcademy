public class Book {
    private String ISBN;
    private String title;
    private String author;
    private int publicationYear;
    private Boolean isAvailable;

    public Book(String ISBN, String title, String author, int publicationYear, Boolean isAvailable) {
        setISBN(ISBN);
        setTitle(title);
        setAuthor(author);
        setPublicationYear(publicationYear);
        this.isAvailable = isAvailable;
    }
    
    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }
    public void setISBN(String ISBN) {
        if (ISBN != null && !ISBN.isEmpty()) {
            this.ISBN = ISBN;
        } else {
            throw new IllegalArgumentException("ISBN cannot be null or empty");
        }
    }
    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
    }
    public void setAuthor(String author) {
        if (author != null && !author.isEmpty()) {
            this.author = author;
        } else {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
    }
    public void setPublicationYear(int publicationYear) {
        if (publicationYear > 0) {
            this.publicationYear = publicationYear;
        } else {
            throw new IllegalArgumentException("Publication year must be a positive integer");
        }
    }
    public void setAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

