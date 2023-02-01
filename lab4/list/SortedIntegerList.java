package list;

import java.util.LinkedList;
import java.util.*;

public class SortedIntegerList {
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private boolean duplicateElements;
	public SortedIntegerList (boolean f) {
		duplicateElements = f;
	}
	public void add (int val) {
		ListIterator<Integer> iter = list.listIterator();
		while (iter.hasNext())
		{
			int elem = iter.next();
			if (elem == val)
			{
				if (duplicateElements)
				{	
					iter.previous();
					iter.add(val);
				}
				return;	
			}
			if (elem > val)
			{
				iter.previous();
				iter.add(val);
				return;
			}
		}
		list.add(val);
	}
	public void remove (int val)
	{
		ListIterator<Integer> iter = list.listIterator();
		while (iter.hasNext())
		{
	
				int elem = iter.next();
				if (elem == val)
				{
					iter.previous();
					iter.remove();
				}
				if (elem > val)
					return;
		}
	}
	@Override
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		if(obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SortedIntegerList other = (SortedIntegerList) obj;
		return list.equals(other.list);
	}	
	public String toString () {
		return list.toString ();
	}
}