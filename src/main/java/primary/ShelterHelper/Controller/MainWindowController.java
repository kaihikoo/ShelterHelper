package primary.ShelterHelper.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import primary.ShelterHelper.Menager;
import primary.ShelterHelper.Model.Animal;
import primary.ShelterHelper.Model.DbConnection;
import primary.ShelterHelper.Model.Table;
import primary.ShelterHelper.View.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWindowController extends BaseContoller {



    public MainWindowController(Menager menager, ViewFactory viewFactory, String fxml) {
        super(menager, viewFactory, fxml);
    }

    @FXML
    private CheckBox sortcats;

    @FXML
    private CheckBox sortdogs;

    @FXML
    private CheckBox sortothers;

    @FXML
   private TableView<Table> tableView;

    @FXML
    private TableColumn<Table,String> idView;

    @FXML
    private TableColumn<Table,String> nameView;

    @FXML
    private TableColumn<Table,String> chipView;

    @FXML
    private TableColumn<Table,String> ageView;

    @FXML
    private TableColumn<Table,String> id_boxView;

    @FXML
    private TableColumn<Table,String> sexView;

    @FXML
    private TableColumn<Table,String> breadView;

    @FXML
    private TableColumn<Table,String> colorView;

    @FXML
    private TableColumn<Table,String> dateView;


    ObservableList<Table> list= FXCollections.observableArrayList();

    String statementCall=null;

    @FXML
    void checkSortAnimals(ActionEvent event) {

        DbConnection connection = new DbConnection();
        Connection connectDB = connection.getConnection();
        if (sortdogs.isSelected() == true) {
            statementCall= "SELECT * FROM shelterhelper.dogs;";
            System.out.println(sortdogs.isSelected());}
        if (sortcats.isSelected() == true) {
            System.out.println(sortcats.isSelected());
             statementCall = "SELECT * FROM shelterhelper.cats;";}
        if (sortothers.isSelected() == true) {
            statementCall = "SELECT * FROM shelterhelper.other;";}
            try {
                Statement statement = connectDB.createStatement();
                ResultSet queryResult = statement.executeQuery(statementCall);
                for (int i = 0; i < tableView.getItems().size(); i++) {
                    tableView.getItems().clear();}
                while (queryResult.next()) {
                    resultDateBase(queryResult);

                }
            } catch (SQLException e) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, (String) null);

            }


        if (sortothers.isSelected() == false && sortcats.isSelected() == false && sortdogs.isSelected() == false ) {
            for (int i = 0; i < tableView.getItems().size(); i++) {
                tableView.getItems().clear();}}

        setcellValue();
        tableView.setItems(list);
    }


        public void setcellValue()
        {

            idView.setCellValueFactory(new PropertyValueFactory<>("id"));
            nameView.setCellValueFactory(new PropertyValueFactory<>("" + "Name"));
            chipView.setCellValueFactory(new PropertyValueFactory<>("chip"));
            ageView.setCellValueFactory(new PropertyValueFactory<>("age"));
            id_boxView.setCellValueFactory(new PropertyValueFactory<>("id_box"));
            sexView.setCellValueFactory(new PropertyValueFactory<>("sex"));
            breadView.setCellValueFactory(new PropertyValueFactory<>("bread"));
            colorView.setCellValueFactory(new PropertyValueFactory<>("color"));
            dateView.setCellValueFactory(new PropertyValueFactory<>("dateArrival"));
        }





    public void resultDateBase(ResultSet queryResult) throws SQLException {
        list.add(new Table(
                queryResult.getString("ID"),
                queryResult.getString("name"),
                queryResult.getString("chip"),
                queryResult.getString("age"),
                queryResult.getString("id_box"),
                queryResult.getString("sex"),
                queryResult.getString("bread"),
                queryResult.getString("color"),
                queryResult.getString("date")));

    }








    @FXML
    void addAnimal(ActionEvent event) {
        ViewFactory viewFactory=new ViewFactory(new Menager());
        viewFactory.showAddPetPanel();
    }



}
