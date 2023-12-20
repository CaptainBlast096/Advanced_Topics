package solarsystem;
import exceptions.DuplicateCelestialBodyException;
import exceptions.InvalidCelestialBodyException;
/**
 * @author Jaleel A. Rogers
 * Student Number: 11239
 * Date: 2/21/2023
 * Major: Computer Science
 *The main file for outputing solarsystem
 */
public class SolarSystem
{
    public static void main(String[] args)
    {
        try
        {
            // Define the Sun
            Star sun = new Star("Sun", 5778);

            // Define the planets and add them to the Sun
            Planet mercury = new Planet("Mercury", sun);
            sun.add(mercury);
            Planet venus = new Planet("Venus", sun);
            sun.add(venus);
            Planet earth = new Planet("Earth", sun);
            sun.add(earth);
            Planet mars = new Planet("Mars", sun);
            sun.add(mars);
            Planet jupiter = new Planet("Jupiter", sun);
            sun.add(jupiter);
            Planet saturn = new Planet("Saturn", sun);
            sun.add(saturn);
            Planet uranus = new Planet("Uranus", sun);
            sun.add(uranus);
            Planet neptune = new Planet("Neptune", sun);
            sun.add(neptune);

            // Define the Moon and add it to Earth
            // Add the Moon, Phobos, and Deimos to their respective planets
            Moon moon = new Moon("Moon", earth);
            earth.add(moon);
            // Define Phobos and Deimos and add them to Mars
            Moon phobos = new Moon("Phobos", mars);
            mars.add(phobos);
            Moon deimos = new Moon("Deimos", mars);
            mars.add(deimos);

            //mars.getOrbit(); //For testing position of a planet
            //moon.getOrbit(); //For testing position of a moon
            //Planet pluto = new Planet ("Pluto", new Moon("Charon", mars)); //For Testing InvalidCelestialBodyException
            //sun.add(uranus); //For Testing DuplicateCelestialBodyException

        }
            catch (InvalidCelestialBodyException | DuplicateCelestialBodyException ex)
            {
                System.out.println(ex.getMessage());
            }
    }
        }

