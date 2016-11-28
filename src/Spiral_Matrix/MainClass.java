//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//For example,
//Given the following matrix:
//
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//You should return [1,2,3,6,9,8,7,4,5].

package Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

public class MainClass 
{
	public static void main(String[] args) 
	{
		int input[][] = {
							{ 1, 2, 3 },
							{ 4, 5, 6 },
							{ 7, 8, 9 }
						};
		
		System.out.println(spiralOrder(input));
	}

	public static List<Integer> spiralOrder(int[][] matrix) 
	{
		List<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length == 0) 
		{
			return list;
		}

		int startRow = 0;
		int endRow = matrix.length;

		int startColoum = 0;
		int endColoum = matrix[0].length;

		while (startRow < endRow && startColoum < endColoum) 
		{

			//prints left to right
			for (int i = startColoum; i < endColoum; i++) 
			{
				list.add(matrix[startRow][i]);
			}
			startRow++;

			//prints top to bottom
			for (int i = startRow; i < endRow; i++) 
			{
				list.add(matrix[i][endColoum - 1]);
			}
			endColoum--;

			//prints right to left
			if (startRow < endRow) 
			{
				for (int i = endColoum - 1; i >= startColoum; i--) 
				{
					list.add(matrix[endRow - 1][i]);
				}
				endRow--;
			}

			//prints bottom to top
			if (startColoum < endColoum) 
			{
				for (int i = endRow - 1; i >= startRow; i--) 
				{
					list.add(matrix[i][startColoum]);
				}
				startColoum++;
			}
		}

		return list;
	}
}
