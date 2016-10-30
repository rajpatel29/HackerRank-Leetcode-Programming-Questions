package Heap_Implementation;

public class MyHeap 
{
	int elements[];
	int numberOfElements = 0;
	
	public MyHeap() 
	{
		elements = new int[20];
	}
	
	//insert new value in the heap and re arrange the heap
	public void insert(int value)
	{
		//check whether heap is empty or not
		if(numberOfElements == 0)
		{
			elements[numberOfElements] = value;
			numberOfElements++;
		}
		else
		{
			//adds element at end of the array
			elements[numberOfElements] = value;
			numberOfElements++;
			
			int currentIndex = numberOfElements - 1;
			int parentIndex = (currentIndex - 1) / 2;
			
			//rearrange heap until child is smaller then it's parent
			while(elements[currentIndex] > elements[parentIndex] && currentIndex != 0)
			{
				int temp = elements[currentIndex];
				elements[currentIndex] = elements[parentIndex];
				elements[parentIndex] = temp;
				
				currentIndex = parentIndex;
				parentIndex = (currentIndex - 1) / 2;
			}
		}
	}
	
	//deletes root of the child and rearrange the heap
	public int delete()
	{
		int largestElement = 0;
		
		if(numberOfElements == 0)
		{
			throw new RuntimeException("Heap is Empty");
		}
		
		largestElement = elements[0];
		numberOfElements--;
		elements[0] = elements[numberOfElements];
		elements[numberOfElements] = 0;
		int currentIndex = 0;
		int childIndex1 = ( currentIndex * 2 ) + 1;
		int childIndex2 = ( currentIndex * 2 ) + 2;
		
		//check if any of the child is bigger than the parent
		while(elements[currentIndex] < elements[childIndex1] || elements[currentIndex] < elements[childIndex2])
		{
			//if any of the parent is bigger than the parent then find child that is bigger than other childs
			if(elements[childIndex1] > elements[childIndex2])
			{
				//change child element and parent element
				int temp = elements[childIndex1];
				elements[childIndex1] = elements[currentIndex];
				elements[currentIndex] = temp;
				
				currentIndex = childIndex1;
				childIndex1 = ( currentIndex * 2 ) + 1;
				childIndex2 = ( currentIndex * 2 ) + 2;
			}
			else
			{
				//change child element and parent element
				int temp = elements[childIndex2];
				elements[childIndex2] = elements[currentIndex];
				elements[currentIndex] = temp;
				
				currentIndex = childIndex2;
				childIndex1 = ( currentIndex * 2 ) + 1;
				childIndex2 = ( currentIndex * 2 ) + 2;
			}
		}
		
		return largestElement;
	}
	
	//checks if heap is empty or not
	public boolean isEmpty()
	{
		if(numberOfElements == 0)
		{
			return true;
		}
		return false;
	}
}
