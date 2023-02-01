import java.util.Scanner;
import java.lang.Math;
import java.lang.StrictMath;
import java.text.DecimalFormat;


public class Main{
	public static void main(String[] args){
		float f;
		f = Float.parseFloat(new Scanner(System.in).nextLine());
		//f = (float)(1./.0);
		int exp = Math.getExponent(f);
		System.out.println("Exp:");
		System.out.println(exp);
		float mantissa = getMantissa(f);
		System.out.println("Mantissa:");
		System.out.println(mantissa);
		float a = 1*(2^(exp))*mantissa;
		float b = -1*(2^(exp))*mantissa;
		System.out.println("1*(2^(exp))*mantissa");
		System.out.println(a);
		System.out.println("-1*(2^(exp))*mantissa");
		System.out.println(b);
	}

	public static float getMantissa(float x) {
        int exponent = Math.getExponent(x);
        return (float)(x / Math.pow(2, exponent));
    }
}