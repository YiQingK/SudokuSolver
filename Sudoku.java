import java.util.*;

public class Sudoku
{
	private int[][] board;

	public Sudoku() //create a board
	{
		board = new int[9][9];

	}
	public void enterboard() //get numbers from user
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the board, using 0 to indicate blank cells. 9 values at a time with a space between each.");
		for (int x =0;x<9;x++)
		{
			for (int y =0; y<9;y++)
			{
				int temp = scan.nextInt();
				board[x][y] = temp;
			}
		}
	}

	public boolean solveboard() //fill in the board
	{
		for (int row = 0; row<9; row++)
		{
			for (int col = 0; col<9; col++)
			{
				if (board[row][col] == 0) //check if slot is empty
				{
					for (int num =1; num <= 9; num++) //run through possible options
					{
						if(isValid(row,col,num)) //check to see if num is valid in slot
						{
							board[row][col] = num; //set num as temp ans in slot

							if(solveboard())
							{
								return true; 
							}
							else
								board[row][col] = 0; //reset slot

						}
					}
					return false;
				}
			}
		}
		return true;
	}

	public void printboard()
	{
		System.out.println("  - - -   - - -   - - -");
		for (int r = 0; r<9; r++)
		{
			System.out.print("| ");
			for (int c = 0; c<9; c++)
			{
				System.out.print(board[r][c] + " ");
				if (c == 2 || c == 5 || c ==8)
				{
					System.out.print("| ");
				}
			}
			if (r == 2 || r == 5 || r == 8)
			{
				System.out.println();
				System.out.print("  - - -   - - -   - - -");
			}

			System.out.println();
		}
	}

	private boolean isValid(int row, int col, int num)
	{
		//Check row
		for (int i = 0; i<9; i++)
		{
			if(board[row][i] == num)
			{
			return false;
			}
		}
		//Check col
		for (int j =0; j<9; j++)
		{
			if(board[j][col] == num)
			{
				return false;
			}
		}
		//Check sub-grid
		int boxrow = row - row%3;
		int boxcol = col - col%3;
		for (int r = boxrow; r<boxrow +3; r++)
		{
			for ( int c = boxcol; c<boxcol +3; c++)
			{
				if(board[r][c] == num)
				{
					return false;
				}
			}
		}

		return true;
	}


}