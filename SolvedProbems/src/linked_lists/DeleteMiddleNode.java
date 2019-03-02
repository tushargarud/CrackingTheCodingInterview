package linked_lists;

public class DeleteMiddleNode
{
	public static void main(String[] args)
	{
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);

		a.next=b;
		b.next=c;
		c.next=d;
		
		deleteMiddle(b);

		while(a!=null)
		{
			System.out.println(a.data);
			a=a.next;
		}
	}

	static void deleteMiddle(Node node)
	{
		node.data = node.next.data;
		node.next = node.next.next;
	}
}