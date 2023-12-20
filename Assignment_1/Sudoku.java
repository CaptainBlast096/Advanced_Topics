/**
 @author Jaleel A. Rogers
 *Student Number: 11239
 *Date: 2/07/2023
 *Major: Computer Science
 *This program contains to classes, Sudoku which contains methods creating the Sudoku puzzle and rules
 *  and Driver class which contains the main method and user interface
 */
public class Sudoku
{
    int[][] grid;
    public Sudoku (int[][] array)
    {
        grid = new int [9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
            {
                grid[i][j] = array[i][j];
            }
    }

    /**
     * @return  Displays the sudoku grid
     * The outer for loop iterates each row of the sudoku grid
     * The inner for loop iterates each column of the sudoku grid
     * Added a border to the top and bottom of the grid
     */
    public void display()
    {
        for (int row = 0; row < 9; row++)
        {
            if (row % 3 == 0)
            {
                System.out.println("------+-------+-------");
            }
            for (int col = 0; col < 9; col++)
            {
                System.out.print(grid[row][col]);
                if (col == 2 || col == 5 )
                {
                    System.out.print(" | ");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("------+-------+-------");
    }

    /**
     * @return  Will check to see if the grid is solved
     * The outer for loop checks each row of the sudoku grid
     * The inner for loop checks each column of the sudoku grid
     */
    public boolean isSolved()
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (grid[i][j] == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @param value user inputted value for number ranging from 1 to 9
     * @return  false if value is less than 1 or greater than 9 and returns true otherwise
     */
    public boolean isValueValid(int value)
    {
        if (value < 1 || value > 9)
        {
            return false;
        }
        else return true;
    }

    /**
     * @param row user inputted value representing the row in the puzzle
     * @param col user inputted value representing the column in the puzzle
     * @return  returns false if row or column is less than 1 or greater than 9 returns true otherwise
     */
    public boolean isRowColumnValid( int row, int col)
    {
        if (row < 0 || row > 8 || col < 0 || col > 8)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * @param row user inputted value representing the row in the puzzle
     * @param col user inputted value representing the column in the puzzle
     * @return  returns false if location within grid is not equal to 0
     */
    public boolean isEntryValid(int row, int col)
    {
        if (grid[row][col] == 0)
        {
            return false;
        }
        return true;
    }

    /**
     * @param row user inputted value representing the row in the puzzle
     * @param col user inputted value representing the column in the puzzle
     * @param value user inputted value for number ranging from 1 to 9
     * @return  true if row and col are greater than or equal to 0 and less than or equal to 9
     *   //checkRow & checkCol will check if the value is unique within the sub-grid
     */
    public boolean isEntryCorrect(int row, int col, int value) //Difficulty confirming results
    {
        for (int j = 0; j < 9; j++)
        {
            if (grid[row][j] == value)
            {
                return false;
            }
        }

        for (int i = 0; i < 9; i++)
        {
            if (grid[i][col] == value)
            {
                return false;
            }
        }

        int checkRow = row - row % 3;
        int checkCol = col - col % 3;

        for (int i = checkRow; i < checkRow + 3; i++)
        {
            for (int j = checkCol; j < checkCol + 3; j++)
            {
                if (grid[i][j] == value)
                {
                    return false;
                }
            }
        }
        return true;
    }
}