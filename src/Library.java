import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;
    private List<Loan> loans;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        loans = new ArrayList<>();

    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if(member.getMemberId().equals(memberId)){
                return member;
            }
        }
        return null;
    }

    public void displayAvailableBooks() {
        for(Book book : books){
            if(book.isAvailable()){
                System.out.println(book);
            }
        }
    }

    public void borrowBook(String memberId, String bookTitle) {
        Member member = findMemberById(memberId);
        Book book = findBookByTitle(bookTitle);

        if(member != null && book != null && book.isAvailable()){
            Loan loan = new Loan(book, member);
            loans.add(loan);
            member.borrowBook(book);
            System.out.println("Loan created: " + loan);
        } else if (member == null) {
            System.out.println("Member not found");
        }else{
            System.out.println("Book not found");
        }
    }

    public void returnBook(String memberId, String bookTitle) {
        Member member = findMemberById(memberId);
        if(member != null){
            System.out.println("Member not found");
            return;
        }

        Book toReturn = null;
        for (Book b : member.getBorrowedBooks()){
            if(b.getTitle().equalsIgnoreCase(bookTitle)){
                toReturn = b;
                break;
            }
        }

        if(toReturn != null){
            member.returnBook(toReturn);

            Loan loanToRemove = null;
            for (Loan l : loans){
                if(l.getBook().equals(toReturn) && l.getMember().equals(member)){
                loanToRemove = l;
                break;
                }
            }
        }
    }

    public void showLoans(){
        if(loans.isEmpty()){
            System.out.println("No active loans");
            return;
        }
        for(Loan loan : loans){
            System.out.println("Current Loan: " + loan);
        }
    }
}
