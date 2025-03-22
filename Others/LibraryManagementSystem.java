package Others;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook("Python Basics", "John Doe", "12345");
        library.addBook("Data Science Handbook", "Jane Smith", "67890");

        library.addMember(1, "Alice");

        library.rentBook(1, "12345", LocalDate.now().plusDays(7));

        System.out.println(library.trackAvailability("12345"));

        library.returnBook(1, "12345", LocalDate.now().plusDays(10));

        
    }
}

class Book {
    String title;
    String author;
    String isbn;
    boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public void rent() {
        if (this.isAvailable) {
            this.isAvailable = false;
            System.out.println("Book rented successfully");
        } else {
            System.out.println("Book is not available");
        }
    }

    public void returnBook() {
        if (!this.isAvailable) {
            this.isAvailable = true;
            System.out.println("Book returned");
        } else {
            System.out.println("Book has not been rented");
        }
    }
}

class Member {
    String name;
    int id;
    Map<String, LocalDate> borrowedBooks;

    public Member(String name, int id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new HashMap<>();
    }

    public boolean borrowBook(Book book, LocalDate dueDate) {
        if (borrowedBooks.size() < 5 && book.isAvailable) {
            borrowedBooks.put(book.isbn, dueDate);
            book.isAvailable = false;
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book, LocalDate returnDate) {
        LocalDate dueDate = borrowedBooks.remove(book.isbn);
        if (dueDate != null) {
            System.out.println("Book returned successfully.");
            return true;
        }
        System.out.println("Book not found in borrowed list.");
        return false;
    }

    public int calculateFine(LocalDate dueDate, LocalDate returnDate) {
        if (returnDate.isAfter(dueDate)) {
            long daysOver = ChronoUnit.DAYS.between(dueDate, returnDate);
            return (int) daysOver * 10;
        }
        return 0;
    }
}

class Library {
    List<Book> books;
    List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(String title, String author, String isbn) {
        books.add(new Book(title, author, isbn));
    }

    public void addMember(int id, String name) {
        members.add(new Member(name, id));
    }

    public Book findBook(String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Member findMember(int id) {
        for (Member member : members) {
            if (member.id == id) {
                return member;
            }
        }
        return null;
    }

    public void rentBook(int id, String isbn, LocalDate dueDate) {
        Book book = findBook(isbn);
        Member member = findMember(id);

        if (book != null && member != null && book.isAvailable) {
            if (member.borrowBook(book, dueDate)) {
                System.out.println("Book " + book.title + " by " + book.author + " successfully borrowed");
            } else {
                System.out.println("Already borrowed max limit. Return books before renting more!");
            }
        } else {
            System.out.println("Book not rented. Book or member details not found");
        }
    }

    public void returnBook(int id, String isbn, LocalDate currentDate) {
        Book book = findBook(isbn);
        Member member = findMember(id);

        if (book != null && member != null) {
            LocalDate dueDate = member.borrowedBooks.get(book.isbn);

            if (dueDate != null) {
                int fine = member.calculateFine(dueDate, currentDate);
                member.returnBook(book, currentDate);
                book.returnBook();
                System.out.println("Book returned with fine amount: " + fine);
            } else {
                System.out.println("Book was not borrowed.");
            }
        } else {
            System.out.println("The book or member is not found.");
        }
    }

    public String trackAvailability(String isbn) {
        Book book = findBook(isbn);
        if (book != null) {
            return book.isAvailable ? "Available" : "Not Available";
        }
        return "Book not found.";
    }
}
