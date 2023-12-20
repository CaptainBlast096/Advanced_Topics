package panes;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox; // Library required

/**
 * @author Jaleel A. Rogers
 * Student Number: 11239
 * Date: 3/26/2023
 * Major: Computer Science
 *Creates a pane for the DuplicateCelestialBodyException
 */

public class ErrorPane extends VBox
{

    public ErrorPane(String errorMessage)
    {
        Label label = new Label(errorMessage); //Create a new label with the following text

        Button okButton = new Button("Ok"); //Create a new button with the following text
        okButton.setOnAction(event -> Platform.exit()); //When the button is clicked, the program will exit
        //this.getChildren().addAll(label, okButton); //Add the label and button to the VBox

        VBox vbox = new VBox(label, okButton); //Create a new VBox to hold the label and button
        vbox.setSpacing(10); //Set the spacing between the label and button to 10
        vbox.setAlignment(Pos.CENTER); //Set the alignment of the VBox to the center (horizontally and vertically
        StackPane stack = new StackPane(); // Create a new stack pane to hold the label
        stack.getChildren().add(vbox); //Add the label to the stack pane | could use "this" instead of label

        Scene scene = new Scene(stack, 300, 100); // Create a new scene with the stack pane as the root and size is 300 X 250

        Stage stage = new Stage(); //Create a new window
        stage.setTitle("Error"); //Set the title of window
        stage.setScene(scene); //Set the scene in the window
        stage.show(); //Show the window
    }
}
