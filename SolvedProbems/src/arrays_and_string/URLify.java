package arrays_and_string;

public class URLify
{
	public static void main(String[] args)
	{
		int len = Integer.parseInt(args[1]);
		String str = makeURL(args[0], len);
		System.out.println(str);
	}
	
	static String makeURL(String str, int len)
	{
		char[] chars = str.toCharArray();
		int j=chars.length-1;
		while(j>=0 && chars[j]==' ')
			j--;
		if(j<0)
			return str;

		int i;
		for(i=chars.length-1; i>=0 && j>=0 && j<i;)
		{
			if(chars[j]==' ')
			{
				chars[i]='0';
				chars[i-1]='2';	
				chars[i-2]='%';
				i-=3;
				while(chars[j]==' ' && j>=0)
					j--;
			}
			else				
				chars[i--] = chars[j--];
		}
		while(i!=0 && chars[i]!=' ')
			i--;
		String result = new String();
		return result.substring(i-1,chars.length-i);
	}
}