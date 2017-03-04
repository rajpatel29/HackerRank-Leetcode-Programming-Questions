//You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
//Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
//
//Find out how many ways to assign symbols to make sum of integers equal to target S.
//
//Example 1:
//Input: nums is [1, 1, 1, 1, 1], S is 3. 
//Output: 5
//Explanation: 
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//There are 5 ways to assign symbols to make the sum of nums be target 3.

package Target_Sum;

public class Solution 
{
    public int findTargetSumWays(int[] nums, int S) 
    {
       int array[] = new int[2];
       array[0] = -nums[0];
       array[1] = nums[0];
       
       for(int  i = 1 ; i < nums.length ; i++)
       {
           int length = array.length * 2;
            int temp[] = new int[length];
            
            for(int  j = 0 ; j < length ; j++)
            {
                int x = j / 2;
                 temp[j] = array[x] - nums[i];
                 j++;
                 temp[j] = array[x] + nums[i];
            }
            array = temp;
       }
       int answer = 0;
       for(int  i = 0 ; i < array.length ; i++)
       {
           if(array[i] == S)
            answer++;
       }
       
       return answer;
    }
}