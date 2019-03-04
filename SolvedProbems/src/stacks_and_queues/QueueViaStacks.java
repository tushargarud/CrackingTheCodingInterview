package stacks_and_queues;

import java.util.Stack;

class MyQueue
{
	Stack<Integer> mainStack;
	Stack<Integer> tempStack;

	public MyQueue()
	{
		mainStack = new Stack<Integer>();
		tempStack = new Stack<Integer>();
	}

	public void push(Integer i)
	{
		if(mainStack.empty())
		{
			while(!tempStack.empty())
				mainStack.push(tempStack.pop());
		}
		mainStack.push(i);
	}
	
	public Integer pop()
	{
		if(!mainStack.empty())
		{
			while(!mainStack.empty())
				tempStack.push(mainStack.pop());
		}
		return tempStack.pop();
	}
}

public class QueueViaStacks
{
	public static void main(String[] args)
	{
		MyQueue que = new MyQueue();
		for(int i=1; i<6; i++)
		{
			System.out.println("Pushing : " + i);
			que.push(i);
		}
		for(int i=1; i<10; i++)
			System.out.println("Popped : " + que.pop());
	}
}