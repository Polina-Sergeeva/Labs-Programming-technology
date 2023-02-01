import java.util.Scanner;
import java.io.*;

public class FormattedInput {

    static Object[] sscanf(String format, String in) {
        Object[] objects = new Object[format.length() / 2];
        char[] tmp = format.toCharArray();
        String s[] = format.split(" ");

        for (int i = 0; i < s.length; i++) {
            //System.out.println(s[i]);
        }
        String s1[] = in.split(" ");

        for (int i = 0; i < s1.length; i++) {
           // System.out.println(s1[i]);
        }
        for (int j = 0; j < objects.length; j++) {
            for (int i = 0; i < s.length; i++) {
                switch (s[i]) {
                    case "%d":
                        //System.out.println("Your string: %d \n");

                        objects[j] = Integer.parseInt(s1[i]);
                        j++;
                        break;
                    case "%s":
                        //System.out.println("Your string: %s \n");

                        objects[j] = in;
                        j++;

                        return objects;
                    case "%c":
                       // System.out.println("Your string: %c \n");
                        char[] cur = s1[i].toCharArray();
                        objects[j] = cur[0];
                        j++;
                        break;
                    case "%f":
                        //System.out.println("Your string: %f \n");

                        objects[j] = Double.parseDouble(s1[i]);
                        j++;
                        break;
                    default:
                        System.out.println("Wrong format");

                        return null;
                }
            }
        }

        return objects;
    }
    static Object[] scanf(String format) {
        System.out.println("input your string: ");

        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        return sscanf(format, str);
    }
}
