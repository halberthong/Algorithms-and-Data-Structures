public class User {
    private long ID;
    private String details;
    private int accountType;
    private static Set<User> users;

    public Book searchLibrary(long id) {
        return Book.find(id);
    }
    public void renewMembership() {

    }
    public static User find(long id) {
        for (User u : users) {
            if (u.getID() == ID) {
                return u;
            }
        }
        return null;
    }
    public static void addUser(long id, String det, int acocuntType) {
        users.add(new User(id, det, accountType));
    }
    public User(long id, String det, int accountType) {

    }
}
