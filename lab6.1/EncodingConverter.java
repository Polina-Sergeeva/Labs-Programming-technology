import java.util.*;
import java.io.*;

public class EncodingConverter
{
	public static void main (String[] args) throws IOException, UnsupportedEncodingException
	{
        if (args.length < 4)
            throw new IOException ("Too few arguments");
        else if (args.length > 4)
            throw new IOException ("Too many arguments");
		String infile = args[0]; 
    	String outfile = args[1];
    	String from = args[2];
    	String to = args[3];
    	InputStream in = new FileInputStream (infile);
 	    OutputStream out = new FileOutputStream(outfile);
    	Reader r = new BufferedReader (new InputStreamReader (in, from));
   		Writer w = new BufferedWriter (new OutputStreamWriter (out, to));
    	char[] buffer = new char[in.available ()];
    	int len;
    	while ((len = r.read (buffer)) != -1)
            w.write (buffer, 0, len);
    	r.close();
    	w.close(); 
	}
}