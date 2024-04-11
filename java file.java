package asuHelloWorldJavaFX;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ASUHelloWorldJavaFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pediatric Office Landing Page");

        Label label = new Label("Pedriatic Office System\nWelcome! Please select your role below:");
        label.setAlignment(Pos.CENTER);
        label.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold; -fx-font-family: 'Arial';");

        Button button1 = new Button("Doctor/Nurse");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Doctor/Nurse button clicked");
                // Open another stage or scene for Doctor/Nurse
                openDoctorLoginPage();
            }
        });

        Button button2 = new Button("Patients/Guardians");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Patients/Guardians button clicked");
                // Open another stage or scene for Patients/Guardians
                openPatientPortalLoginStage();
            }
        });

        HBox buttonBox = new HBox(10, button1, button2); // Add spacing of 10 between buttons
        buttonBox.setAlignment(Pos.CENTER);

        // Add spacing of 10 between label and buttonBox
        VBox root = new VBox(10, label, buttonBox); 
        root.setAlignment(Pos.CENTER); // Center VBox content

        // Applying light blue background
        root.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to open Doctor's Login page
    private void openDoctorLoginPage() {
        Stage stage = new Stage();
        VBox root = new VBox();
        
        // Title of the Doctor login
        Label titleLabel = new Label("Doctor's Login");
        titleLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold; -fx-font-family: 'Arial';");
        titleLabel.setAlignment(Pos.CENTER);
        
        // Text 1: Doctor/Nurse ID
        HBox idBox = new HBox();
        Label idLabel = new Label("Doctor/Nurse ID:");
        TextField idTextField = new TextField();
        idBox.getChildren().addAll(idLabel, idTextField);
        idBox.setAlignment(Pos.CENTER);
        
        // Text 2: Password
        HBox passwordBox = new HBox();
        Label passwordLabel = new Label("Password:");
        TextField passwordTextField = new TextField();
        passwordBox.getChildren().addAll(passwordLabel, passwordTextField);
        passwordBox.setAlignment(Pos.CENTER);
        
        // Display Error message label
        Label errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);
        errorLabel.setAlignment(Pos.CENTER);
        
        // Create Button to sign in
        Button signInButton = new Button("Sign in");
        signInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String id = idTextField.getText();
                String password = passwordTextField.getText();
                // Check if ID and password are correct
                if (id.equals("grubiobo") && password.equals("asu123")) {
                    System.out.println("Sign in successful");
                    openDoctorDashboardPage(); // Open Doctor's Dashboard page
                } else {
                    System.out.println("Invalid credentials. Please try again.");
                    errorLabel.setText("Wrong ID or password. Try again.");
                }
            }
        });
        
        // Add components to the root
        root.getChildren().addAll(titleLabel, idBox, passwordBox, signInButton, errorLabel);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10); // Add spacing between components
        
        Scene scene = new Scene(root, 400, 250);
        stage.setScene(scene);
        stage.show();
    }

    // Method to open Doctor's Dashboard page
    private void openDoctorDashboardPage() {
        Stage stage = new Stage();
        VBox root = new VBox();
        
        // Title
        Label titleLabel = new Label("Doctor's Dashboard");
        titleLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold; -fx-font-family: 'Arial';");
        titleLabel.setAlignment(Pos.CENTER);
        
        // Text fields for adding a new patient
        Label nameLabel = new Label("Enter Patient's Name:");
        TextField nameTextField = new TextField();
        
        Label dobLabel = new Label("Enter D.O.B:");
        TextField dobTextField = new TextField();
        
        Label notesLabel = new Label("Enter Notes:");
        TextField notesTextField = new TextField();
        
        // Button to add a new patient
        Button addPatientButton = new Button("Add New Patient +");
        
        // Table for displaying patients
        TableView<Patient> tableView = new TableView<>();
        ObservableList<Patient> data = FXCollections.observableArrayList();
        
        // Columns
        TableColumn<Patient, String> nameCol = new TableColumn<>("Patient Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Patient, String> dobCol = new TableColumn<>("D.O.B");
        dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));
        
        TableColumn<Patient, String> notesCol = new TableColumn<>("Notes");
        notesCol.setCellValueFactory(new PropertyValueFactory<>("notes"));
        
        tableView.getColumns().addAll(nameCol, dobCol, notesCol);
        tableView.setItems(data);
        
        // Add action for adding a new patient
        addPatientButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = nameTextField.getText();
                String dob = dobTextField.getText();
                String notes = notesTextField.getText();
                
                data.add(new Patient(name, dob, notes));
                
                // Clear input fields
                nameTextField.clear();
                dobTextField.clear();
                notesTextField.clear();
            }
        });
        
        // Add components to the root
        root.getChildren().addAll(titleLabel, nameLabel, nameTextField, dobLabel, dobTextField,
                                   notesLabel, notesTextField, addPatientButton, tableView);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10); // Add spacing between components
        
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    
    // Method to open Patient Portal Login stage
    private void openPatientPortalLoginStage() {
        Stage stage = new Stage();
        VBox root = new VBox();
        
        // Title
        Label titleLabel = new Label("Patient Portal Login");
        titleLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold; -fx-font-family: 'Arial';");
        titleLabel.setAlignment(Pos.CENTER);
        
        // Text 1: Patient Full Name
        HBox fullNameBox = new HBox();
        Label fullNameLabel = new Label("Patient Full Name:");
        TextField fullNameTextField = new TextField();
        fullNameBox.getChildren().addAll(fullNameLabel, fullNameTextField);
        fullNameBox.setAlignment(Pos.CENTER);
        
        // Text 2: Patient D.O.B
        HBox dobBox = new HBox();
        Label dobLabel = new Label("Patient D.O.B (mm/dd/yyyy):");
        TextField dobTextField = new TextField();
        dobBox.getChildren().addAll(dobLabel, dobTextField);
        dobBox.setAlignment(Pos.CENTER);
        
        // Button to log into account and save data
        Button createAccountButton = new Button("Login");
        createAccountButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String fullName = fullNameTextField.getText();
                String dob = dobTextField.getText();
                // Save data or perform account creation logic here
                
                // After account creation, open another page
                openPatientDashboardPage(fullName, dob);
                
                // Close the current stage
                stage.close();
            }
        });
        
        // Add components to the root
        root.getChildren().addAll(titleLabel, fullNameBox, dobBox, createAccountButton);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10); // Add spacing between components
        
        Scene scene = new Scene(root, 400, 250);
        stage.setScene(scene);
        stage.show();
    }
    
    // Method to open Patient Dashboard page after account creation
    private void openPatientDashboardPage(String fullName, String dob) {
        Stage stage = new Stage();
        VBox root = new VBox();
        
        // Title
        Label titleLabel = new Label("Patient Dashboard");
        titleLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold; -fx-font-family: 'Arial';");
        titleLabel.setAlignment(Pos.CENTER);
        
        // Additional Information
        Label lastVisitLabel = new Label("Last Visit: 4/10/2024");
        Label notesLabel = new Label("Notes: The patient has high blood pressure and was prescribed Lisinopril");
        
        // Display the created account information
        Label fullNameLabel = new Label("Patient Full Name: " + fullName);
        Label dobLabel = new Label("Patient D.O.B: " + dob);
        
        // Add components to the root
        root.getChildren().addAll(titleLabel, fullNameLabel, dobLabel, lastVisitLabel, notesLabel);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10); // Add spacing between components
        
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    // Model class for Patient
    public static class Patient {
        private final SimpleStringProperty name;
        private final SimpleStringProperty dob;
        private final SimpleStringProperty notes;

        private Patient(String name, String dob, String notes) {
            this.name = new SimpleStringProperty(name);
            this.dob = new SimpleStringProperty(dob);
            this.notes = new SimpleStringProperty(notes);
        }

        public String getName() {
            return name.get();
        }

        public String getDob() {
            return dob.get();
        }

        public String getNotes() {
            return notes.get();
        }
    }
}
