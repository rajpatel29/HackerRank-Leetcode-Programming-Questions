package Tree_Implementation;

import java.util.ArrayList;

public class Node 
{
	private int data;
	private ArrayList<Node> childs;
	private  Node Parent;
	
	public Node(Node parent, int data)
	{
		this.data = data;
		this.Parent = parent;
		childs = new ArrayList<>();
	}

	public int getData() {
		return data;
	}

	public ArrayList<Node> getChilds() {
		return childs;
	}
	
	public Node getParent() {
		return Parent;
	}

	public void setParent(Node parent) {
		Parent = parent;
	}

	public void addChild(Node child)
	{
		this.childs.add(child);
	}
	
	public boolean isRoot()
	{
		if(this.Parent == null)
		{
			return true;
		}
		return false;
	}
	
	public boolean isLeaf()
	{
		if(this.childs.size() == 0)
		{
			return true;
		}
		return false;
	}	
}

