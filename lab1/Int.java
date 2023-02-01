class Int {
	private int value = 0;
	public Int increment () {
		value++;
		return this;
	}
	public Int decrement () {
		value--;
		return this;
	}
	public Int add (Int n) {
		Int res = new Int ();
		res.value = value + n.value;
		return res;
	}
	public Int subtract (Int n) {
		Int res = new Int ();
		res.value = value - n.value;
		return res;
	}
	public String tostring () {
		return "" + value;
	}
}