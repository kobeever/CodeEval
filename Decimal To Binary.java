/*Sample code to read in test cases:
public class Main {
    public static void main (String[] args) {
    ...
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
        String[] lineArray = line.split("\s");
        if (lineArray.length > 0) {
            //Process line of input Here
        }
    }
  }
}
*/
import java.io.*;
public class Main {
    public static void main (String[] args) {
        try{
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                int num = Integer.parseInt(line);
                if(num == 0){
                    System.out.println("0");
                    continue;
                }
                int bit = 1;
                StringBuffer sb = new StringBuffer();
                while(bit<=num){
                    if((bit & num) != 0){
                        sb.insert(0, '1');
                    }
                    else{
                        sb.insert(0, '0');
                    }
                    bit = bit << 1;
                }
                System.out.println(sb.toString());
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
  
}
