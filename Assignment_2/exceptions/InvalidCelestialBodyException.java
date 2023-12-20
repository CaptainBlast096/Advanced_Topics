package exceptions;
/**
 * @author Jaleel A. Rogers
 * Student Number: 11239
 * Date: 2/21/2023
 * Major: Computer Science
 *Exception is responsible for improper Star, Planet, and Moon objects being attached to each other
 */
public class InvalidCelestialBodyException extends Exception
{
    public InvalidCelestialBodyException (String argMessage)
    {
        super (argMessage);
    }
}