//Suppose we abstract our file system by a string in the following manner:
//
//The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
//
//dir
//    subdir1
//    subdir2
//        file.ext
//The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.
//
//The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
//
//dir
//    subdir1
//        file1.ext
//        subsubdir1
//    subdir2
//        subsubdir2
//            file2.ext
//The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level 
//sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.
//
//We are interested in finding the longest (number of characters) absolute path to a file within our file system. 
//For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and 
//its length is 32 (not including the double quotes).
//
//Given a string representing the file system in the above format, return the length of the longest absolute path to file 
//in the abstracted file system. If there is no file in the system, return 0.

package Longest_Absolute_File_Path;

import java.util.Stack;

public class AbsolutePathFinder 
{
	public int findLongestAbsolutePath(String input)
	{
		 //stores the file which has longest path
		File result = null;
		//to get parent directory for particular file
		Stack<Directory> parentDirectory = new Stack<>(); 
		
		//always remember to put this first when input is String
		if(input.equals("") || input == null)
		{
			return 0;
		}

		//split the input on new line
		String lines[] = input.split("\n");
		for (int i = 0; i < lines.length; i++) 
		{
			//get the line
			String currentLine = lines[i];
			//count number of tabs to find level
			int level = 0;
			//length of line - numbers of tabs = length of the file or directory
			int k = 0;

			//count number of tabs
			for (int j = 0; j < currentLine.length(); j++) 
			{
				if(currentLine.charAt(j) == '\t')
				{
					level++;
					k++;
				}
				else
				{
					break;
				}
			}
			
			//to get parent directory of a file or directory
			while(!parentDirectory.isEmpty() && parentDirectory.peek().getLevel() >= level)
			{
				parentDirectory.pop();
			}

			//to check whether it is directory or file
			//if it is file
			if(currentLine.contains("."))
			{
				if(!parentDirectory.isEmpty())
				{
					String parentDirPath = parentDirectory.peek().getPath();
					int parentDirLength = parentDirectory.peek().getLength();
					String dirName = currentLine.substring(k, currentLine.length());
					File newDir = new File(level  , parentDirPath + "/" + dirName , parentDirLength + dirName.length());
					
					if(result == null)
					{
						result = newDir;
					}
					//if length of absolute path of the file referred by result is smaller then current file's absolute path
					else if(result.getLength() < newDir.getLength())
					{
						result = new File(newDir.getLevel(), newDir.getPath(), newDir.getLength());
					}
				}
				else
				{
					String dirName = currentLine.substring(k, currentLine.length());
					File newDir = new File(level  ,   dirName ,   dirName.length());
					result = newDir;
				}
			}
			//if it is directory
			else
			{
				if(parentDirectory.isEmpty())
				{
					String dirName = currentLine.substring(k, currentLine.length());
					Directory newDir = new Directory(level ,  dirName , dirName.length());
					parentDirectory.push(newDir);
				}
				//if parent directory is not empty then get it's parent directory and new directory in the stack
				else
				{
					String parentDirPath = parentDirectory.peek().getPath();
					int parentDirLength = parentDirectory.peek().getLength();
					String dirName = currentLine.substring(k, currentLine.length());
					Directory newDir = new Directory(level  , parentDirPath + "/" + dirName , 1 + parentDirLength + dirName.length());
					parentDirectory.push(newDir);
				}
			}
			System.out.println();
			
//			System.out.println(currentLine + " -> " + level);
		}
		
		if(result != null)
		{
		    System.out.println(result.getPath());
			return result.getPath().length();
		}
		
		return 0;
    }
}
