import java.util.Scanner;
public class lab6 {
    public static void main(String[] args) {
        FormattedInput f = new FormattedInput();

        //Object[] vals2 = f.sscanf("%f %d %c", "5.2 k c");
        Object[] vals = f.scanf("%z");
        System.out.println(vals.toString());

    }
}
