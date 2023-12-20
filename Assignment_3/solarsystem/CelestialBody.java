package solarsystem;
import exceptions.DuplicateCelestialBodyException;
import java.util.ArrayList;
import javafx.scene.shape.Circle; //This class will inherit from javafx class Circle
import javafx.scene.paint.Color; //This class will inherit from javafx class Color

/**
 * @author Jaleel A. Rogers
 * Student Number: 11239
 * Date: 3/26/2023
 * Major: Computer Science
 *An abstract class and parent of the Star, Planet, and Moon classes
 */
public abstract class CelestialBody extends Circle
{
    private String name;
    private String type;
    private ArrayList<CelestialBody> Children;

    /**
     * @param name is a String that contains the name of the CelestialBody
     * @param type is a String that contains the type of CelestialBody
     * Children is an ArrayList that will add each CelestialBody - Couldn't add a param ArrayList
     */

    public CelestialBody(String name, String type, Color color ,double radius)
    {
        super(radius, color); //Oddly enough I can only do this order and not color, radius. I think It's because parameters in the color or circle function
        this.name = name;
        this.type = type;
        this.Children = new ArrayList<CelestialBody>();
        setOnMouseClicked(e->getInformation()); //This is a lambda expression that will call the getInformation method when the mouse is clicked on the object

    }

    /**
     * @CelestialBody is a constructor of CelestialBody
     * @return the name type that has two parameters name and type
     */

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public void getInformation()
    {
        System.out.println("This is the " + getType() + " " + getName());
    }

    public void add(CelestialBody child) throws DuplicateCelestialBodyException
    //Not using ArrayList<CelestialBody> because passing the entire ArrayList as an argument but a single object
    {
        if (Children.contains(child))
        {
            throw new DuplicateCelestialBodyException ("The " + child.getType() + " " + child.getName() + " is already in the collection");
        }
        else
        {
            Children.add(child); //Used to keep track of duplicates without it, the ArrayList couldn't register the value
            System.out.println ("The " + child.getType() + " " + child.getName() + " was added successfully to " + this.getName() + ".");
        }
    }

    public ArrayList<CelestialBody> getChildren()
    {
        return Children;
    }

    /**
     * @param getChildren is a constructor of CelestialBody
     * @return Children
     */
}
