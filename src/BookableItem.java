public abstract class BookableItem {

    protected int id;
    protected String name;
    protected String description;
    protected boolean booked = false;
    protected User bookedBy;

    public BookableItem(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public boolean book(User user) {
        if (booked) return false;
        booked = true;
        bookedBy = user;
        return true;
    }

    public void release() {
        booked = false;
        bookedBy = null;
    }

    public User getBookedBy() {
        return bookedBy;
    }

    public String getName() {
        return name;
    }

    public abstract String getExtraInfo();

    @Override
    public String toString() {
        return name + " (" + (booked ? "Booked" : "Available") + ")";
    }
}
