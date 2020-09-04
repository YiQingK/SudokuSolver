public class SudokuSolver
{
	public static void main(String[] args)
	{
		Sudoku sudoku = new Sudoku();
		sudoku.enterboard();
		if (sudoku.solveboard())
		{
			sudoku.printboard();
		}
		else
		{
			System.out.println("There is no solution.");
		}
	}
}