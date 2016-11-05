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
