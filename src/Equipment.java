public class Equipment extends BookableItem {

    private String category;
    private String condition;

    public Equipment(int id, String name, String description, String category, String condition) {
        super(id, name, description);
        this.category = category;
        this.condition = condition;
    }

    @Override
    public String getExtraInfo() {
        return "Category: " + category + ", Condition: " + condition;
    }
}
