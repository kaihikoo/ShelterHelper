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
import primary.ShelterHelper.Model.User;
import primary.ShelterHelper.View.ViewFactory;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreatorAccountController extends BaseContoller {

    public CreatorAccountController(Menager menager, ViewFactory viewFactory, String fxml) {
        super(menager, viewFactory, fxml);

    }
    @FXML
    private Button doAccountButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField nicknameSign;

    @FXML
    private Label errorText;

    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField email;





    @FXML
    void createAccountButton(ActionEvent event) {

        DbConnection connection = new DbConnection();
        Connection connectDB = connection.getConnection();
        String addUser = " INSERT INTO shelterhelper.users (Nickname, User_name,User_surname, email,User_password) values (" + "?,?,?,?,?)";

        User user = new User(nicknameSign.getText(), name.getText(), surname.getText(), email.getText(), passwordField.getText());
        System.out.println(user.toString());

        try {
            PreparedStatement statement = connectDB.prepareStatement(addUser);

            if (checkNickname(nicknameSign.getText()) == false && checkNameSurn(name.getText(), surname.getText()) == true && checkemail(email.getText())==true && checkPassword(passwordField.getText())==true) {
                statement.setString(1, nicknameSign.getText());
                statement.setString(2, name.getText());
                statement.setString(3, surname.getText());
                statement.setString(4, email.getText());
                statement.setString(5, passwordField.getText());
                statement.executeUpdate();
                statement.close();
                errorText.setText("Your Account has been successfully created!");
                Stage stage = (Stage) doAccountButton.getScene().getWindow();
                ViewFactory viewFactory=new ViewFactory(new Menager());
                viewFactory.closeStage(stage,1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorText.setText("Somethink is wrong :( ");
        }
    }


    public boolean checkNickname(String nickname) {
        String checkNickname = "SELECT count(1) FROM USERS where Nickname= '" + nickname + "'";
        boolean nickNameWrong = false;
        if (nickname.isEmpty()==false) {
            try {
                DbConnection connection = new DbConnection();
                Connection connectDB = connection.getConnection();
                Statement statement = connectDB.createStatement();
                ResultSet queryResult = statement.executeQuery(checkNickname);
                while (queryResult.next()) {
                    if (queryResult.getInt(1) == 1) {
                        nickNameWrong = true;
                        errorText.setText("user with this nickname exist. Try somethink else!");
                    } else {
                        nickNameWrong = false;
                    }
                }
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
          
        }
        else if (nickname.isEmpty()==true)
        {
            errorText.setText("Nickname is empty!");
            nickNameWrong=true;
        }
        return nickNameWrong;
    }

    public boolean checkNameSurn(String name, String surname) {
        boolean isOk=false;
        if (name.length() >= 2 && name.isEmpty() == false && surname.length() >= 2 && surname.isEmpty() == false) {
            isOk = true;
        }
        else {errorText.setText("Surname or name is too short!");};
        return isOk;
    }

    public boolean checkemail(String email)
    {
        boolean isOk=email.contains("@");
        System.out.println("Zawiera");
        if ( isOk==false) errorText.setText("Wrong email!");
        return  isOk;


    }
    public boolean checkPassword(String password) {
        boolean isOk = false;
        boolean isUpper = false;
        int signUp=0;

            if (password.length() < 8) {errorText.setText("To weak password! It must have 8 sign");}

            for (int a = 0; a < password.length(); a++)
            {
                char sign = password.charAt(a);
                isUpper = Character.isUpperCase(sign);
                if ( isUpper==true)signUp++;
            }
             if ( signUp==0 )errorText.setText(" To weak password! Password without Capital letter!");

            Pattern p = Pattern.compile("[^A-Za-z0-9]");
            Matcher m = p.matcher(password);
            boolean specialSign = m.find();

            if (specialSign==false) errorText.setText("To weak password! You must use at least one special sign");

            if (password.length() >= 8 && specialSign==true &&signUp>0) {
                isOk = true;
            }

            System.out.println("paasswor : is ok ?  " + isOk);

        return isOk;
        }
    }



