package primary.ShelterHelper.View;

import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import primary.ShelterHelper.Controller.*;
import primary.ShelterHelper.Menager;

import java.io.IOException;

public class ViewFactory {

    private Menager menager;

    public ViewFactory(Menager menager) {
        this.menager = menager;
    }

    public void showLoginPanel() {
        BaseContoller contoller = new LoginPanelController(menager, this, "/LogPanel.fxml");
        loadWindow(contoller,false);

    }

    public void showCreateAccountPanel()
    {
        BaseContoller controller = new CreatorAccountController(menager, this,"/CreatorAccountpanel.fxml" );
        loadWindow(controller,false);

    }
    public void showAddPetPanel()
    {
        BaseContoller controller = new AddPetController(menager, this,"/AddAnimal.fxml" );
        loadWindow(controller,false);
    }
    public void showMainWindow()
    {
        BaseContoller controller = new MainWindowController(menager, this, "/MainWindow.fxml") {
        };

        loadWindow(controller,true);


    }


    /**
     * Method allow to open window
     * @param baseContoller  conroller with param such as fxml filename
     */
    private void  loadWindow(BaseContoller baseContoller, boolean resizableyesornot) {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(baseContoller.getFxml()));
        fxmlloader.setController(baseContoller);
        Parent parent;
        try {
            parent = fxmlloader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setResizable(resizableyesornot);
        stage.setScene(scene);
        stage.show();
    }

    /** Method to close window
     * @param stagetoClose name of stage with should be close
     * @param seconds   timelapse of closing window
     */
    public void closeStage(Stage stagetoClose, int seconds)
    {
        PauseTransition pause= new PauseTransition(Duration.seconds(seconds));
        pause.setOnFinished(event ->stagetoClose.close() );
        pause.play();
    }


}


