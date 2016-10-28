package PriorityQueue;

import java.util.PriorityQueue;

public class MainClass 
{
	public static void main(String[] args) 
	{
		Person p1 = new  Person(3, "Person 1");
		Person p2 = new  Person(1, "Person 2");
		Person p3 = new  Person(2, "Person 3");
		
		PriorityQueue<Person> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(p1);
		priorityQueue.add(p2);
		priorityQueue.add(p3);
		
		//do not use for loop to get the element
		while(!priorityQueue.isEmpty())
		{
			System.out.println(priorityQueue.remove());
		}
	}
}

