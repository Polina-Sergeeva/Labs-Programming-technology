import java.util.*;
import java.io.*;

public class FormattedInput {
    static Object[] scanf(String format) throws IOException {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        return sscanf(format, str);
  
    }

    static Object[] sscanf(String format, String in) throws IOException {
        List<Object> o = new ArrayList<>();
        int i = 0;
        int j = 0;
        char c;
        String[] lex = in.split(" ");
        boolean spec = false;
        while (i < format.length()) {
            c = format.charAt(i);
            if (c == '%') {
                spec = true;
                i++;
                c = format.charAt(i);
            }
            if (spec) {
                switch (c) {
                    case 'd':
                        if (check(lex[j], Types.INT.ordinal())){
                            int tmp = Integer.parseInt(lex[j]);
                            o.add(tmp);
                            j++;
                        } else {
                            System.out.println("int expected");
                            j++;
                        }
                        break;
                    case 'f':
                        if (check(lex[j], Types.DOUBLE.ordinal())){
                            double tmp = Double.parseDouble(lex[j]);
                            o.add(tmp);
                            j++;
                        } else {
                            System.out.println("double expected");
                            j++;
                        }
                        break;
                    case 's':
                        o.add(lex[j]);
                        j++;
                        break;
                    case 'c':
                        String s = lex[j];
                        o.add(s.charAt(0));
                        j++;
                        break;
                }
                spec = false;
            } /*else if (i == 0 && c != ' ') {
                throw new IOException ("Invalid specificators");
            } else if (c != ' ' && c != 'x' && c != 'b' && c != 'f' && c != 'd' && c != 'c' && c != 's') {
                throw new IOException ("Invalid specificators");
            } */else {
                while (c == ' ') {
                    i++;
                    c = format.charAt(i);
                }
                i--;
            }
            i++;
        }
        Object[] mas = new Object[o.size()];
        for (i = 0; i < o.size(); i++)
            mas[i] = o.get(i);
        return mas;
    }
    static boolean check(String in, int type) {
        int Int = Types.INT.ordinal();
        int Double = Types.DOUBLE.ordinal();
        int i = 0;
        if (type == Int) {
            while (i < in.length()) {
                if(in.charAt(i) < '0' || in.charAt(i) > '9' )
                    return false;
                i++;
            }
        } else if (type == Double) {
            while (i < in.length()) {
                if ((in.charAt(i) < '0' || in.charAt(i) > '9') && in.charAt(i) != '.')
                    return false;
                i++;
            }
        }
        return true;
    }

    public enum Types{
        INT, 
        DOUBLE;
    }
}
        //char c;
        //String num = new String();
        //for(int i = 0; i < str.length(); i++)
        //{
            //c = str.charAt(i);