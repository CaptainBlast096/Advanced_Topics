/**
 * @author Jaleel A. Rogers
 * Student Number: 11239
 * Date: 04/18/2023
 * Major: Computer Science
 * This program sends information to PokemonDayCare Server
 */
import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class TrainerClient extends Application
{
    DataOutputStream toServer;
    DataInputStream fromServer;

    private ComboBox <String> pokemonType = new ComboBox<>();
    private TextField pokemonName = new TextField();
    private Button Send = new Button ("Send to Day Care");
    private Button PickUp = new Button ("Pick Up From Day Care");
    private Pokemon pokemon;

    @Override
    public void start(Stage stage)
    {

        BorderPane pane = new BorderPane();
        pokemonType.getItems().addAll("Bulbasaur", "Charmander", "Squirtle", "Pikachu");


        GridPane paneForPokemonInfo = new GridPane();
        paneForPokemonInfo.setHgap(10);
        paneForPokemonInfo.setVgap(10);
        paneForPokemonInfo.setPadding(new Insets(10, 10, 10, 10));
        paneForPokemonInfo.add(new Label("Choose a Pokemon Type"), 0, 0);
        paneForPokemonInfo.add(pokemonType, 1, 0);
        paneForPokemonInfo.add(new Label("Pokemon's Name"), 0, 1);
        paneForPokemonInfo.add(pokemonName, 1, 1);
        paneForPokemonInfo.add(Send, 0, 2);
        paneForPokemonInfo.add(PickUp, 1, 2);

        pane.setCenter(paneForPokemonInfo);

        //Send.setDisable(true);
        PickUp.setDisable(true);

        Send.setOnAction( e -> sendToDayCare());
        PickUp.setOnAction( e -> pickUpFromDayCare());

        Scene scene = new Scene(pane, 400, 150);
        stage.setTitle("Trainer Client");
        stage.setScene(scene);
        stage.show();
    }

    private void sendToDayCare()
    {
        try
        {
            Socket socket = new Socket("localhost", 8000);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            pokemon = new Pokemon(pokemonType.getValue(), pokemonName.getText());
            pokemon.checkIn();
            objectOutputStream.writeObject(pokemon);
            objectOutputStream.flush();

            pokemonName.clear();
            pokemonType.setValue(null);

            Send.setDisable(true); // Disable the Send button after sending data
            PickUp.setDisable(false); // Enable the PickUp button after sending data

            // Disable the combo box and text field
            pokemonType.setDisable(true);
            pokemonName.setDisable(true);

        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }
    }

    private void pickUpFromDayCare()
    {
        try (Socket socket = new Socket("localhost", 8000);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream()))
        {

            // Create a new Pokemon object with an empty name
            Pokemon pokemon = new Pokemon(pokemonType.getValue(), "");

            // Set the "checked out" flag to true
            pokemon.checkOut();

            // Send the Pokemon object to the server
            objectOutputStream.writeObject(pokemon);
            objectOutputStream.flush();

            // Read the Pokemon object returned by the server
            pokemon = (Pokemon) objectInputStream.readObject();

            // Update the name field with the name of the checked-out Pokemon
            pokemonName.setText(pokemon.getName());

            // Update the Pokemon type field with the type of the checked-out Pokemon
            pokemonType.setValue(pokemon.getPokemonType());

            // Disable the Pick Up button after picking up data
            PickUp.setDisable(true);

            // Enable the combo box, button, and text field
            pokemonType.setDisable(false);
            pokemonName.setDisable(false);
            Send.setDisable(false);

        }
        catch (IOException | ClassNotFoundException ex)
        {
            System.out.println(ex);
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
