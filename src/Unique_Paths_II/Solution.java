//Follow up for "Unique Paths":
//
//Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
//For example,
//There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//The total number of unique paths is 2.

package Unique_Paths_II;

public class Solution 
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if(m==1 && n==1)
        {
            if (obstacleGrid[0][0] == 1)
                return 0;
            else
                return 1;
        }
        if (obstacleGrid[0][0] == 1)
            return 0;
        
        return dynamicApproach(0,0,m,n, obstacleGrid);
    }
	    
    private  int dynamicApproach(int x, int y, int m, int n , int[][] obstacleGrid) 
    {
    	int array[][] = new int[m][n];
    	array[0][0] = 1;
    	
    	for(int  i = 1 ; i < m ; i++)
    	{
    	    if(obstacleGrid[i][0] == 0 && array[i - 1][0] != 0)
    		    array[i][0] = 1;
    	}
    	
    	for(int  i = 1 ; i < n ; i++)
    	{
    	    if(obstacleGrid[0][i] == 0 && array[0][i-1] != 0)
        		array[0][i] = 1;
    	}
    	
    	for(int i = 1; i < m ;i++)
    	{
    		for(int  k = 1 ; k < n ; k++)
    		{
    		    if(obstacleGrid[i][k] == 0)
    			    array[i][k] = array[i-1][k] + array[i][k-1];
    		}
    	}
    	
    	return array[m-1][n-1];
    }
}
