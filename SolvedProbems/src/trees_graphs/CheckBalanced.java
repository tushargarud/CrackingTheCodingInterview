package trees_graphs;

import java.util.Random;
import java.util.LinkedList;
import java.util.ArrayList;

/*
class Node
{
	int data;
	public Node left;
	public Node right;

	public Node(int data)	
	{
		this.data=data;
	}
}	*/

public class CheckBalanced
{
	public static void main(String[] args)
	{
		Node root = new Node(Integer.MIN_VALUE);
		Random rand = new Random();

		int j;
		for(int i = 1; i<=10; i++)
		{
			j = rand.nextInt(100);
			System.out.print(j+" ");
			insertIntoTree(root, j);
		}
		System.out.println();

	}
	
	//Temporary code to generate a binary search tree
	public static void insertIntoTree(Node root, int val)
	{
		if(root.data==Integer.MIN_VALUE)
		{
			root.data = val;
			return;
		}

		Node n = new Node(val);
		Node cur=root;
		while(cur!=null)
		{
			if(val<=cur.data)
			{
				if(cur.left==null)
				{
					cur.left=n;
					break;
				}
				else
					cur = cur.left;
			}
			else
			{
				if(cur.right==null)
				{
					cur.right=n;
					break;
				}
				else
					cur = cur.right;
			}
		}
	}
}