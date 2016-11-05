
package Longest_Absolute_File_Path;

public class MainClass 
{
	public static void main(String[] args) 
	{
		AbsolutePathFinder absolutePathFinder = new AbsolutePathFinder();
		int longestPathLength = absolutePathFinder.findLongestAbsolutePath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
		System.out.println(longestPathLength);
	}
}
