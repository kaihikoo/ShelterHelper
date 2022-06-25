package primary.ShelterHelper.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import primary.ShelterHelper.Menager;
import primary.ShelterHelper.Model.DbConnection;
import primary.ShelterHelper.View.ViewFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginPanelController extends BaseContoller  {


    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField nicknameField;

    @FXML
    private Button CreateButton;

    @FXML
    private Label errorText;




    public LoginPanelController(Menager menager, ViewFactory viewFactory, String fxml) {
        super(menager, viewFactory, fxml);
    }

    @FXML
        public void loginButton(ActionEvent event)
        {

            String login=nicknameField.getText();
            String password= passwordField.getText();
            if(
                    nicknameField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty() ){
                errorText.setText("Enter nickaname or password!");
            }
            else {
                validateLogin();
            }


        }

    @FXML
    void createAccount(ActionEvent event) {
        ViewFactory viewFactory1=new ViewFactory(new Menager());
        viewFactory1.showCreateAccountPanel();

    }
    public  void validateLogin()
    {

       // Stage stage = (Stage) loginButton.getScene().getWindow();
        DbConnection connection=new DbConnection();
        Connection connectDB=connection.getConnection();
        String verifyUser= "SELECT count(1) FROM USERS where Nickname= '"+nicknameField.getText()+"' AND User_password='"+passwordField.getText()+"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult=statement.executeQuery(verifyUser);
            while (queryResult.next()){
                if(queryResult.getInt(1)==1){
                    errorText.setText("Welcome!");
                  ViewFactory viewFactory=new ViewFactory(new Menager());
                  Stage stage = (Stage) loginButton.getScene().getWindow();
                  viewFactory.showMainWindow();
                  viewFactory.closeStage(stage,0);

                } else {
                    errorText.setText("Wrong login. Try again");
                }
            }
        }catch (Exception e){e.printStackTrace();}
    }





}
