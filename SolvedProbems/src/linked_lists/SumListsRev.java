package linked_lists;


public class SumListsRev
{
	public static void main(String[] args)
	{
		Node a1 = new Node(7);
		Node a2 = new Node(1);
		Node a3 = new Node(6);
		a1.next=a2;
		a2.next=a3;

		Node b1 = new Node(5);
		Node b2 = new Node(9);
		Node b3 = new Node(2);
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
		Node result=null;
		Node resultTail=null;
		int curSum=0, carry=0;
		int val;

		while(a!=null || b!=null || carry!=0)
		{
			curSum=0;
			if(a!=null)
			{
				curSum += a.data;
				a=a.next;
			}

			if(b!=null)
			{
				curSum += b.data;
				b=b.next;
			}

			curSum += carry;

			carry = curSum / 10;
	
			if(result==null)
			{
				result = new Node(curSum % 10);
				resultTail = result;
			}
			else
			{
				Node temp = new Node(curSum % 10);
				resultTail.next = temp;
				resultTail = temp;
			}
		}
		return result;
	}
}
