class Node
{
	private int data;
	private Node next;

	public Node(int val)
	{
		data=val;
	}

	public void setNext(Node n)
	{
		this.next = n;
	}
	
	public String toString()
	{
		return String.valueOf(data);
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public int getData()
	{
		return data;
	}
}

public class RemoveDups
{
	public static void main(String[] args)
	{
		Node head = new Node(1);
		Node b = new Node(2);
		Node c = new Node(1);
		Node d = new Node(1);
		Node e = new Node(1);

		head.setNext(b);
		b.setNext(c);
		c.setNext(d);
		d.setNext(e);
	
		Node n=head;
		while(n!=null)
		{
			System.out.println(n);
			n = n.getNext();
		}

		removeDups(head);
		System.out.println("After removing dups");

		n=head;
		while(n!=null)
		{
			System.out.println(n);
			n = n.getNext();
		}
	}

	static void removeDups(Node head)
	{
		Node h = head;
		Node n;

		while(h.getNext()!=null)
		{
			n = h;
			while(n.getNext()!=null)
			{
				if(h.getData()==n.getNext().getData())
				{
					n.setNext(n.getNext().getNext());
				}
				else
					n = n.getNext();
			}
			h = h.getNext();
		}
	}

}