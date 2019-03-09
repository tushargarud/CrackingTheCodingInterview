package trees_graphs;

import java.util.LinkedList;
import java.util.Deque;

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

class MinimalTree
{
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		Node root = new Node(Integer.MIN_VALUE);
		partition(0, arr.length-1, arr, root);
		printBFS(root);
	}

	public static int findMidIndex(int start, int end)
	{
		if(start==end || start==end-1)
			return start;
		else
			return start + (end - start) / 2;
	}

	public static void partition(int start, int end, int[] arr, Node root)
	{
		int mid = findMidIndex(start, end);
		insertIntoTree(root, arr[mid]);
		if(start<=mid-1)
			partition(start, mid-1, arr, root);
		if(end>=mid+1)
			partition(mid+1, end, arr, root);
	}

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

	public static  void printBFS(Node root)
	{
		if(root==null || root.data==Integer.MIN_VALUE)
			return;

		Deque<Node> queue = new LinkedList<Node>();
		System.out.println(root.data);
		queue.addLast(root);
		Node newLine = new Node(Integer.MAX_VALUE);
		queue.addLast(newLine);

		while(!queue.isEmpty())
		{
			Node temp = queue.removeFirst();
			if(temp.left!=null)
			{
				System.out.print(" left:" + temp.left.data);
				queue.addLast(temp.left);
			}
			if(temp.right!=null)
			{
				System.out.print(" right:" + temp.right.data);
				queue.addLast(temp.right);
			}
			if(temp.data==Integer.MAX_VALUE)
			{
				System.out.println();
				if(!queue.isEmpty())
					queue.addLast(new Node(Integer.MAX_VALUE));
				continue;
			}
		}
	}	
}