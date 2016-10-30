//Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
//Find all unique quadruplets in the array which gives the sum of target.
//
//Note: The solution set must not contain duplicate quadruplets.
//
//For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
//
//A solution set is:
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]

package _4_SUM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MainClass 
{
	public static void main(String[] args) 
	{
		int array[] = {1, 0, -1, 0, -2, 2};
		int target = 0;
	
		List<List<Integer>> result = fourSum(array, target);
		
		//prints out the result
		for (int i = 0; i < result.size(); i++) 
		{
			List<Integer> list = result.get(i);
			
			for (int j = 0; j < list.size(); j++) 
			{
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> fourSum(int[] nums, int target) 
	{
		//key will be sum of two numbers and value will be two numbers that we are adding
		//value will be of type nested ArrayList<> because sum of two different values may be same
		//(ex. sum1 = -1, 1 sum2 =  0, 0 both sum are same but values are different)
		HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new  HashMap<>();
		
		for (int i = 0; i < nums.length -1; i++) 
		{
			for (int j = i+1; j < nums.length; j++)
			{
				int sum = nums[i] + nums[j];
				ArrayList<Integer> pair = new ArrayList<>();
				pair.add(i);
				pair.add(j);
				
				if(!map.containsKey(sum))
				{
					ArrayList<ArrayList<Integer>> value = new ArrayList<>();
					value.add(pair);
					map.put(sum, value);
				}
				else
				{
					map.get(sum).add(pair);
				}
			}
		}
		
		//just to remove duplicates we will use HashSet then we will add it to ArrayList
		HashSet<ArrayList<Integer>> set = new HashSet<>();
		
		//now we will iterate through HashMap and we will check whether target - currentKey is in the list
		//if it is then sum of all different numbers will be equal to target value
		for(Integer key : map.keySet())
		{
			ArrayList<ArrayList<Integer>> outer = map.get(key);
			
			//if so then we will have sum = 0
			if(map.containsKey(target - key) )
			{
				if( target - key == key && outer.size() == 1)
					continue;

				ArrayList<ArrayList<Integer>> inner = map.get(target - key);
				for (ArrayList<Integer> pair1 : outer)
				{
                    for (ArrayList<Integer> pair2 : inner) 
                    {
						if (pair1.contains(pair2.get(0)) || pair1.contains(pair2.get(1)))
                            continue;
							
						ArrayList<Integer> tmpResult = new ArrayList<>();
						tmpResult.add(nums[pair1.get(0)]);
						tmpResult.add(nums[pair1.get(1)]);
						tmpResult.add(nums[pair2.get(0)]);
						tmpResult.add(nums[pair2.get(1)]);
						Collections.sort(tmpResult);
						set.add(tmpResult);
					}
				}
			}
		}
		
		//return type is List
		List<List<Integer>> result = new LinkedList<>();
		result.addAll(set);
		
		return result;
		
	}
	
}