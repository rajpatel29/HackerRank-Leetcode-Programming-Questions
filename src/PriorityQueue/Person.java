package PriorityQueue;

public class Person implements Comparable<Person>
{
	private int priority;
	private String personName;
	
	public Person(int priority , String personName)
	{
		this.priority = priority;
		this.personName = personName;
	}

	public int getPriority()
	{
		return this.priority;
	}
	
	@Override
	public int compareTo(Person o) 
	{
		if(this.priority == o.getPriority())
		{
			return 0;
		}
		else if(this.priority > o.getPriority())
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
	
	@Override
	public String toString() 
	{
		return "Priority : " + this.priority + "   Person Name : " + this.personName;
	}
	
}

