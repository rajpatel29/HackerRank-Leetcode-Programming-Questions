package Linked_List_Implementation;

public class LinkedList<T> 
{
	private Node head = null;
	
	private class Node<T>
	{
		private T data;
		private Node next;
		
		public Node(T data, Node next)
		{
			this.data = data;
			this.next = next;
		}
	}
	
	public Node getHead()
	{	
		return head;
	}
	
	public void push(T new_Element)
	{
		if(head == null)
		{
			head = new Node(new_Element, null);
		}
		else
		{
			Node current = head;
			while(current.next != null)
			{
				current = current.next;
			}
			current.next = new Node(new_Element, null);
		}
	}
	
	public void delete(T key)
	{
		Node current = head;
		Node pre = null;
		while(current != null)
		{
			if(current.data.equals(key))
			{
				if(current.equals(head))
				{
					head = head.next;
					return;
				}
				pre.next = current.next;
				return;
			}
			pre = current;
			current = current.next;
		}
	}
	
	public void printAll()
	{
		Node current = head;
		while(current != null)
		{
			System.out.println(current.data);
			current = current.next;
		}
	}
}
