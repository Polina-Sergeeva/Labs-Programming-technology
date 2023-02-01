import java.io.*;
import java.util.Arrays;
class EncodingConverter {
    
    public static void main (String [] args) {
         try(FileReader reader = new FileReader(args[0]))
        {
            char[] buf = new char[256];
            int c;
            while((c = reader.read(buf))>0){
                 
                if(c < 256){
                    buf = Arrays.copyOf(buf, c);
                }
                //System.out.print(buf);
            }
            String str = new String(buf);
            String inStr = new String(str.getBytes(), args[2]);
            try(FileWriter writer = new FileWriter(args[1]))
        {
            String strConverted = new String(inStr.getBytes(args[2]), args[3]);
            writer.write(strConverted);
        }
    
        catch(IOException ex){
         
            System.out.println(ex.getMessage());
        } 
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }
    }
}