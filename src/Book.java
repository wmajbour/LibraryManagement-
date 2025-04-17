public class Book {

    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow(){
        isAvailable = false;
    }

    public void returnBook(){
        isAvailable = true;
    }

    @Override
    public String toString() {
        return title + "\n"
                + "Author: " + author + "\n"
                + "ISBN: " + isbn + "\n";
    }

}

