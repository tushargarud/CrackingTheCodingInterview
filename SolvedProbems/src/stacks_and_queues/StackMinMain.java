package stacks_and_queues;

class StackMin
{
	private class StackNode
	{
		private int data;
		private StackNode next;
		private int min;

		public StackNode(int data)
		{
			this.data=data;
		}
	}
	
	private StackNode top;

	public void push(int data)
	{
		StackNode n = new StackNode(data);
		n.next = top;
		top=n;

		if(top.next==null)
			top.min=top.data;
		else
			top.min = Math.min(top.data, top.next.min);
	}

	public Integer pop()
	{
		if(top==null)
			return null;
		else
		{
			int x = top.data;
			top = top.next;
			return x;
		}
	}

	public boolean isEmpty()
	{
		return top==null;
	}

	public Integer min()
	{
		if(top!=null)
			return top.min;
		else
			return null;
	}
}

public class StackMinMain
{
	public static void main(String[] args)
	{
		StackMin stck = new StackMin();
		stck.push(6);
		stck.push(2);
		stck.push(5);
		stck.push(3);
		stck.push(2);
		stck.push(4);
		stck.push(1);
		
		while(!stck.isEmpty())
		{
			System.out.println("Min is : " + stck.min());
			System.out.println("Popped : " + stck.pop());
		}
	}
}