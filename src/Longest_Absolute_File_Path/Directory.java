package Longest_Absolute_File_Path;

public class Directory 
{
	private int level;
	private String path;
	private int length;
	
	public Directory(int level , String path , int length) 
	{
		this.level = level;
		this.path = path;
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
