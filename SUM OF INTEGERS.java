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
                String[] lineArray = line.split(",");
                if (lineArray.length > 0) {
                    int sum = 0;
                    int max = 0;
                    for(int i = 0; i < lineArray.length; i++){
                        int t = Integer.parseInt(lineArray[i]);
                        sum += t;
                        if(sum < 0){
                            sum = 0;
                        }
                        else{
                            max = Math.max(sum, max);
                        }
                    }
                    System.out.println(max);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
