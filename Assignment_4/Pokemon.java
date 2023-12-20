/**
 * @author Jaleel A. Rogers
 * Student Number: 11239
 * Date: 04/18/2023
 * Major: Computer Science
 * This is the main Pokemon class
 */
import java.io.Serializable;
import java.util.UUID;

public class Pokemon implements Serializable
{
    private UUID pokemonID;
    private String pokemonType;
    private String name;
    private boolean checkedIn;

    public Pokemon(String pokemonType, String name)
    {
        this.pokemonID = UUID.randomUUID();
        this.pokemonType = pokemonType;
        this.name = name;
    }

    public UUID getPokemonID()
    {
        return pokemonID;
    }

    public String getPokemonType()
    {
        return pokemonType;
    }

    public String getName()
    {
        return name;
    }

    public boolean isCheckedIn()
    {
        return checkedIn;
    }

    public void checkIn()
    {
        checkedIn = true;
    }

    public void checkOut()
    {
        checkedIn = false;
    }
}
