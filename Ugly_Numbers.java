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
import java.util.*;
public class Main {
    static int count = 0;
    static void FindSolution(String s, int cur_index, int start_index, boolean isPlus, int value){
        if(cur_index == s.length()-1){
            int temp =  Integer.parseInt(s.substring(start_index, cur_index+1));
            value = isPlus? value + temp: value - temp;
            if(value%2 == 0 || value%3 == 0 || value%5==0 || value%7 == 0){
                count++;
                System.out.println(value);
            }
            return;
        }
        //no mark
        FindSolution(s, cur_index+1, start_index, isPlus, value);
        //plus mark
        int temp = Integer.parseInt(s.substring(start_index, cur_index+1));
        if(!isPlus){
            temp = 0- temp;
        }
        FindSolution(s, cur_index+1, cur_index+1, true, value+temp);
        //substract
        FindSolution(s, cur_index+1, cur_index+1, false, value+temp);
    }
    public static void main (String[] args) {
        Scanner scanner = null;
        try{
            File file = new File(args[0]);
            scanner = new Scanner(file);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        while(scanner.hasNextLine()){
            String number = scanner.nextLine();
    	count = 0;
            FindSolution(number, 0, 0, true, 0);
            System.out.println(count);
        }
    }
  }
