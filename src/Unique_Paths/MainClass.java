//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//The robot can only move either down or right at any point in time.
//The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//How many possible unique paths are there?



package Unique_Paths;

public class MainClass 
{
	public static void main(String args[])
	{
		System.out.println(uniquePaths(23,12));
	}
	
	  public static int uniquePaths(int m, int n) 
	  {
		  return dynamicApproach(0,0,m,n);
//	        return recursiveApproach(0,0,m -1,n -1);
	  }
	    
	    private static int dynamicApproach(int x, int y, int m, int n) 
	    {
	    	int array[][] = new int[m][n];
	    	for(int  i = 0 ; i < m ; i++)
	    		array[i][0] = 1;
	    	
	    	for(int  i = 0 ; i < n ; i++)
	    		array[0][i] = 1;
	    	
	    	for(int i = 1; i < m ;i++)
	    	{
	    		for(int  k = 1 ; k < n ; k++)
	    		{
	    			array[i][k] = array[i-1][k] + array[i][k-1];
	    		}
	    	}
	    	
	    	return array[m-1][n-1];
	    }

		public static int recursiveApproach(int x, int y, int m, int n)
	    {
	        if(x==m && y== n)
	            return 1;

	        if(x>m || y >n)
	        	return 0;
	        
	        return recursiveApproach(x,y+1,m,n) + recursiveApproach(x+1,y,m,n);
	    }
	    
}

