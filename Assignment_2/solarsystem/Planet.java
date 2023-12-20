package solarsystem;
import exceptions.InvalidCelestialBodyException;
/**
 * @author Jaleel A. Rogers
 * Student Number: 11239
 * Date: 2/21/2023
 * Major: Computer Science
 *Child class of CelestialBody, responsible for Planet and attaching to Star
 */

public class Planet extends CelestialBody implements IOrbit
{
    private CelestialBody orbits;

    /**
     * @param orbits
     * @throws InvalidCelestialBodyException
     */
    public Planet(String name, CelestialBody orbits) throws InvalidCelestialBodyException
    {
        super(name, "Planet");
        if (orbits.getType().equals("Star"))
        {
            this.orbits = orbits;
        }

        else
        {
            throw new InvalidCelestialBodyException("A planet must orbit a star.");
        }

        /**
         * @param name will be the name of the planet
         * @param orbits will be the star
         * @throws InvalidCelestialBodyException
         * @return the planet or an exception if not attached to a proper star object
         */
    }
    public void getOrbit()
    {
        System.out.println(getName() + " is orbiting the " + orbits.getType() + " " + orbits.getName());
    }
    /**
     * @return the name of the planet, its type along with the name of the star it orbits
     */
}
