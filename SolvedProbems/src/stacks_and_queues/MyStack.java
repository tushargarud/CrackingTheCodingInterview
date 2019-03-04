package stacks_and_queues;

public class MyStack<T>
{
	private static class StackNode<T>
	{
		private T data;
		private StackNode<T> next;

		public StackNode(T data)
		{
			this.data=data;
		}
	}
	
	private StackNode<T> top=null;

	public void push(T a)
	{	
		StackNode<T> n = new StackNode<T>(a);
		n.next=top;
		top=n;
	}

	public T peek()
	{
		if(top==null)
			return null;
		else
			return top.data;
	}

	public boolean isEmpty()
	{
		return top==null;
	}

	public T pop()
	{
		if(top==null)
			return null;
		else
		{
			T d = top.data;
			top = top.next;
			return d;
		}
	}
}