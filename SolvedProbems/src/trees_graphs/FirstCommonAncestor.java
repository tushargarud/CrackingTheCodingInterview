package trees_graphs;


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
}

public class FirstCommonAncestor
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

		System.out.println(getFirstCommonAncestor(e,d).data);
	}

	public static Node getFirstCommonAncestor(Node a, Node b)
	{
		int aDist=0, bDist=0;
		
		Node curA = a;
		while(curA!=null)
		{
			curA = curA.parent;
			aDist++;
		}

		Node curB = b;
		while(curB!=null)
		{
			curB = curB.parent;
			bDist++;
		}

		int distDiff = Math.abs(aDist-bDist);	
		curA=a;
		curB=b;
		while(distDiff>0)
		{
			if(aDist>bDist)
				curA = curA.parent;
			else
				curB = curB.parent;
			
			distDiff--;
		}

		while(curA!=null || curB!=null)
		{
			if(curA==curB)
				return curA;
			curA=curA.parent;
			curB=curB.parent;
		}

		return null;
	}
}