package Implement_Queue_using_stack;

import java.util.Stack;

public class MyQueue<T>
{
	Stack<T> stack;
	Stack<T> tempStack;
	
	public MyQueue()
	{
		stack = new Stack<>();
		tempStack = new Stack<>();
	}
	
	public T pop()
	{
		T result = null;
		if(!tempStack.isEmpty())
		{
			result = tempStack.pop();
		}
		else
		{
			if(stack.isEmpty())
			{
				return null;
			}
			while(stack.size() > 1)
			{
				tempStack.push(stack.pop());
			}
			result = stack.pop();
		}
		return result;
	}
	
	public void push(T element)
	{
		stack.push(element);
	}
	
	public boolean isEmpty()
	{
		if(stack.isEmpty() && tempStack.isEmpty())
		{
			return true;
		}
		return false;
	}
	
	public T top() // same as pop minor change
	{
		T result = null;
		if(!tempStack.isEmpty())
		{
			result = tempStack.pop();
			tempStack.push(result);
		}
		else
		{
			if(stack.isEmpty())
			{
				return null;
			}
			while(stack.size() > 0)
			{
				if(stack.size() == 1)
				{
					result = stack.pop();
					tempStack.push(result);
				}
				else
				tempStack.push(stack.pop());
			}
		}
		return result;
	}
}

