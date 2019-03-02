package arrays_and_strings;

//This code is not working
public class OneAway
{
	public static void main(String[] args)
	{
		System.out.println(checkOneAway(args[0],args[1]));
	}

	public static String checkOneAway(String str1, String str2)
	{
		String longer = str1.length() > str2.length() ? str1 : str2;
		String shorter = str2.length() < str1.length() ? str2 : str1;

		if(Math.abs(str1.length() - str2.length())>1)
			return "Lengths are different. Not one away";

		
		boolean oneDiffFound=false;
		for(int i=0, j=0; i<longer.length() && j<shorter.length();)
		{
			if(longer.charAt(i)!=shorter.charAt(j))
			{
				if(oneDiffFound || i!=j)
					return "Not one away";

				oneDiffFound=true;
				i++;
				if(longer.charAt(i)!=shorter.charAt(j))
					j++;
			}
			else
			{
				i++;
				j++;
			}
		}
		
		return "Strings are one diff away";
	}
}