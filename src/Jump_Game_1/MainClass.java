//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
//
//For example:
//A = [2,3,1,1,4], return true.
//
//A = [3,2,1,0,4], return false.

package Jump_Game_1;

public class MainClass 
{
	public static void main(String[] args) 
	{
		int[] input = {2,3,1,1,4};
		System.out.println(canJump(input));
	}
	
	
	public static boolean canJump(int[] nums) 
	{
	    if( nums.length <= 1)
	        return true;
	    int maxReachableIndex = 0;
	    for(int  i = 0 ; i < nums.length -1 ; i++)
	    {
	        if(maxReachableIndex <= i  && nums[i] == 0)
	            break;
	       
	        if(i + nums[i] >= nums.length -1 )
	            return true;
	        
	        if(i + nums[i] > maxReachableIndex )
	        	maxReachableIndex = i + nums[i];
	    }
	    
	    return false;
	}

}
