package linked_lists;

class LinkedListNode
{
	public int data;
	public LinkedListNode next;

	public LinkedListNode(int i)
	{
		data = i;
	}
}

public class KthToLast
{
	public static void main(String[] args)
	{
		LinkedListNode a = new LinkedListNode(1);
		LinkedListNode b = new LinkedListNode(2);
		LinkedListNode c = new LinkedListNode(3);
		LinkedListNode d = new LinkedListNode(4);
		LinkedListNode e = new LinkedListNode(5);
		LinkedListNode f = new LinkedListNode(6);

		a.next = b;
		b.next = c;
		c.next=d;
		d.next=e;
		e.next=f;

		for(LinkedListNode cur = a; cur!=null; cur=cur.next)
			System.out.println(cur.data);
 
		a = deleteKth(a,Integer.parseInt(args[0]));

		System.out.println("After deleting");

		for(LinkedListNode cur = a; cur!=null; cur=cur.next)
			System.out.println(cur.data);
	}

	static LinkedListNode deleteKth(LinkedListNode head, int k)
	{
		int len = 0;
		LinkedListNode n = head;
		while(n!=null)
		{
			len++;
			n = n.next;
		}

		if(k>len)
		{
			System.out.println("K is too high");
			return head;
		}		

		if(len==k)
		{
			return head.next;
		}
		
		int incr = len - k -1; 

		n = head;
		for(int i=0; i<incr; i++)
		{
			n = n.next;
		}
			
		n.next = n.next.next;
		return head;
	}
}