package stacks_and_queues;

class ThreeStacks
{
	static final int MAXLENGTH = 50;
	Object[] arr;
	int[] top;
	
	public ThreeStacks()
	{
		top = new int[3];
		top[0]=-3;
		top[1]=-2;
		top[2]=-1;
		arr = new Object[MAXLENGTH];
	}

	public boolean push(int stackNum, Object val)
	{
		if(top[stackNum]+3>=MAXLENGTH)
			return false;
		else
		{
			top[stackNum]+=3;
			arr[top[stackNum]]=val;
			return true;
		}
	}
	
	public Object pop(int stackNum)
	{
		if(top[stackNum]<0)
			return null;
		else
		{
			Object o = arr[top[stackNum]];
			top[stackNum] -= 3;
			return o;
		}
	}

	public Object peek(int stackNum)
	{
		if(top[stackNum]<0)
			return null;
		else
			return arr[top[stackNum]];
	}

	public boolean isEmpty(int StackNum)
	{
		return top[StackNum]<0;
	}
}

public class ThreeInOne
{
	public static void main(String[] args)
	{
		ThreeStacks three = new ThreeStacks();
		three.push(0,2);
		three.push(1,10);
		three.push(0,4);
		three.push(0,6);
		three.push(2,100);	
		three.push(2,200);		
		three.push(1,20);	
		three.push(1,30);	
		three.push(2,300);	
		System.out.println(three.pop(2));
		System.out.println(three.pop(2));
		System.out.println(three.pop(1));
		System.out.println(three.pop(1));
		System.out.println(three.pop(0));
		System.out.println(three.pop(0));
		System.out.println(three.pop(0));
	}
}