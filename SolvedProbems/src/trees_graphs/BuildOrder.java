package trees_graphs;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collection;

public class BuildOrder
{
	public static void main(String[] args)
	{
		Set<Character> projects = new HashSet<Character>();
		projects.add('a');
		projects.add('b');
		projects.add('c');
		projects.add('d');
		projects.add('e');
		projects.add('f');

		Map<Character, LinkedList<Character>> dependents = new HashMap<Character, LinkedList<Character>>();
		
		LinkedList<Character> temp;
		temp = new LinkedList<Character>();
		temp.add('a');
		temp.add('b');
		dependents.put('d',temp);

		temp = new LinkedList<Character>();
		temp.add('f');
		dependents.put('b',temp);

		temp = new LinkedList<Character>();
		temp.add('f');
		dependents.put('a',temp);

		temp = new LinkedList<Character>();
		temp.add('d');
		dependents.put('c',temp);

		for(Object c: getBuildOrder(projects, dependents))
			System.out.println(c + " ");
	}

	public static Object[] getBuildOrder(Set<Character> projects, Map<Character, LinkedList<Character>> dependents)
	{
		Set<Character> independents = new LinkedHashSet<Character>();
		Iterator<Character> itr = projects.iterator();		
		while(itr.hasNext())
		{
			Character cur = itr.next();
			if(dependents.get(cur)==null)
				remove(cur, dependents, independents);
		}

		boolean mapChanged=true;
		while(mapChanged)
		{
			mapChanged=false;
			for(Character c : dependents.keySet())
			{
				if(dependents.get(c)!=null && dependents.get(c).size()==0)
				{
					mapChanged=true;
					remove(c, dependents, independents);
					break;
				}
			}

		}
		
		if(independents.size()==projects.size())
			return independents.toArray();
		else
			return null;
	}

	public static void remove(Character c, Map<Character, LinkedList<Character>> dependents, Set<Character> independents)
	{
		dependents.remove(c);
		independents.add(c);

		Collection<LinkedList<Character>> lists = dependents.values();
		for(LinkedList<Character> list : lists)
			list.remove(c);
	}
}