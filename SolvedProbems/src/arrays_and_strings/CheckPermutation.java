package arrays_and_strings;

public class CheckPermutation
{
	public static void main(String[] args)
	{
		boolean isPerm = isPermutation(args[0], args[1]);
		if(isPerm)
			System.out.println("Its a permutation");
		else
			System.out.println("Its not a permutation");
	}

	static boolean isPermutation(String str1, String str2)
	{
		if(str1.length() != str2.length())
			return false;
		if(str1.equals(str2))
			return true;

		int index;
		int[] charCount = new int[128];
		for(int i=0; i<str1.length(); i++)
		{
			index = str1.charAt(i);
			charCount[index]++;
		}

		for(int i=0; i<str2.length(); i++)
		{
			index = str2.charAt(i);
			charCount[index]--;
		}

		for(int i=0; i<128; i++)
		{
			if(charCount[i]!=0)
			return false;
		}
		
		return true;
	}
}	