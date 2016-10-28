package Binary_Search_Tree_Implementation;

public class MainClass 
{
	public static void main(String[] args) 
	{
		BinaryTree root = new BinaryTree(40);
		int[] nums = {25,78,10,32};
		
		for (int num : nums)
		{
			root.addNode(num);
		}
		
		System.out.println("Pre Order");
		root.preOrderTraversal();
		System.out.println();

		System.out.println("Post Order");
		root.postOrderTraversal();
		System.out.println();
		
		System.out.println("In Order");
		root.inOrderTraversal();
		System.out.println();
	}
}



