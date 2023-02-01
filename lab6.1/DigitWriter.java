import java.io.*;

public class DigitWriter extends FileWriter
{
	public DigitWriter(String f)throws IOException
	{
		super(f);
	}
	public void write(int c)throws IOException
	{	
		int i = 0;	
			switch(c)
			{
				case '0':
					super.write("zero");
					break;
				case '1':
					super.write("one");
					break;
				case '2':
					super.write("two");
					break;
				case '3':
					super.write("three");
					break;
				case '4':
					super.write("four");
					break;
				case '5':
					super.write("five");
					break;
				case '6':
					super.write("six");
					break;
				case '7':
					super.write("seven");
					break;
				case '8':
					super.write("eight");
					break;
				case '9':
					super.write("nine");
					break;
				//default:
					//super.append("Number not found");
			}	
	}
}