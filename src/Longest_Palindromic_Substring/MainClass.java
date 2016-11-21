package Longest_Palindromic_Substring;

public class MainClass 
{
	public static void main(String args[])
	{
		System.out.println(longestPalindrome("xbadaby"));
	}
	
    public static String longestPalindrome(String input)
	 {
		if(input == null || input.length() <= 1)
			return input;
			
		String longestPalindrom = ""+ input.charAt(0) ;
		
		int length = input.length();
		boolean palindromArray[][] = new boolean[length][length];
		int maxLength = 1;
		
		for (int i = 0; i < length; i++) 
		{
			for (int j = 0; j < length - i; j++) 
			{
				int  k = j + i;
				
				if( input.charAt(j) ==  input.charAt(k)  &&  ( k-j <= 2|| palindromArray[j+1][k-1]))
				{
					palindromArray[j][k] = true;
				
				    if(k-j+1>maxLength)
	                {
				    	maxLength = k-j+1; 
	                   longestPalindrom = input.substring(j, k+1);
	                }
				    
				}
				
			}
		}
		
		return longestPalindrom;
	}
	
//	public String longestPalindrome(String s) 
//	{
//	    if(s==null || s.length()<=1)
//	        return s;
//	 
//	    int len = s.length();
//	    int maxLen = 1;
//	    boolean [][] dp = new boolean[len][len];
//	 
//	    String longest = null;
//	    for(int l=0; l<s.length(); l++)
//	    {
//	        for(int i=0; i<len-l; i++)
//	        {
//	            int j = i+l;
//	            if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1]))
//	              {
//	                dp[i][j]=true;
//	 
//	                if(j-i+1>maxLen)
//	                {
//	                   maxLen = j-i+1; 
//	                   longest = s.substring(i, j+1);
//	                }
//	            }
//	        }
//	    }
//	 
//	    return longest;
//	}
}
