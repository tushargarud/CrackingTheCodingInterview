package linked_lists;


public class SumList
{
	public static void main(String[] args)
	{
		Node a1 = new Node(6);
		Node a2 = new Node(1);
		Node a3 = new Node(7);
		a1.next=a2;
		a2.next=a3;

		Node b1 = new Node(2);
		Node b2 = new Node(9);
		Node b3 = new Node(5);
		b1.next=b2;
		b2.next=b3;

		Node result = addLists(a1,b1);
		while(result!=null)
		{
			System.out.println(result.data);
			result = result.next;
		}
	}

	static Node addLists(Node a, Node b)
	{
		Node sum = new Node(0);
		int carry = addListsSum(a, b, sum);
		if(carry>0)
		{
			Node n = new Node(carry);
			n.next = sum;
			sum=n;			
		}
		return sum;
	}
		
	static int addListsSum(Node a, Node b, Node sum)
	{
		if(a.next==null)
		{
			sum.data=(a.data+b.data)%10;
			return (a.data+b.data)/10;
		}
		int carry = addListsSum(a.next, b.next, sum);
		Node n = new Node((a.data+b.data+carry)%10);
		n.next = sum;
		sum = n;
		carry = (a.data+b.data+carry)/10;
		return carry;			 
	}
}