package exceptions;
/**
 * @author Jaleel A. Rogers
 * Student Number: 11239
 * Date: 2/21/2023
 * Major: Computer Science
 *Exception is responsible for duplicate objects in the ArrayList
 */
public class DuplicateCelestialBodyException extends Exception
{
    public DuplicateCelestialBodyException (String argMessage)
    {
        super (argMessage);
    }
}
