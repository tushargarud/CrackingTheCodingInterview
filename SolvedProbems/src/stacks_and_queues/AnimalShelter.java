package stacks_and_queues;

import java.util.LinkedList;
import java.util.Iterator;

class Animal
{
	private String name;
	private String type;

	public Animal(String name, String type)
	{
		this.name=name;
		this.type=type;
	}

	public String getType()
	{
		return type;
	}

	public String toString()
	{
		return name;
	}

}

class AnimalQueue
{
	private LinkedList<Animal> ll;
	
	public AnimalQueue()
	{
		ll = new LinkedList<Animal>();
	}

	public void enqueue(Animal a)
	{
		ll.addLast(a);
	}
	
	public Animal dequeueAny()
	{
		return ll.removeFirst();
	}

	public Animal dequeueDog()
	{
		Iterator<Animal> itr = ll.iterator();
		while(itr.hasNext())
		{
			Animal a = itr.next();
			if(a.getType().equals("Dog"))
			{	
				itr.remove();
				return a;
			}
		}
		return null;
	}
		
	public Animal dequeueCat()
	{
		Iterator<Animal> itr = ll.iterator();
		while(itr.hasNext())
		{
			Animal a = itr.next();
			if(a.getType().equals("Cat"))
			{	
				itr.remove();
				return a;
			}
		}
		return null;
	}

	public boolean isEmpty()
	{
		return ll.isEmpty();
	}

}

public class AnimalShelter
{
	public static void main(String[] args)
	{
		AnimalQueue aniq = new AnimalQueue();
		aniq.enqueue(new Animal("Max", "Dog"));
		aniq.enqueue(new Animal("Lily", "Cat"));
		aniq.enqueue(new Animal("Bruno", "Dog"));
		aniq.enqueue(new Animal("Cardi", "Cat"));
		aniq.enqueue(new Animal("Drake", "Dog"));
		aniq.enqueue(new Animal("Gaga", "Cat"));

		while(!aniq.isEmpty())
			System.out.println(aniq.dequeueAny());
	}
}