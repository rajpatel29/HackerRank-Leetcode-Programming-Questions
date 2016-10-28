//Binary tree traversal

package Binary_Tree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree 
{
	 Node root;
	
	public BinaryTree() 
	{
		root = null;
	}
	
	public BinaryTree(int val) 
	{
		this.root = new Node(val);
	}
	
	public Node getRoot()
	{
		return root;
	}
	
	public void inOrderTraversal(Node tree)
	{
		if(tree == null )
		return;
		
		inOrderTraversal(tree.left);
		System.out.println(tree.data);
		inOrderTraversal(tree.right);
	}
	
	public void preOrderTraversal(Node tree)
	{
		if(tree == null )
			return;
			
		System.out.println(tree.data);
		preOrderTraversal(tree.left);
		preOrderTraversal(tree.right);
	}
	
	public void postOrderTraversal(Node tree)
	{
		if(tree == null )
			return;
			
		postOrderTraversal(tree.left);
		postOrderTraversal(tree.right);
		System.out.println(tree.data);
	}
	
	public void getBFS(Node tree)
	{
		ArrayList<Node> list = new ArrayList<>();
		list.add(tree);
		
		while(!list.isEmpty())
		{
			int size = list.size();
			for (int i = 0; i < size; i++)
			{
				Node temp = list.remove(0);
				
				if(temp == null)
					return;
				
				System.out.println(temp.data);
				
				if(temp.left != null)
					list.add(temp.left);
				
				if(temp.right != null)
					list.add(temp.right);
			}
		}
	}
	
	public void getDFS(Node tree)
	{
		Stack<Node> stack = new Stack<>();
		stack.push(tree);
		while(!stack.isEmpty())
		{
			Node temp = stack.pop();
			System.out.println(temp.data);

			if(temp.right != null)
				stack.push(temp.right);
			
			if(temp.left != null)
				stack.push(temp.left);
		}
	}
}

