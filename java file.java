package asuHelloWorldJavaFX;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ASUHelloWorldJavaFX extends Application {
    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_HEIGHT = 500;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ASU Hello World Spring 2024");

        Label label1 = new Label("Pediatric Healthcare Portal");
        Label label2 = new Label("Please specify your role from the options below");
        label1.setStyle("-fx-font-size: 31pt; -fx-font-weight: bold; -fx-font-family: 'Rockwell'; -fx-text-fill: white; -fx-effect: dropshadow(three-pass-box, navy, 13, 0, 0, 0);");
        label2.setStyle("-fx-font-size: 15pt; -fx-font-weight: bold; -fx-font-family: 'TimesRoman'; -fx-text-fill: white; -fx-effect: dropshadow(three-pass-box, navy, 10, 0, 0, 0);");

        Button button1 = new Button("Doctor/Nurse");
        button1.setStyle("-fx-font-size: 12pt; -fx-font-weight: bold; -fx-background-color: grey; -fx-background-opacity: 0.3; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 1px; -fx-border-radius: 20em; -fx-background-radius: 20em; -fx-effect: dropshadow(three-pass-box, navy, 13, 0, 0, 0)");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Doctor/Nurse button clicked");
                // Open another stage or scene for Doctor/Nurse
                openDoctorLoginPage();
            }
        });

        Button button2 = new Button("Patients/Guardians");
        button2.setStyle("-fx-font-size: 12pt; -fx-font-weight: bold; -fx-background-color: grey; -fx-background-opacity: 0.3; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 1px; -fx-border-radius: 20em; -fx-background-radius: 20em; -fx-effect: dropshadow(three-pass-box, navy, 13, 0, 0, 0)");
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

        VBox root = new VBox(20, label1, label2, buttonBox); // Add spacing of 20 between label and buttonBox
        root.setAlignment(Pos.CENTER); // Center VBox content

        // Set background color to linear gradient
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #53CBFD,#59C5FE, #6BB1FE, #74A6FD, #77A5FD, #8C9CFF);");

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT); // Set scene size
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to open Doctor's Login page
    private void openDoctorLoginPage() {
        Stage stage = new Stage();
        VBox root = new VBox();

        // Title
        Label titleLabel = new Label("Doctor's Login");
        titleLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold; -fx-font-family: 'Rockwell'; -fx-text-fill: navy;");
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

        // Error message label
        Label errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);
        errorLabel.setAlignment(Pos.CENTER);

        // Button to sign in
        Button signInButton = new Button("Sign in");
        signInButton.setStyle("-fx-font-size: 12pt; -fx-font-weight: bold; -fx-background-color: grey; -fx-background-opacity: 0.3; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 1px; -fx-border-radius: 20em; -fx-background-radius: 20em; -fx-effect: dropshadow(three-pass-box, navy, 13, 0, 0, 0)");
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

        // Set background color to linear gradient
        root.setStyle("-fx-background-color: linear-gradient(to top, #cdffd8, #94b9ff);");

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT); // Set scene size
        stage.setScene(scene);
        stage.show();
    }

    // Method to open Doctor's Dashboard page
    private void openDoctorDashboardPage() {
        Stage stage = new Stage();
        VBox root = new VBox();

        // Title
        Label titleLabel = new Label("Doctor's Dashboard");
        titleLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold; -fx-font-family: 'Rockwell'; -fx-text-fill: navy;");
        titleLabel.setAlignment(Pos.CENTER);

        // Text fields for adding a new patient
        Label nameLabel = new Label("Enter Patient's Name:");
        TextField nameTextField = new TextField();
        nameTextField.setPrefWidth(1); // Set preferred width
        nameTextField.setPrefHeight(0); // Set preferred height

        Label dobLabel = new Label("Enter D.O.B:");
        TextField dobTextField = new TextField();
        dobTextField.setPrefWidth(200); // Set preferred width
        dobTextField.setPrefHeight(30); // Set preferred height

        Label notesLabel = new Label("Enter Notes:");
        TextField notesTextField = new TextField();

        // Button to add a new patient
        Button addPatientButton = new Button("Add New Patient +");
        addPatientButton.setStyle("-fx-font-size: 12pt; -fx-font-weight: bold; -fx-background-color: grey; -fx-background-opacity: 0.3; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 1px; -fx-border-radius: 20em; -fx-background-radius: 20em; -fx-effect: dropshadow(three-pass-box, navy, 13, 0, 0, 0)");

        // Button to view patient pharmacy/insurance
        Button pharmacyInsuranceButton = new Button("Patient Pharmacy/Insurance");
        pharmacyInsuranceButton.setStyle("-fx-font-size: 12pt; -fx-font-weight: bold; -fx-background-color: grey; -fx-background-opacity: 0.3; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 1px; -fx-border-radius: 20em; -fx-background-radius: 20em; -fx-effect: dropshadow(three-pass-box, navy, 13, 0, 0, 0)");
        pharmacyInsuranceButton.setOnAction(event -> openPatientPharmacyInsurancePage());

        // Button to open inbox
        Button inboxButton = new Button("Inbox");
        inboxButton.setStyle("-fx-font-size: 12pt; -fx-font-weight: bold; -fx-background-color: grey; -fx-background-opacity: 0.3; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 1px; -fx-border-radius: 20em; -fx-background-radius: 20em; -fx-effect: dropshadow(three-pass-box, navy, 13, 0, 0, 0)");
        inboxButton.setOnAction(event -> openInboxPage());

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
                notesLabel, notesTextField, addPatientButton, pharmacyInsuranceButton, inboxButton, tableView);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10); // Add spacing between components

        // Set background color to linear gradient
        root.setStyle("-fx-background-color: linear-gradient(to top, #cdffd8, #94b9ff);");

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT); // Set scene size
        stage.setScene(scene);
        stage.show();
    }

    // Method to open Patient Portal Login stage
    private void openPatientPortalLoginStage() {
        Stage stage = new Stage();
        VBox root = new VBox();

        // Title
        Label titleLabel = new Label("Patient Portal Login");
        titleLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold; -fx-font-family: 'Rockwell'; -fx-text-fill: navy;");
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

        // Button to create account and save data
        Button createAccountButton = new Button("Create Account");
        createAccountButton.setStyle("-fx-font-size: 12pt; -fx-font-weight: bold; -fx-background-color: grey; -fx-background-opacity: 0.3; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 1px; -fx-border-radius: 20em; -fx-background-radius: 20em; -fx-effect: dropshadow(three-pass-box, navy, 13, 0, 0, 0)");
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

        // Set background color to linear gradient
        root.setStyle("-fx-background-color: linear-gradient(to top, #cdffd8, #94b9ff);");

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT); // Set scene size
        stage.setScene(scene);
        stage.show();
    }

    // Method to open Patient Dashboard page after account creation
    private void openPatientDashboardPage(String fullName, String dob) {
        Stage stage = new Stage();
        VBox root = new VBox();

        // Title
        Label titleLabel = new Label("Patient Dashboard");
        titleLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold; -fx-font-family: 'Rockwell'; -fx-text-fill: navy;");
        titleLabel.setAlignment(Pos.CENTER);

        // Additional Information
        Label lastVisitLabel = new Label("Last Visit: 4/10/2024");
        Label notesLabel = new Label("Notes: The patient has high blood pressure and was prescribed Lisinopril");

        // Display the created account information
        Label fullNameLabel = new Label("Patient Full Name: " + fullName);
        Label dobLabel = new Label("Patient D.O.B: " + dob);

        // Text box entry for message to doctor
        TextField messageTextField = new TextField();
        messageTextField.setPromptText("Enter your message to the doctor");

        // Button to send message to doctor
        Button sendMessageButton = new Button("Send message to Doctor ➤");
        sendMessageButton.setStyle("-fx-font-size: 12pt; -fx-font-weight: bold; -fx-background-color: grey; -fx-background-opacity: 0.3; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 1px; -fx-border-radius: 20em; -fx-background-radius: 20em; -fx-effect: dropshadow(three-pass-box, navy, 13, 0, 0, 0)");
        sendMessageButton.setOnAction(event -> {
            String message = messageTextField.getText();
            // Implement logic to send message to doctor
            System.out.println("Message to doctor: " + message);
            // Show confirmation message
            Label confirmationLabel = new Label("Message had been sent. ✅");
            confirmationLabel.setTextFill(Color.GREEN);
            root.getChildren().add(confirmationLabel);
            // Clear the text field after sending message
            messageTextField.clear();
        });

        // Add components to the root
        root.getChildren().addAll(titleLabel, fullNameLabel, dobLabel, lastVisitLabel, notesLabel,
                messageTextField, sendMessageButton);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10); // Add spacing between components

        // Set background color to linear gradient
        root.setStyle("-fx-background-color: linear-gradient(to top, #cdffd8, #94b9ff);");

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT); // Set scene size
        stage.setScene(scene);
        stage.show();
    }

    // Method to open a new page for patient pharmacy/insurance information
    private void openPatientPharmacyInsurancePage() {
        Stage stage = new Stage();
        VBox root = new VBox();

        // Title
        Label titleLabel = new Label("Patient Pharmacy/Insurance Info");
        titleLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold; -fx-font-family: 'Rockwell'; -fx-text-fill: navy;");
        titleLabel.setAlignment(Pos.CENTER);

        // Text fields for patient information
        Label patientNameLabel = new Label("Patient Name:");
        TextField patientNameTextField = new TextField();

        Label patientDOBLabel = new Label("Patient DOB:");
        TextField patientDOBTextField = new TextField();

        // Text fields for pharmacy/insurance information
        Label pharmacyNameLabel = new Label("Pharmacy Name:");
        TextField pharmacyNameTextField = new TextField();

        Label insuranceProviderLabel = new Label("Patient Insurance Provider:");
        TextField insuranceProviderTextField = new TextField();

        Label policyNumberLabel = new Label("Policy Number:");
        TextField policyNumberTextField = new TextField();

        // Add components to the root
        root.getChildren().addAll(titleLabel, patientNameLabel, patientNameTextField, patientDOBLabel, patientDOBTextField,
                pharmacyNameLabel, pharmacyNameTextField, insuranceProviderLabel, insuranceProviderTextField,
                policyNumberLabel, policyNumberTextField);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10); // Add spacing between components

        // Set background color to linear gradient
        root.setStyle("-fx-background-color: linear-gradient(to top, #cdffd8, #94b9ff);");

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT); // Set scene size
        stage.setScene(scene);
        stage.show();
    }


 // Method to open Inbox page
    private void openInboxPage() {
        Stage stage = new Stage();
        VBox root = new VBox();

        // Title
        Label titleLabel = new Label("Inbox");
        titleLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold; -fx-font-family: 'Rockwell'; -fx-text-fill: navy;");
        titleLabel.setAlignment(Pos.CENTER);

        // Sample inbox items
        ListView<String> inboxListView = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList(
                "Message 1: From: Billy Bob - Where can i buy the medicine?",
                "Message 2: NONE",
                "Message 3: NONE",
                "Message 4: NONE",
                "Message 5: NONE"
        );

        // Set custom cell factory to include button
        inboxListView.setCellFactory(param -> new ListCell<String>() {
            private final VBox messageBox = new VBox();

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item);
                    setOnMouseClicked(event -> {
                        // Show message text field and send button
                        TextField messageTextField = new TextField();
                        messageTextField.setPromptText("Type your reply here...");
                        Button sendButton = new Button("Reply");
                        sendButton.setStyle("-fx-font-size: 6pt; -fx-background-color: grey; -fx-background-opacity: 0.3; -fx-text-fill: white; -fx-border-width: 1px; -fx-background-radius: 20em");
                        sendButton.setOnAction(e -> {
                            // Send the message
                            System.out.println("Message sent: " + messageTextField.getText());
                            Label confirmationLabel = new Label("Message had been sent. ✅");
                            confirmationLabel.setTextFill(Color.GREEN);
                            messageBox.getChildren().add(confirmationLabel);
                        });
                        HBox replyBox = new HBox(messageTextField, sendButton);
                        replyBox.setAlignment(Pos.CENTER_RIGHT);
                        messageBox.getChildren().clear();
                        messageBox.getChildren().add(replyBox);
                    });
                    setGraphic(messageBox);
                }
            }
        });

        inboxListView.setItems(items);

        // Add components to the root
        root.getChildren().addAll(titleLabel, inboxListView);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10); // Add spacing between components

        // Set background color to linear gradient
        root.setStyle("-fx-background-color: linear-gradient(to top, #cdffd8, #94b9ff);");

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT); // Set scene size
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
