package panes;
// Library required for class Pane
    import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

//Libraries imported from the solarsystem package
    import solarsystem.Star;
    import solarsystem.Planet;
    import solarsystem.Moon;

/**
 * @author Jaleel A. Rogers
 * Student Number: 11239
 * Date: 3/26/2023
 * Major: Computer Science
 *Will visually display the solar system
 */
public class SolarSystemPane extends Pane
{
    public SolarSystemPane()
    {
        //Sets the background color of the pane
        this.setStyle("-fx-background-color: black;");
    }

    public void addStar(Star star)
    {
        //Try replacing setCenter with getLayout | set the position of the star at the center of the pane
        //setCenterX and setCenterY are part of the Circle class and are used center objects while setLayout set position relative to its parent in a pane
        star.setCenterX(0);
        star.setCenterY(0);
        //Adds the star to the pane
        this.getChildren().add(star);

    }

    public void addPlanet(Planet planet, double distance)
    {
        //Adds the planet to the pane
        this.getChildren().add(planet);

        //Sets the position of the planet
        planet.setCenterX(distance);
        planet.setCenterY(distance);

        //Create a circle to represent the orbit of the planet
        Circle orbit = new Circle(distance, Color.TRANSPARENT);
            orbit.setStroke(Color.WHITE);
            orbit.setCenterX(0);
            orbit.setCenterY(0);
            orbit.setMouseTransparent(true);
            //Set the radius of the orbit based on the position of the planet and the distance
            orbit.setRadius(Math.sqrt(Math.pow(planet.getOrbit().getLayoutX() - distance, 2)+ Math.pow(planet.getOrbit().getLayoutY() - distance, 2)));

        // Add the planet to the pane if it is not already added
        if (!getChildren().contains(orbit))
        {
            getChildren().add(orbit);
        }
        //Send the orbit to the back of the pane
        orbit.toBack();

        // Add the planet to the pane if it is not already added
        if (!getChildren().contains(planet))
        {
            getChildren().add(planet);
        }

        // Add the orbit of the planet to the pane if it is not already added
        if (!getChildren().contains(planet.getOrbit()))
        {
            getChildren().add(planet.getOrbit());
        }
    }


    public void addMoon(Moon moon, double distance)
    {
        //Adds the moon to the pane
        this.getChildren().add(moon);

        //Sets the position of the moon | distance is somewhat inaccurate so I added to it
        double planetX = moon.getOrbit().getCenterX();
        double planetY = moon.getOrbit().getCenterY();
        moon.setCenterX(planetX + distance + 2);
        moon.setCenterY(planetY + distance + 2);

        //Create a circle to represent the orbit of the moon
        Circle orbit = new Circle(distance , Color.TRANSPARENT);
            orbit.setStroke(Color.WHITE);
            orbit.setCenterX(planetX);
            orbit.setCenterY(planetY);
            orbit.setMouseTransparent(true);
            //Set the radius of the orbit based on the position of the moon and the distance
            orbit.setRadius(Math.sqrt(Math.pow(moon.getOrbit().getLayoutX() - distance, 2)+ Math.pow(moon.getOrbit().getLayoutY() - distance, 2)) + 4);

        // Add the moon to the pane if it is not already added
        if (!getChildren().contains(orbit))
        {
            getChildren().add(orbit);
        }
        //Send the orbit to the back of the pane
        orbit.toBack();

        // Add the moon to the pane if it is not already added
        if (!getChildren().contains(moon))
        {
            getChildren().add(moon);
        }

        // Add the orbit of the moon to the pane if it is not already added
        if (!getChildren().contains(moon.getOrbit()))
        {
            getChildren().add(moon.getOrbit());
        }
    }
}
