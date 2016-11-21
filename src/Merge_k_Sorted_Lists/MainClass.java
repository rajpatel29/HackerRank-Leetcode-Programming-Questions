package Merge_k_Sorted_Lists;

public class MainClass 
{
	public static void main(String[] args) 
	{
		ListNode list1 = new ListNode(1);
		ListNode list11 = new ListNode(4);
		list1.next = list11;
		ListNode list12 = new ListNode(9);
		list11.next = list12;
		ListNode list13 = new ListNode(10);
		list12.next = list13;
		
		ListNode list2 = new ListNode(2);
		ListNode list21 = new ListNode(3);
		list2.next = list21;
		
		ListNode list3 = new ListNode(3);
		ListNode list31 = new ListNode(11);
		list3.next = list31;

		ListNode list4 = new ListNode(40);
		
		ListNode[] lists = {list1 , list2 , list3 , list4};
		
		ListNode result = Solution.mergeKLists(lists);
		
		
		//prints the output
		ListNode pointer = result;
		while(pointer != null)
		{
			System.out.println(pointer.val);
			pointer = pointer.next;
		}
		
	}
}
