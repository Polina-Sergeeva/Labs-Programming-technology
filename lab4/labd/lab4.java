import list.*;

import java.util.Random;
import exceptions.*;

public class lab4 {
	public static void main (String[] args) {
		SortedIntegerList l = new SortedIntegerList (false);
		Random rand = new Random();
		//System.out.println ("Making list of 10 elements (no repeats)...");
		for (int i = 0; i < 10; i++) {
			int val = rand.nextInt () % 5;
			//System.out.println ("Add " + val + ":");
			l.add (val);
			//System.out.println (l);
		}
		SortedIntegerList l2 = new SortedIntegerList (false);
		//System.out.println ("Making list of 10 elements (with repeats)...");
		for (int i = 0; i < 10; i++) {
			int val = rand.nextInt () % 5;
			//System.out.println ("Add " + val + ":");
			l2.add (val);
			//System.out.println (l2);
		}
		SortedIntegerList l3 = new SortedIntegerList (false);
		try 
		{
			l3 = l.intersect(l2);
		}
		catch (ListException e) 
		{
			System.out.println (e.getMessage ());
		}
		System.out.println ("List 1: ");
		System.out.println (l);
		System.out.println ("List 2: ");
		System.out.println (l2);
		System.out.println ("List 3: ");
		System.out.println (l3);
		/*System.out.println ("Removing 5 random elements from first list...");
		for (int i = 0; i < 5; i++) {
			int val = rand.nextInt () % 5;
			System.out.println ("Remove " + val + ":");
			l2.remove (val);
			System.out.println (l2);
		}
		System.out.println(l.equals(null));*/
	}
}