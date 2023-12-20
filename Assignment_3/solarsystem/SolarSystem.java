package solarsystem;
import exceptions.DuplicateCelestialBodyException;
import exceptions.InvalidCelestialBodyException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import panes.SolarSystemPane;
import panes.ErrorPane;

/**
 * @author Jaleel A. Rogers
 * Student Number: 11239
 * Date: 3/26/2023
 * Major: Computer Science
 *The main file for outputing solarsystem
 */



public class SolarSystem extends Application
{
    //Deciding whether to make the specifier public or private
    public Star sun;
    public Planet mercury, venus, earth, mars, jupiter, saturn, uranus, neptune;
    public Moon moon, phobos, deimos;
    public SolarSystemPane solarSystemPane;

    @Override
    public void start (Stage stage) //Modifying the main method seemed to fix the extends Application error
    {

        try
        {
            // Define the Sun
            Star sun = new Star("Sun", 5778, Color.YELLOW, 70);
            // Define the planets and add them to the Sun
            Planet mercury = new Planet("Mercury", sun, Color.GRAY, 10);
            sun.add(mercury);
            Planet venus = new Planet("Venus", sun, Color.ORANGE, 15);
            sun.add(venus);
            Planet earth = new Planet("Earth", sun, Color.BLUE, 20);
            sun.add(earth);
            Planet mars = new Planet("Mars", sun, Color.RED, 13);
            sun.add(mars);
            Planet jupiter = new Planet("Jupiter", sun, Color.TAN, 40);
            sun.add(jupiter);
            Planet saturn = new Planet("Saturn", sun, Color.BEIGE, 35); //Knowing it had BEIGE made my day
            sun.add(saturn);
            Planet uranus = new Planet("Uranus", sun, Color.LIGHTBLUE, 30);
            sun.add(uranus);
            Planet neptune = new Planet("Neptune", sun, Color.PURPLE, 30);
            sun.add(neptune);

            // Define the Moon and add it to Earth
            // Add the Moon, Phobos, and Deimos to their respective planets
            Moon moon = new Moon("Moon", earth, Color.DIMGRAY, 5);
            earth.add(moon);
            // Define Phobos and Deimos and add them to Mars
            Moon phobos = new Moon("Phobos", mars, Color.DIMGRAY, 2.5);
            mars.add(phobos);
            Moon deimos = new Moon("Deimos", mars, Color.DIMGRAY, 2.5);
            mars.add(deimos);

            //mars.getOrbit(); //For testing position of a planet
            //moon.getOrbit(); //For testing position of a moon
            //Planet pluto = new Planet("Pluto", new Moon("Charon", mars, Color.GREEN, 14), Color.GRAY, 5); //For Testing InvalidCelestialBodyException
            //sun.add(uranus); //For Testing DuplicateCelestialBodyException

            //Creating the pane
                SolarSystemPane solarSystemPane = new SolarSystemPane();
            //Sun
                solarSystemPane.addStar(sun);
            //Planets
                solarSystemPane.addPlanet(mercury, 60);
                solarSystemPane.addPlanet(venus, 110);
                solarSystemPane.addPlanet(earth, 160);
                solarSystemPane.addPlanet(mars, 210);
                solarSystemPane.addPlanet(jupiter, 280);
                solarSystemPane.addPlanet(saturn, 350);
                solarSystemPane.addPlanet(uranus, 420);
                solarSystemPane.addPlanet(neptune, 490);
            //Moons
                solarSystemPane.addMoon(moon, 20);
                solarSystemPane.addMoon(phobos, 10);
                solarSystemPane.addMoon(deimos, 15);

            //Creating the scene
                Scene scene = new Scene(solarSystemPane, 1000,500);
                stage.setScene(scene);
                stage.setTitle("Solar System Model");
                stage.show();
        }
        catch (InvalidCelestialBodyException | DuplicateCelestialBodyException ex)
        {
            ErrorPane errorPane = new ErrorPane(ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

