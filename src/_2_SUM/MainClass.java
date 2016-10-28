//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//You may assume that each input would have exactly one solution.
//
//Example:
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].

package _2_SUM;

import java.util.HashMap;

public class MainClass 
{
	public static void main(String[] args) 
	{
		int array[] = {3,2,4};
		int result[] = twoSum(array , 6);
		
		for (int i = 0; i < result.length; i++) 
		{
			System.out.println(result[i]);
		}
	}
		
	public static int[] twoSum(int[] nums, int target) 
	{
        int result[] = new int[2];	
        HashMap<Integer , Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length ;  i++)
        {
        	if(map.containsKey(nums[i]))
        	{
        		if(nums[i] * 2 == target)
        		{
        			result[0] = map.get(nums[i]);
   				result[1] = i;
   				return result;
        		}
        	}
        	else
			map.put(nums[i], i);
		}
        
        for(Integer element : map.keySet())
        {
        	if(map.containsKey(target - element))
        	{
        		result[0] = map.get(element);
			result[1] = map.get(target - element);
			return result;
        	}
        }

        return result;
    }
}
