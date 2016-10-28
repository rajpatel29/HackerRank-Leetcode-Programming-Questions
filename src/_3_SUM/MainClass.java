//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
//Find all unique triplets in the array which gives the sum of zero.
//
//Note: The solution set must not contain duplicate triplets.
//For example, given array S = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]

package _3_SUM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MainClass 
{
	public static void main(String args[])
	{
		int array[] = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> answer= threeSum(array);
		System.out.println(answer);
	}
	
	public static List<List<Integer>>  threeSum(int[] array) 
    {
        ArrayList<List<Integer>> res = new ArrayList<>() ;
        HashSet<ArrayList<Integer>> result = new HashSet<>();

		if(array == null && array.length < 3)
		{
			return null;
		}
		
		Arrays.sort(array);
		
		for (int i = 0; i < array.length - 2; i++)
		{
			int start = i + 1;
			int end =  array.length - 1;
			
			while(start < end)
			{
				if(array[i] + array[start] + array[end] == 0 )
				{
					ArrayList<Integer> solution = new ArrayList<>();
					solution.add(array[i]);
					solution.add(array[start]);
					solution.add(array[end]);
					start++;
					end--;
					result.add(solution);
				}
				else
				{
					if(array[i] + array[start] + array[end] < 0)
					{
						start++;
					}
					else
					{
						end--;
					}
				}
			}
		}
		
		//to remove duplicates we need to use Hashset
        res.addAll(result);
		return res;    
    }
}

