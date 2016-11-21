package Merge_k_Sorted_Lists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution
{
	 public static ListNode mergeKLists(ListNode[] lists) 
	 {
	     if(lists.length == 0 || lists == null)
	     {
	    	 return null;
	     }
	     
	     ListNode  result = new ListNode(0);
	     ListNode pointer = result;
	     
	     //to get smallest element from the queue
	     PriorityQueue<ListNode> queue = new PriorityQueue<>
	     (
	    		new Comparator<ListNode>() 
	    		{
	    			public int compare(ListNode l1 , ListNode l2)
	    			{
	    				return l1.val - l2.val;
	    			}
				}
	    );
	     
	     //add first element of all the list in the queue (since all the list are sorted)
	     for(ListNode element : lists)
	     {
	    	 if(element != null)
	    		 queue.offer(element);
	     }
	     
	     
	     while(!queue.isEmpty())
	     {
	    	 ListNode addElement = queue.poll();
	    	 pointer.next = addElement;
	    	 pointer = pointer.next;
	    	 
	    	 if(addElement.next != null)
	    		 queue.offer(addElement.next);
	    	 
	     }

	     return result.next;
	 }
}
