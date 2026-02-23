public class Facility extends BookableItem {

    private String location;
    private int capacity;

    public Facility(int id, String name, String description, String location, int capacity) {
        super(id, name, description);
        this.location = location;
        this.capacity = capacity;
    }

    @Override
    public String getExtraInfo() {
        return "Location: " + location + ", Capacity: " + capacity;
    }
}
