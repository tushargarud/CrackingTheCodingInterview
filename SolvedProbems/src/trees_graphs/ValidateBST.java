package trees_graphs;

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

public class ValidateBST
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
		root.right = d;
		a.left = b;
		a.right = c;
		d.left = e;

		System.out.println(isValidBST(root));
	}

	public static boolean isValidBST(Node root)
	{
		if(root==null)
			return true;
		
		return checkBST(root, null, null);
	}

	public static boolean checkBST(Node n, Integer min, Integer max)
	{
		if(n==null)
			return true;

		if((min!=null && n.data <= min) || (max!=null && n.data > max))
			return false;

		if(!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max))
			return false;

		return true;
	}
}