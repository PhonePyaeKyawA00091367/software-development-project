import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BookingSystemGUI extends Application {

    private BookingSystem bookingSystem;
    private User currentUser;
    private ObservableList<BookableItem> items;

    @Override
    public void start(Stage stage) {


        bookingSystem = new BookingSystem();
        currentUser = new User(1, "Demo User", "demo@mail.com");

        bookingSystem.addUser(currentUser);


        bookingSystem.addItem(new Facility(
                1, "Conference Room", "Large meeting room", "Building A", 20));

        bookingSystem.addItem(new Equipment(
                2, "Projector", "HD Projector", "Electronics", "Good"));

        bookingSystem.addItem(new Hobby(
                3, "Yoga Class", "Morning yoga", "Beginner", 10.00));

        items = FXCollections.observableArrayList(bookingSystem.getItems());


        Label title = new Label("Booking System - Sprint 3");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        ListView<BookableItem> listView = new ListView<>(items);

        Button bookBtn = new Button("Book");
        Button releaseBtn = new Button("Release");

        Label status = new Label("Ready");

        bookBtn.setOnAction(e -> {
            BookableItem selected = listView.getSelectionModel().getSelectedItem();
            if (selected == null) {
                status.setText("Select an item first");
                return;
            }
            if (selected.book(currentUser)) {
                status.setText("Booked: " + selected.getName());
            } else {
                status.setText("Already booked by " + selected.getBookedBy().getName());
            }
            listView.refresh();
        });

        releaseBtn.setOnAction(e -> {
            BookableItem selected = listView.getSelectionModel().getSelectedItem();
            if (selected == null) {
                status.setText("Select an item first");
                return;
            }
            selected.release();
            status.setText("Released: " + selected.getName());
            listView.refresh();
        });

        HBox buttons = new HBox(10, bookBtn, releaseBtn);

        VBox root = new VBox(15, title, listView, buttons, status);
        root.setPadding(new Insets(15));

        stage.setScene(new Scene(root, 500, 400));
        stage.setTitle("Booking System");
        stage.show();
    }


}

