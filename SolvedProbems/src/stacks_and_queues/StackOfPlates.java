package stacks_and_queues;

class StackSet
{
	private int[] top;
	private int[][] arr;
	private int max;
	private int count;

	public StackSet(int max, int count)
	{
		arr = new int[count][max];
		top = new int[2];
		top[1]=-1;
		this.max=max;
		this.count=count;
	}

	public void push(int d)
	{
		if(incrementTop())
		{
			arr[top[0]][top[1]] = d;
			System.out.println("Pushed : " +d);
		}
		else
			System.out.println("Stack is full");
	}

	public int pop()
	{
		if(top[0]==0 && top[1]==-1)
		{
			System.out.println("Stack is empty");
			return -1;
		}
		else
		{
			int val = arr[top[0]][top[1]];
			decrementTop();	
			System.out.println("Popped : " +val);
			return val;
		}
	}

	private boolean incrementTop()
	{
		if(top[0]==count-1)
		{
			if(top[1]==max-1)
				return false;
			else
			{
				top[1]++;
			}
		}
		else
		{
			if(top[1]==max-1)
			{
				top[1]=0;
				top[0]++;
			}
			else
				top[1]++;
		}
		return true;
	}

	private boolean decrementTop()
	{
		if(top[0]==0)
		{
			if(top[1]==-1)
				return false;
			else
			{
				top[1]--;
			}
		}
		else
		{
			if(top[1]==0)
			{
				top[1]=max-1;
				top[0]--;
			}
			else
				top[1]--;
		}
		return true;
	}

}

public class StackOfPlates
{
	public static void main(String[] args)
	{
		StackSet stck = new StackSet(5,3);
		for(int i=1; i<20; i++)
			stck.push(i);

		for(int i=1; i<20; i++)
			stck.pop();
	}
}