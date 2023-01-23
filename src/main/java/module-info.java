module com.example.batallanavalv3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.batallanavalv3 to javafx.fxml;
    exports com.example.batallanavalv3;
}