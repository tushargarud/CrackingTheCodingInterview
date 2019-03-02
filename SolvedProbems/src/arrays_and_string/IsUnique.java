package arrays_and_string;

public class IsUnique
{
	public static void main(String[] args)
	{
		System.out.println(isUniq(args[0]));
	}
	
	static boolean isUniq(String str)
	{
		boolean[] chars = new boolean[128];
		int index;
		for(char c : str.toCharArray())
		{
			index = c;
			if(index > 127)   
			{
				System.out.println("Error");
				return false;
			}
			else if(chars[index]==true)
				return false;
			else
				chars[index] = true;
		}
		return true;
	}
}