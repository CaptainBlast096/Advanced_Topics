package solarsystem;
import exceptions.DuplicateCelestialBodyException;
import java.util.ArrayList;

/**
 * @author Jaleel A. Rogers
 * Student Number: 11239
 * Date: 2/21/2023
 * Major: Computer Science
 *An abstract class and parent of the Star, Planet, and Moon classes
 */
public abstract class CelestialBody
{
    private String name;
    private String type;
    private ArrayList<CelestialBody> Children;

    /**
     * @param name is a String that contains the name of the CelestialBody
     * @param type is a String that contains the type of CelestialBody
     * Children is an ArrayList that will add each CelestialBody - Couldn't add a param ArrayList
     */

    public CelestialBody(String name, String type)
    {
        this.name = name;
        this.type = type;
        this.Children = new ArrayList<CelestialBody>();
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

    public void add(CelestialBody child) throws DuplicateCelestialBodyException
    //Not using ArrayList<CelestialBody> because passing the entire ArrayList as an argument but a single object
    {
        if (Children.contains(child))
        {
            throw new DuplicateCelestialBodyException ("The " + child.getType() + " " + child.getName() + " is already in the collection.");
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
