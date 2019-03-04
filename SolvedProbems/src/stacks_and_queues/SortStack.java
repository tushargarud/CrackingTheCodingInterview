package stacks_and_queues;

import java.util.Stack;
import java.util.Random;

//Code can be refactored. I kept it as it is because this way it is easier to understand

public class SortStack
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		Stack<Integer> stck = new Stack<Integer>();
		for(int i=0; i<10; i++)
			stck.push(rand.nextInt(100));

		sortStack(stck);

		while(!stck.empty())
			System.out.println(stck.pop());
	}

	public static void sortStack(Stack<Integer> main)
	{
		int i;
		Stack<Integer> temp = new Stack<Integer>();
		while(!main.empty())
		{
			i = main.pop();
			if(main.empty())
			{
				temp.push(i);
				break;
			}

			if(i<main.peek())
				temp.push(i);
			else
			{
				temp.push(i);
				i = main.pop();

				while(!temp.empty())
					main.push(temp.pop());
			
				main.push(i);
			}
		}

		while(!temp.empty())
			main.push(temp.pop());
	}
}