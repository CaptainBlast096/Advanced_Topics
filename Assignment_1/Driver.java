import java.util.Scanner;

/**
 *@author Jaleel A. Rogers
 *Student Number: 11239
 *Date: 2/07/2023
 *Major: Computer Science
 *This program contains to classes, Sudoku which contains methods creating the Sudoku puzzle and rules
 *  and Driver class which contains the main method and user interface
 */


public class Driver
{
    /**
     * This is the main method creating an object of the Sudoku class
     *  Prompting user to enter the number of rows, columns, and boxes
     * @param args
     * A switch statement is a good method for making a game menu as there are multiple choices to choose from
     * On line 94, when using break, the program would not exit, so I used a return statement as an alternative
     * */

    public static void main(String[] args)
    {
        int[][] grid =
                {{5, 3, 4, 0, 7, 8, 9, 1, 2},
                        {6, 7, 0, 1, 9, 5, 3, 4, 8},
                        {1, 9, 8, 3, 4, 2, 5, 0, 7},
                        {8, 0, 9, 7, 6, 1, 4, 2, 3},
                        {4, 2, 6, 8, 0, 3, 7, 9, 0},
                        {7, 1, 3, 9, 2, 4, 8, 5, 6},
                        {9, 0, 1, 5, 3, 7, 2, 8, 4},
                        {2, 8, 7, 4, 1, 9, 6, 0, 5},
                        {3, 4, 5, 2, 8, 6, 1, 7, 9}};
        //Hard-coded the grid
        int row, col, value;
        Sudoku game = new Sudoku(grid);
        Scanner scanner = new Scanner(System.in);
        game.display();

        while (!game.isSolved()) // Accidentally  used the solved grid which caused the isSolved method to return true making the while loop not run
        {


            System.out.println("Continue Playing (Y/N)?");
            String choice = scanner.next(); //Allows user to enter Y or N

            switch (choice)
            {
                case "Y":
                {
                    System.out.print("\nEnter row: ");
                    row = scanner.nextInt() -1;

                    System.out.print("Enter column: ");
                    col = scanner.nextInt() -1;

                    System.out.print("Enter value: ");
                    value = scanner.nextInt();

                    if (!game.isRowColumnValid(row, col))
                    {
                        System.out.println("Invalid row/column");
                        break;

                    }
                    if (game.isEntryValid(row, col)) // Made this into a condition instead of a method
                    {
                        System.out.println("Wrong Entry");
                        game.display();
                        break;
                    }

                    if (!game.isValueValid(value))
                    {
                        System.out.println("Invalid value");
                        break;
                    }

                    if (!game.isEntryCorrect(row, col, value))
                    {
                        System.out.println("NOT Correct!");
                        game.display();
                        break;
                    }
                    else
                    {
                        System.out.println("Correct!");
                        game.grid[row][col] = value; //Updates
                        game.display();
                        break;
                    }
                }
                case "N":
                {
                    return;
                }
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
        if (game.isSolved()) //Put at the start of the while loop so that statement is reachable
        {
            System.out.println("Congratulations, You solved it!");
        }
    }
}

