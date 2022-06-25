package primary.ShelterHelper.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import primary.ShelterHelper.Menager;
import primary.ShelterHelper.View.*;

import java.net.URL;
import java.util.ResourceBundle;

import static primary.ShelterHelper.View.FontSize.*;

public class MainWindowController extends BaseContoller implements Initializable {



    public MainWindowController(Menager menager, ViewFactory viewFactory, String fxml) {
        super(menager, viewFactory, fxml);
    }

    @FXML
    private Slider fontsizeslider;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }


    @FXML
    void addAnimal(ActionEvent event) {
        ViewFactory viewFactory=new ViewFactory(new Menager());
        viewFactory.showAddPetPanel();
    }
}
