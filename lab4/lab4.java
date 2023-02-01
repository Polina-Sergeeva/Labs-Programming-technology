import list.*;

import java.util.Random;

public class lab4 {
	public static void main (String[] args) {
		SortedIntegerList l = new SortedIntegerList (false);
		Random rand = new Random();
		System.out.println ("Making list of 10 elements (no repeats)...");
		for (int i = 0; i < 10; i++) {
			int val = rand.nextInt () % 5;
			System.out.println ("Add " + val + ":");
			l.add (val);
			System.out.println (l);
		}
		SortedIntegerList l2 = new SortedIntegerList (true);
		System.out.println ("Making list of 10 elements (with repeats)...");
		for (int i = 0; i < 10; i++) {
			int val = rand.nextInt () % 5;
			System.out.println ("Add " + val + ":");
			l2.add (val);
			System.out.println (l2);
		}
		System.out.println ("Removing 5 random elements from first list...");
		for (int i = 0; i < 5; i++) {
			int val = rand.nextInt () % 5;
			System.out.println ("Remove " + val + ":");
			l2.remove (val);
			System.out.println (l2);
		}
		System.out.println(l.equals(null));
	}
}