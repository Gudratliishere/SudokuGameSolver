package com.company.sudokugamesolver;

import java.util.Scanner;

/**
 *
 * @author Dunay Gudratli
 */
public class Main
{

    public static void main(String[] args)
    {
        Solver solver = new Solver();

        int[][] grid = new int[9][9];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();

        solver.setGrid(grid);
        System.out.println("Solve result : " + solver.solveGrid());
        solver.printGrid();
    }
}
