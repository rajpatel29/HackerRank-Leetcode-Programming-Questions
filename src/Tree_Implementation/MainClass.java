package Tree_Implementation;

import java.util.ArrayList;
import java.util.List;

public class MainClass
{
	public static void main(String args[])
	{
		Node root = new Node(null, 1);
		
		Node child1 = new Node(root, 11);
		Node child2 = new Node(root, 12);
		Node child3 = new Node(root, 13);
		root.addChild(child1);
		root.addChild(child2);
		root.addChild(child3);
		
		Node child31 = new Node(child3, 131);
		Node child32 = new Node(child3, 132);
		child3.addChild(child31);
		child3.addChild(child32);
			
		String result = "";
		System.out.println("DFS Traversal");
		dfsTraversal(root);
		
		System.out.println();
		System.out.println();
		
		System.out.println("BFS Traversal");
		bfsTraversal(root);
	}

	//find height of the tree – DFS
	//DFS
	private static void dfsTraversal(Node root ) 
	{
		System.out.println(root.getData());
		List<Node> list = new ArrayList<Node>();
		list.addAll(root.getChilds());
		while(list.size() != 0)
		{
			Node first = list.remove(0);
			System.out.println(first.getData());
			for(int i = first.getChilds().size()-1; i>=0 ;i-- )
			{
				list.add(0, first.getChilds().get(i));
			}
		}
	}
	
	//BFS
	private static void bfsTraversal(Node root ) 
	{
		System.out.println(root.getData());
		List<Node> list = new ArrayList<>();
		list.addAll(root.getChilds());
		
		while(list.size() !=0)
		{
			Node current = list.remove(0);
			System.out.println(current.getData());
			list.addAll(current.getChilds());
		}
	}
}


