public class lab1 {
	public static void main (String[] args) {
		Int num1 = new Int ();
		Int num2 = new Int ();
		System.out.println (num1.increment ().toString ());
		System.out.println (num2.decrement ().toString ());
		System.out.println (num1.add (num2).toString ());
		System.out.println (num2.subtract (num1).toString ());
		Int num3 = new Int ();
		for (int i = 0; i < 1000; i++ ) {
			num3.increment ();
		}
		System.out.println (num3.toString());
		Int num4 = new Int ();
		Int num5 = new Int ();
		num4.decrement();
		num4.decrement();
		num4.decrement();
		num4.decrement();
		num5.increment();
		num5.increment();
		num5.increment();
		System.out.println (num4.toString ());
		System.out.println (num5.toString ());
		System.out.println (num4.mpn(4).toString());
	}
}