package repo;

public class Book extends Document{
    private Author author;
    private String isbn;

    public Book(double docSize, String format, String title, Author author, String isbn) {
        super(docSize, format, title);
        this.author = author;
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", isbn='" + isbn + '\'' +
                "} " + super.toString();
    }
}
