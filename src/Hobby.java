public class Hobby extends BookableItem {

    private String level;
    private double price;

    public Hobby(int id, String name, String description, String level, double price) {
        super(id, name, description);
        this.level = level;
        this.price = price;
    }

    @Override
    public String getExtraInfo() {
        return "Level: " + level + ", Price: £" + price;
    }
}
