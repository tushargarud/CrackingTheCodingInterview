package arrays_and_strings;

public class PalindromePermutation
{
	public static void main(String[] args)
	{
		System.out.println(checkPalindromePermutation(args[0]));
	}

	public static String checkPalindromePermutation(String str)
	{
		int indx;
		str = str.toLowerCase();
		boolean[] hashTable = new boolean[128];
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i)!=' ')
			{
				indx = str.charAt(i);
				if(indx > 127 || indx < 0)
					return "Unsupported character";
				hashTable[indx] = hashTable[indx]==true ? false : true;
			}
		}
		
		boolean oddFound=false;
		for(int i=0; i<128; i++)
		{
			if(hashTable[i])
			{
				if(oddFound)
					return "Not a palindrome permutation";
				else
					oddFound=true;
			}
		}
		return "Its a palindrome permutation";
	}
}