class lab2 {
	public static void main (String[] args) {
		Matrix m1 = new Matrix (2);
		Matrix m2 = new Matrix (3);
		m1.setElement(0, 1, 1);
		m1.setElement(1, 1, 0);
		m1.setElement(1, 0, 1);
		m2.setElement(0, 0, 5);
		m2.setElement(1, 0, 3);
		m2.setElement(2, 0, 2);
		m2.setElement(0, 1, 1);
		m2.setElement(1, 1, 6);
		m2.setElement(2, 1, 1);
		m2.setElement(0, 2, 1);
		m2.setElement(1, 2, 1);
		System.out.println (m1.toString ());
		Matrix m3 = m1;
		System.out.println (m1.toString ());
		for (int i = 0; i < 9; i++) {
			m1 = m1.product (m3);
			System.out.println (m1.toString ());
		}
		System.out.println (m2.toString ());
		System.out.println (m2.doSortColumns().toString ());
		
	}
}