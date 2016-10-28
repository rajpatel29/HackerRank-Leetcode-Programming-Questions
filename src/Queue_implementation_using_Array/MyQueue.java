package Queue_implementation_using_Array;

public class MyQueue
{
	public int front;
	public int rear;
	private int[] array;
	private int numberOfElements = 0;
	
	public MyQueue(int arraySize) 
	{
		this.front = -1;
		this.rear = -1;
		array = new int[arraySize];
	}
	
	public void add(int element)
	{
		if(numberOfElements == array.length)
		{
			throw new RuntimeException("Full");
		}
		
		int temp = rear + 1;
		if(temp == array.length)
		{
			rear = 0;
			array[rear] = element;
		}
		else
		{
			if(front == -1)
			{
				front = 0;
			}
			rear++;
			array[rear] = element;
		}
		numberOfElements++;
	}
	
	public int get()
	{
		if(isEmpty())
		{
			System.out.println(front + "   :  " + rear  );
			throw new RuntimeException("Empty");
		}
		int result = array[front];
		int temp = front + 1;
		if(temp == array.length)
		{
			front = 0;
		}
		else
		{
			front++;
		}
		numberOfElements--;
		return result;
	}
	
	public boolean isEmpty()
	{
		if(numberOfElements == 0)
		{
			return true;
		}
		return false;
	}
}

