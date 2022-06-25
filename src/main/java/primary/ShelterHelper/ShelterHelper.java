package primary.ShelterHelper;

import javafx.application.Application;
import javafx.stage.Stage;
import primary.ShelterHelper.Model.CreateBread;
import primary.ShelterHelper.View.ViewFactory;

import java.io.File;

public class ShelterHelper extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        ViewFactory viewFactory=new ViewFactory(new Menager());
        viewFactory.showLoginPanel();
        //viewFactory.resizableStage(stage);


    }

    public static void main (String [] args){launch(args);}
}
