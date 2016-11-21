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
