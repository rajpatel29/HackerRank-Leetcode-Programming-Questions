//Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//
//For example,
//Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
//
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//Therefore, return the max sliding window as [3,3,5,5,6,7].
//
//
//

package Sliding_Window_Maximum;

import java.util.LinkedList;

public class Solution 
{
    public int[] maxSlidingWindow(int[] nums, int k)
    {
            if(nums==null || nums.length == 0)
                return nums;

            int answer[] = new int[nums.length - k + 1];
            
            LinkedList<Integer> list = new LinkedList<Integer>();
            for(int  i = 0 ; i < nums.length ; i++)
            {
                if(!list.isEmpty() && ((i - list.peekFirst()) == k) )
                {
                    list.pollFirst();
                }
                
                while(!list.isEmpty() && nums[list.peekLast()] < nums[i])
                {
                    list.pollLast();
                }
                
                list.offer(i);
                
                // System.out.println(list);
                
                if(i+1 >= k)
                {
                     answer[i+1 - k] = nums[list.peekFirst()];
                }
            }
            
            return answer;
    }
}
