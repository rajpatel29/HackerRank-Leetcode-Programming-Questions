//	find closest node in the tree = tree traversal problem

package Binary_Search_Tree_Implementation;

public class BinaryTree 
{
	private int data;
	private BinaryTree left;
	private BinaryTree right;
	
	public BinaryTree(int data) 
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public void addNode(int num)
	{
		if(this.data < num)
		{
			if(this.right == null )
			{
				this.right = new BinaryTree(num);
			}
			else
			{
				this.right.addNode(num);
			}
		}
		else
		{
			if(this.left == null )
			{
				this.left = new BinaryTree(num);
			}
			else
			{
				this.left.addNode(num);
			}
		}
	}
	
	public void preOrderTraversal()
	{
		System.out.print(this.data + "  ");
		if(this.left != null)
		{
			this.left.preOrderTraversal();
		}
		if(this.right != null)
		{
			this.right.preOrderTraversal();
		}
	}
	
	public void postOrderTraversal()
	{
		if(this.left != null)
		{
			this.left.postOrderTraversal();
		}
		if(this.right != null)
		{
			this.right.postOrderTraversal();
		}
		System.out.print(this.data + "  ");
	}
	
	public void inOrderTraversal()
	{
		if(this.left != null)
		{
			 this.left.inOrderTraversal();
		}
		
		System.out.print ( this.data + "  ");
		
		if(this.right != null)
		{
			this.right.inOrderTraversal();
		}
	}
}



