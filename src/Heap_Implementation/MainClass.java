package Heap_Implementation;

public class MainClass 
{
	public static void main(String args[])
	{
		MyHeap heap = new MyHeap();
		
		heap.insert(9);
		heap.insert(10);
		heap.insert(15);
		heap.insert(20);
		heap.insert(45);
		heap.insert(2);
		heap.insert(100);
		
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		System.out.println(heap.delete());
	}
}
