package trees_graphs;

import java.util.HashMap;
import java.util.Deque;
import java.util.Set;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.List;

class Graph
{
	HashMap<Character, LinkedList<Character>> vMap;
	
	public Graph()
	{
		vMap = new HashMap<Character, LinkedList<Character>>();
	}

	public void addEdge(char a, char b)
	{
		if(vMap.get(a)==null)
		{
			LinkedList<Character> list = new LinkedList<Character>();
			list.add(b);
			vMap.put(a, list);
		}
		else
			vMap.get(a).add(b);	
	}

	public void print()
	{
		Set<Character> keys = vMap.keySet();
		for(Character k : keys)
		{
			System.out.print(k+" : ");
			for(Character c : vMap.get(k))
				System.out.print(c+" ");
			System.out.println();
		}
		
	}

	public boolean hasPathBFS(char a, char b)
	{
		if(a==b)
			return true;

		Deque<Character> queue = new LinkedList<Character>();
		Set<Character> visited = new HashSet<Character>();
		visited.add(a);
		queue.addLast(a);
		char temp;

		while(!queue.isEmpty())
		{
			temp = queue.removeFirst();
			List<Character> neighbours = vMap.get(temp);
			if(neighbours!=null)
			{
				for(Character c : neighbours)
				{
					if(!visited.contains(c))
					{	
						if(c==b)
							return true;
						visited.add(c);
						queue.addLast(c);
					}

				}
			}
		}
		return false;
	}

	public boolean hasPathDFS(char a, char b)
	{
		Set<Character> visited = new HashSet<Character>();
		return findDFS(a, b, visited);
	}

	public boolean findDFS(char a, char b, Set<Character> visited)
	{
		if(a==b)
			return true;

		visited.add(a);

		LinkedList<Character> list = vMap.get(a);
		if(list!=null)
		{
			for(Character c : list)
			{
				if(!visited.contains(c))
					if(findDFS(c,b,visited))
						return true;
			}
		}
		return false;
	}

}

public class RouteBetweenNodes
{
	public static void main(String[] args)
	{
		Graph g = new Graph();
		g.addEdge('a','e');
//		g.addEdge('b','c');
		g.addEdge('c','a');
//		g.addEdge('c','d');
		g.addEdge('d','b');
//		g.addEdge('d','e');
		g.addEdge('e','b');
		
		g.print();

		for(char c=97; c<102; c++) 
		{
			for(char d=97; d<102; d++)
			{
				System.out.print(g.hasPathBFS(c,d));
				System.out.println(g.hasPathDFS(c,d));
			}
		}		
	}
}