package Reverse_Nodes_in_k_Group;

//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

//
//If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
//You may not alter the values in the nodes, only nodes itself may be changed.
//
//Only constant memory is allowed.
//
//For example,
//Given this linked list: 1->2->3->4->5
//
//For k = 2, you should return: 2->1->4->3->5
//
//For k = 3, you should return: 3->2->1->4->5

public class MainClass 
{
	public static void main(String[] args) 
	{
		//Input
		int k = 4;
		ListNode start = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		start.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		
		
		ListNode firstNode = new ListNode(0);
		firstNode.next = start;

		ListNode print = firstNode.next;

		ListNode pointer = start;
		int counter = 1;
		while (pointer != null) 
		{
			if (counter == k) 
			{
				ListNode tr = pointer.next;
				ListNode temp = reverse(start, pointer);
				firstNode.next.next = tr;
				print = temp;

				break;
			}

			counter++;
			pointer = pointer.next;
		}

		//prints output
		while (print != null) 
		{
			System.out.print(print.val);
			print = print.next;

			if (print != null) 
			{
				System.out.print(" -> ");
			}
		}

	}

	//reverse LinkedList
	public static ListNode reverse(ListNode start, ListNode end) 
	{
		ListNode current = start.next;
		ListNode next = current.next;

		while (!current.equals(end)) 
		{
			current.next = start;

			start = current;
			current = next;
			if (next != null)
				next = next.next;
		}

		current.next = start;

		start = current;
		current = next;
		if (next != null)
			next = next.next;

		return start;
	}
}
