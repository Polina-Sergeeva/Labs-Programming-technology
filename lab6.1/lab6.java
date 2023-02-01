import java.io.*;

public class lab6 {
	public static void main(String[] args) throws IOException
	{
		Object[] mas;
		String s = new String("33 33.33 slovo k");
		mas = FormattedInput.sscanf ("%d %f %s %c", s);
		for (int i = 0; i < mas.length; i++)
		    System.out.println (mas[i]);
		System.out.println("input your string:");
        mas = FormattedInput.scanf("%d %f %s %c");
        for (int i = 0; i < mas.length; i++)
            System.out.println(mas[i]);
        /*DigitWriter dw = new DigitWriter("output.txt");
		dw.write('7');
		dw.close();*/
	}
}
