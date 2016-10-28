package Implement_Stack_using_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack<T> 
{
	Queue<T> queue;
	Queue<T> tempQueue;
	
	public MyStack()
	{
		queue =  new LinkedList<>();
		tempQueue =  new LinkedList<>();
	}
	
	//does remove and return Object
	public T poll()
	{
		T result = null ;
		
		while(!queue.isEmpty())
		{
			if(result != null)
			{
				tempQueue.add(result);
			}
			result = queue.poll();
		}
		
//if you do not use temp then it will go to infinite loop because if you write queue = tempQueue then both point to same address

		Queue<T> temp = queue;
	    queue = tempQueue;
	    tempQueue = temp;
		return result;
	}
	
	public void push(T element)
	{
		queue.add(element);
	}
	
	public boolean isEmplty()
	{
		return queue.isEmpty();
	}
	
	public T top()
	{
		T result = poll() ;
		push(result);
		return result;
	}
}


