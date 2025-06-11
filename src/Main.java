public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "978-0261103344"));
        library.addBook(new Book("1984", "George Orwell", "978-0451524935"));

        Member member = new Member("Alice", "M001");
        library.registerMember(member);

        library.borrowBook("M001", "1984");

        library.showLoans();

        library.returnBook("M001", "1984");

        System.out.println("\nAfter returning:");
        library.showLoans();
    }
}
