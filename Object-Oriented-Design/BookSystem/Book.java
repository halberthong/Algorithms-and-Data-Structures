public class Book {
    private long ID;
    private String details;
    private static Set<Book> books;

    public Book(long id, String det) {
        ID = id;
        details = det;
    }
    public long getID() {
        return ID;
    }
    public String getDetails() {
        return details;
    }
    public static void addBook(long id, String det) {
        books.add(new Book(id, det));
    }
    public void update() {}
    public static void delete(Book b) {
        books.remove(b);
    }
    public static Book find(long id) {
        for (Book b : books) {
            if (b.getID() == id) {
                return b;
            }
        }
        return null;
    }
}
