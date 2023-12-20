package solarsystem;
import javafx.scene.paint.Color; //For some you can't inherit imported packages
/**
 * @author Jaleel A. Rogers
 * Student Number: 11239
 * Date: 3/26/2023
 * Major: Computer Science
 *A child class of the abstract class CelestialBody
 */
public class Star extends CelestialBody
{
    private int surfaceTemp;

    /**
     * @param surfaceTemp
     * Will be used for the Star class exclusively
     */
    public Star(String name, int surfaceTemp, Color color, double radius)
    {
        super(name, "Star", color, radius);
        //type would be hardcoded because Star objects are fixed with the type Star
        this.surfaceTemp = surfaceTemp;
    }

    public int getSurfaceTemp()
    {
        return surfaceTemp;
    }
/**
 * @param getSurfaceTemp is a constructor of the Star class
 * @return surface temperature
 */
}
