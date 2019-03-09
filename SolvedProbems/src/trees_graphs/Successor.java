package trees_graphs;

/*
class Node
{
	int data;
	public Node left;
	public Node right;
	public Node parent;

	public Node(int data)	
	{
		this.data=data;
	}
}	*/

public class Successor
{
	public static void main(String[] args)
	{
		Node root = new Node(8);
		Node a = new Node(5);
		Node b = new Node(4);
		Node c = new Node(11);
		Node d = new Node(10);
		Node e = new Node(9);

		root.left = a;
		a.parent=root;
		root.right = d;
		d.parent=root;
		a.left = b;
		b.parent=a;
		a.right = c;
		c.parent=a;
		d.left = e;
		e.parent=d;

		Node n = getInorderSuccessor(e);
		if(n==null)
			System.out.println("No successor");
		else
			System.out.println(n.data);
	}

	public static Node getInorderSuccessor(Node n)
	{	
		if(n==null)
			return null;

		if(n.right==null)
		{
			if(n.parent==null)
				return null;
			else if(n==n.parent.right)
			{
				Node cur = n.parent;
				while(cur.parent!=null && cur == cur.parent.right)
					cur = cur.parent;
				return cur.parent;
			}
			else
				return n.parent;
		}
		else
		{
			Node cur = n.right;
			while(cur.left!=null)
				cur=cur.left;
			return cur;
		}
	}
}