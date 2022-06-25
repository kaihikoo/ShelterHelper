module PrimaryMaven {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires java.sql;
    requires javafaker;
    requires mysql.connector.java;




    exports primary.ShelterHelper.Model to javafx.graphics;
    opens primary.ShelterHelper;

    opens primary.ShelterHelper.Controller;
    opens primary.ShelterHelper.Model;
    exports primary.ShelterHelper to javafx.graphics;
    exports primary.ShelterHelper.View to javafx.graphics;
    opens primary.ShelterHelper.View;
}