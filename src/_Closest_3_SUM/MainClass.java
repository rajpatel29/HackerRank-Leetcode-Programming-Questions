//Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
//Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//    For example, given array S = {-1 2 1 -4}, and target = 1.
//
//    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

package _Closest_3_SUM;

import java.util.ArrayList;
import java.util.Arrays;

public class MainClass 
{
	public static void main(String args[])
	{
		int array[] = {-1 , 2 , 1 , -4};
		int target = 1;
		
		closest3SUM(array , target);
		System.out.println("Done");
	}

	
	//time complexity of Brute force will be O(n3)
	//time complexity of below method is O(n2)
	private static void closest3SUM(int[] array, int target) 
	{
		//to store result. 3 element and proximity of their sum to the target
		ArrayList<Integer> result = new ArrayList<>();
		
		//sort the array
		Arrays.sort(array);
		
		//then we will use two pointer start and end. 
		//start and stop pointer will change according to proximity to target
		for (int i = 0; i < array.length - 2; i++) 
		{
			int start= i+1;
			int end = array.length - 1;
			int sum = 0;
			while(start  <  end)
			{
				// for the first input we will add any combination to list
				if(result.isEmpty())
				{
					sum = array[i] + array[start] + array[end];
					result.add(array[i]);
					result.add(array[start]);
					result.add(array[end]);
					result.add(sum);
				}
				else
				{
					sum = array[i] + array[start] + array[end];
					
					//if proximity of current inputs is smaller then previously calculated target then update result
					if(Math.abs(result.get(3) - target) > Math.abs(sum - target))
					{
						result.clear();
						result.add(array[i]);
						result.add(array[start]);
						result.add(array[end]);
						result.add(sum);
					}
					else
					{
						//if sum of the input is bigger then target then we will reduce end pointer
						//that way end pointer will point to smaller number because array is sorted
						
						//if sum of the input is smaller then target then we will increment start pointer
						//that way start pointer will point to bigger number because array is sorted
						if(sum > target)
						{
							end--;
						}
						else
						{
							start++;
						}
					}
				}
			}
		}
		
		//this will print all three input and result
		for (int i = 0; i < result.size(); i++)
		{
			System.out.print(result.get(i) + "  ");
		}
	}
	
}
