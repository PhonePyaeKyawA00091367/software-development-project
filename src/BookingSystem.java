import java.util.ArrayList;
import java.util.List;

public class BookingSystem {

    private List<User> users = new ArrayList<>();
    private List<BookableItem> items = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void addItem(BookableItem item) {
        items.add(item);
    }

    public List<User> getUsers() {
        return users;
    }

    public List<BookableItem> getItems() {
        return items;
    }
}
