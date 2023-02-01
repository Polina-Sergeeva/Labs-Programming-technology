//умножение через сложение
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
	public Int negate (){
		value = -value;
		return this;
	}
	public Int mpn (int n){
		Int res = new Int ();
		if (n >= 0){
			for(int i = 0; i < n; i++)
			{
				res.value += value;
			}
			return res;
		}
		else {
			n = -n;
			for(int i = 0; i < n; i++)
			{
				res.value += value;
			}
			return res.negate();
		}
	}
	public String toString () {
		return "" + value;
	}
}