package primary.ShelterHelper.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import primary.ShelterHelper.Menager;
import primary.ShelterHelper.Model.CreateBread;
import primary.ShelterHelper.Model.DbConnection;
import primary.ShelterHelper.Model.User;
import primary.ShelterHelper.View.ViewFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class AddPetController extends BaseContoller implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private TextField chip;

    @FXML
    private Slider age;

    @FXML
    private TextField id_box;

    @FXML
    private ChoiceBox<Sex> sexPet;
    public enum Sex {
    MALE,FEMALE
    };

    @FXML

    private ChoiceBox<String> bread;
    public enum Color{
        BLACK,WHITE,BLUE,BLACK_AND_WHITE, BROWN, YELLOW, MERLE, TRICOLOR
    };
    @FXML
    private ChoiceBox<Color> color;


    @FXML
    private Label valueofslider;

    @FXML
    private DatePicker datePet;

    @FXML
    private ChoiceBox <Pet>choosePet;

    public enum Pet{CAT, DOG, OTHER_ANIMAL };


    @FXML
    private Button addButton;

    @FXML
    private ImageView IMAGE;


    public AddPetController(Menager menager, ViewFactory viewFactory, String fxml) {
        super(menager, viewFactory, fxml);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choosePet.getItems().addAll(Pet.values());
        choosePet.setOnAction(event -> {
            Pet valueofPet=choosePet.getValue();
            showBread(valueofPet);
            System.out.println(valueofPet);

        });
        sexPet.getItems().addAll(Sex.values());
        color.getItems().addAll(Color.values());
        addButton.setOnAction((event)-> {
            addanimaltobase(choosePet.getValue());

        });
    }

    @FXML
    void updateslider(MouseEvent event) {
        valueofslider.setText(String.valueOf((int)age.getValue()));

    }



    public void addanimaltobase(Pet valueofPet)
    {

        DbConnection connection = new DbConnection();
        Connection connectDB = connection.getConnection();
        try {

            String addAnimal;

        switch ((valueofPet)) {

            case DOG -> {
                 addAnimal = " INSERT INTO shelterhelper.dogs (name, chip,age, id_box ,sex,bread,color,date) values (" + "?,?,?,?,?,?,?,?)";

                break;
            }
            case CAT -> {
               addAnimal = " INSERT INTO shelterhelper.cats (name, chip,age, id_box ,sex,bread,color,date) values (" + "?,?,?,?,?,?,?,?)";
                break;
            }
            case OTHER_ANIMAL -> {
                addAnimal = " INSERT INTO shelterhelper.otheranimals (name, chip,age, id_box ,sex,bread,color,date) values (" + "?,?,?,?,?,?,?,?)";
                break;
            }
            default -> throw new IllegalStateException("Unexpected value: " + (valueofPet));
        }
            PreparedStatement statement = connectDB.prepareStatement(addAnimal);
            statement.setString(1, name.getText());
            statement.setString(2, chip.getText());
            statement.setString(3, String.valueOf((int) age.getValue()));
            statement.setString(4, id_box.getText());
            statement.setString(5, String.valueOf(sexPet.getValue()));
            statement.setString(6, String.valueOf(bread.getValue()));
            statement.setString(7, String.valueOf(color.getValue()));
            statement.setString(8, String.valueOf(datePet.getValue()));
            statement.executeUpdate();
            statement.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }



    /**
     *
     * @param valueofPet DOG CAT OR OTHER which kind of pet user choose
     *    This methods generate bread of differnet kind of pet.
     */
    public void showBread(Pet valueofPet)
    {
        CreateBread createBread=new CreateBread();
        if (valueofPet.equals(Pet.DOG))
        {
            bread.getItems().clear();
            ArrayList<String> breadDogs =createBread.createBreadDog();
            for (String breadDog:breadDogs
            ) {
                bread.getItems().add(breadDog);
            }

        }
        else if (valueofPet.equals(Pet.CAT))
        {
            bread.getItems().clear();
            ArrayList<String> breadCats =createBread.createBreadCat();
            for (String breadCat:breadCats
            ) {
                bread.getItems().add(breadCat);
            }

        }
        else
        {
            bread.getItems().clear();
            String [] other={ "HAMSTER"," SNAKE", "GENUINE PIG", "HORSE", " PIG", "OTHER"};
            bread.getItems().addAll(other);

        }

    }
}
