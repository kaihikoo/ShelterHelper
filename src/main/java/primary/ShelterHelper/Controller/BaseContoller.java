package primary.ShelterHelper.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import primary.ShelterHelper.Menager;
import primary.ShelterHelper.View.ViewFactory;

public abstract class BaseContoller {


    private Menager menager;
    private ViewFactory viewFactory;
    private String fxml;

    public BaseContoller(Menager menager, ViewFactory viewFactory, String fxml) {
        this.menager = menager;
        this.viewFactory = viewFactory;
        this.fxml = fxml;
    }

    public String getFxml() {
        return fxml;
    }
}


