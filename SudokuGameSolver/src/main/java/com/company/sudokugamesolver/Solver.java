package com.company.sudokugamesolver;

/**
 *
 * @author Dunay Gudratli
 */
public class Solver
{

    private int[][] grid;

    private final int GRID_SIZE = 9;

    public int[][] getGrid()
    {
        return grid;
    }

    public void setGrid(int[][] grid)
    {
        this.grid = grid;
    }

    private boolean isThereInRow(int number, int row)
    {
        for (int i = 0; i < GRID_SIZE; i++)
            if (grid[row][i] == number)
                return true;

        return false;
    }

    private boolean isThereInColumn(int number, int column)
    {
        for (int i = 0; i < GRID_SIZE; i++)
            if (grid[i][column] == number)
                return true;

        return false;
    }

    private boolean isThereInBox(int number, int row, int column)
    {
        int beginRow = row - row % 3;
        int beginColumn = column - column % 3;

        for (int i = beginRow; i < beginRow + 3; i++)
            for (int j = beginColumn; j < beginColumn + 3; j++)
                if (grid[i][j] == number)
                    return true;

        return false;
    }

    private boolean isValidReplacement(int number, int row, int column)
    {
        return !(isThereInRow(number, row) || isThereInColumn(number, column) || isThereInBox(number, row, column));
    }

    public boolean solveGrid()
    {
        for (int row = 0; row < GRID_SIZE; row++)
            for (int column = 0; column < GRID_SIZE; column++)
                if (grid[row][column] == 0)
                {
                    for (int tryNumber = 1; tryNumber <= GRID_SIZE; tryNumber++)
                        if (isValidReplacement(tryNumber, row, column))
                        {
                            grid[row][column] = tryNumber;

                            if (solveGrid())
                                return true;
                        }

                    grid[row][column] = 0;
                    return false;
                }

        return true;
    }

    public void printGrid()
    {
        for (int row = 0; row < GRID_SIZE; row++)
        {
            if (row % 3 == 0 && row != 0)
                System.out.println("-----------");

            for (int column = 0; column < GRID_SIZE; column++)
            {
                if ((column) % 3 == 0 && column != 0)
                    System.out.print("|");

                System.out.print(grid[row][column]);
            }

            System.out.println();
        }
    }

}
