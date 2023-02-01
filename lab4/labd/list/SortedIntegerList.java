package list;

import exceptions.*;
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
	public SortedIntegerList intersect (SortedIntegerList l) throws ListException
	{
		if (this.duplicateElements != l.duplicateElements)
		{
			throw new ListException ("ERROR! Incorrect flags");
		}
		ListIterator<Integer> iter1 = this.list.listIterator();
		ListIterator<Integer> iter2 = l.list.listIterator();
		SortedIntegerList res = new SortedIntegerList (this.duplicateElements);
		while (iter1.hasNext() && iter2.hasNext())
		{
			int elem1 = iter1.next();
			int elem2 = iter2.next();
			if (elem1 < elem2)
			{
				iter2.previous();
			}
			if (elem1 > elem2)
			{
				iter1.previous();
			}
			if (elem1 == elem2)
			{
				res.list.addLast(elem1);
			}
		}
		return res;
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