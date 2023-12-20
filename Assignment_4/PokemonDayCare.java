/**
 * @author Jaleel A. Rogers
 * Student Number: 11239
 * Date: 04/18/2023
 * Major: Computer Science
 * This program recieves the information from TrainerClient
 */
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class PokemonDayCare extends Application
{
    private AtomicInteger totalConnections = new AtomicInteger(0); // Initialize with 0
    private TextArea textArea;

    @Override
    public void start(Stage serverStage)
    {
        textArea = new TextArea();
        textArea.setEditable(false); // Disable editing
        StackPane pane = new StackPane(textArea);
        Scene scene = new Scene(pane, 400, 200);
        serverStage.setTitle("Pokemon Day Care");
        serverStage.setScene(scene);
        serverStage.show();

        new Thread(() ->
        {
            try {

                ServerSocket serverSocket = new ServerSocket(8000);
                // Date
                Platform.runLater(() ->
                {
                    textArea.appendText("Server started at " + new Date() + '\n');
                    textArea.appendText("Waiting for connections...\n");
                });
                while (true)
                {
                    // Listens for request
                    Socket socket = serverSocket.accept();
                    totalConnections.incrementAndGet(); // Increment totalConnections

                    // Create a new thread for the client session
                    new Thread(() ->
                    {
                        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                             ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream()))
                        {

                            while (true)
                            {
                                Pokemon pokemon;
                                pokemon = (Pokemon) objectInputStream.readObject();
                                String pokemonName = pokemon.getName();
                                if (pokemon.isCheckedIn())
                                {
                                    Platform.runLater(() ->
                                            textArea.appendText("Pokemon " + pokemonName + " has been checked in.\n"));
                                } else {
                                    Platform.runLater(() ->
                                            textArea.appendText("Pokemon " + pokemonName + " has been checked out.\n"));
                                }

                                // Compute information
                                objectOutputStream.writeObject(pokemon);
                                objectOutputStream.flush();
                            }
                        }
                        catch (IOException | ClassNotFoundException ex)
                        {
                            ex.printStackTrace();
                        }
                    }).start();

                    Platform.runLater(() ->
                            textArea.appendText("New connection made with trainer. Total connections = " + totalConnections.get() + "\n")); // Get current value of totalConnections
                    Platform.runLater(() ->
                            textArea.appendText("Trainer's IP Address: " + socket.getInetAddress().getHostAddress() + "\n"));
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
