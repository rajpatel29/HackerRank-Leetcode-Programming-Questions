//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//
//For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
//the contiguous subarray [4,-1,2,1] has the largest sum = 6.


package Maximum_Subarray;

public class MainClass 
{
	public static void main(String[] args) 
	{
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		
		System.out.println(maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) 
	{
		int sum = nums[0];
		int currentSum = nums[0];
		for (int i = 1; i < nums.length; i++) 
		{
			currentSum = Math.max(currentSum + nums[i], nums[i]);
			if (sum < currentSum)
				sum = currentSum;
		}

		return sum;
	}
}
