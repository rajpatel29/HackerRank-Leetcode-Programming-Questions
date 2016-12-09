//Given a string, find the length of the longest substring without repeating characters.
//
//Examples:
//
//Given "abcabcbb", the answer is "abc", which the length is 3.
//
//Given "bbbbb", the answer is "b", with the length of 1.
//
//Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, 
//"pwke" is a subsequence and not a substring.

package Longest_Substring_Without_Repeating_Characters;

public class MainClass 
{
	public static void main(String[] args) 
	{
		int result = lengthOfLongestSubstring("abcabcbb");
		System.out.println(result);
	}

	public static int lengthOfLongestSubstring(String s) 
	{
		{
			if (s.equals(""))
			{
				return 0;
			}

			int result = 0;
			int start = 0;
			String sub = "";
			for (int i = 0; i < s.length(); i++) 
			{
				sub = s.substring(start, i);
				if (sub.contains("" + s.charAt(i))) 
				{
					while (s.substring(start, i).contains("" + s.charAt(i))) 
					{
						start++;
					}
				} 
				else 
				{
					if (sub.length() >= result) 
					{
						result = sub.length() + 1;
					}
				}
			}

			return result;
		}
	}
}
