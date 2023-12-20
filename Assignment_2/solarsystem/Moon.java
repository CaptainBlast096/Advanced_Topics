package solarsystem;

import exceptions.InvalidCelestialBodyException;
/**
 * @author Jaleel A. Rogers
 * Student Number: 11239
 * Date: 2/21/2023
 * Major: Computer Science
 *Child class of CelestialBody, responsible for Moon and attaching to Planet
 */
public class Moon extends CelestialBody implements IOrbit
{
    private CelestialBody orbits;

    /**
     * @param orbits
     * @throws InvalidCelestialBodyException
     */
    public Moon (String name, CelestialBody orbits) throws InvalidCelestialBodyException //I find it a problem it dosen't notify me up specifier
    {
        super (name, "Moon");

        if (orbits.getType().equals("Planet"))
        {
            this.orbits = orbits;
        }

        else
        {
            throw new InvalidCelestialBodyException("A moon must orbit a planet.");
        }
        /**
         * @param name will be the name of the moon
         * @param orbits will be the planet
         * @throws InvalidCelestialBodyException
         * @return the moon or an exception if not attached to a proper planet object
         */
    }
    public void getOrbit()
    {
        System.out.println(getName() + " is orbiting the " + orbits.getType() + " " + orbits.getName());
    }
    /**
     * @return the name of the moon, its type along with the name of the planet it orbits
     */
}
