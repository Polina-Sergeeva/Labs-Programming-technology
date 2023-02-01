public class lab1 {
	public static void main (String[] args) {
		Int num1 = new Int ();
		Int num2 = new Int ();
		System.out.println (num1.increment ().tostring ());
		System.out.println (num2.decrement ().tostring ());
		System.out.println (num1.add (num2).tostring ());
		System.out.println (num2.subtract (num1).tostring ());
		Int num3 = new Int ();
		for (int i = 0; i < 1000 ; i++ ) {
			num3.increment ();
		}
		num3.add(num3).tostring();
		System.out.println (num3.add(num3).tostring());
	}
}